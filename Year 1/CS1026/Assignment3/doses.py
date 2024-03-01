# CS1026 - Assignment 3
# This program uses user input to open a specific file. It then provides a new file (doses.txt) that contains in
# each row a date and total number of vaccinations across all types of sites, combining multiple entries of the same
# week.



import csv
from pprint import pprint


def count_doses_by_date(doseList):
    """
    This function takes in a list of vaccinations administered at different sites and returns an integer, the total
    number of vaccinations across all sites. The entries in the list are processed for empty strings and extra commas.
    Parameter: a list containing numbers of vaccinations at different sites during a certain time
    Return Values: an integer, number of vaccinations across all sites during that time
    """

    # get rid of commas and empty strings
    doseList = [element.replace(',', '') for element in doseList]
    doseList = [int(element) if element else 0 for element in doseList] #convert to int if not already

    total = sum(doseList)
    return (total)


def main():
    """
    This function has no parameters or return value. It asks the user to input a file name and reads the data into
    a dictionary with the dates as keys. Multiple entries for the same date are added together as one. It
    writes to a new file (doses.csv) with each row consisting of the date and total vaccinations for all sites.
    """

    doses = dict()

    file_name = str(input("Which file would you like to consider?\n"))
    with open(file_name, 'r') as input_file:
        input_file.readline() # header
        reader = csv.reader(input_file, delimiter=',')

        for date in reader:
            if date[0] not in doses.keys():
                doses[str(date[0])] = [str(date[1]), str(date[2]), str(date[3]), str(date[4]), str(date[5])]
            else:
                doses[str(date[0])] = [element.replace(',', '') for element in doses[str(date[0])]] #get rid of commas

                # add dose counts of two entries that share a date
                doses[str(date[0])][0] = str(int(date[1]) + int(doses[str(date[0])][0]))
                doses[str(date[0])][1] = str(int(date[2]) + int(doses[str(date[0])][1]))
                doses[str(date[0])][2] = str(int(date[3]) + int(doses[str(date[0])][2]))
                doses[str(date[0])][3] = str(int(date[4]) + int(doses[str(date[0])][3]))
                doses[str(date[0])][4] = str(int(date[5]) + int(doses[str(date[0])][4]))

    pprint(doses, width= 100)

    with open('doses.csv', 'w') as output_file:
        for date in doses.keys():
            output_file.write(f"{str(date)},{str(count_doses_by_date(doses[date]))}\n")

    for date in doses.keys():
        print(f"Date: {date}\n"
              f"Doses: {doses[date]}")






main()
