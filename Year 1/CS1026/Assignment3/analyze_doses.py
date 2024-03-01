# CS1026 - Assignment 3
# Ria Haque - 251164501
# This program allows users to analyze files containing a comma-separated date and amount of vaccinations on each line.
# It creates a new file (vaccine_stats.txt) that contains the total amount of doses, and the dates and dose counts of
# weeks with maximum and minimum vaccinations.


import csv
from pprint import pprint


def minimum(weeklyList):
    """
    This function takes in a list of tuples that contain a date and count of something, ie. vaccinations.
    It finds the minimum count and corresponding date and returns both in a tuple.
    Parameters: a list containing a tuple for each week, containing the date and dose count for that week
    Return Value: a tuple containing the date and dose count of the week with least vaccinations
    """

    smallest = 100000000
    for week in weeklyList:
        if week[1] < smallest:
            smallest = week[1]
            min_week = week
    return min_week



def maximum(weeklyList):
    """
    This function takes in a list of tuples that contain a date and count of something, ie. vaccinations.
    It finds the maximum count and corresponding date and returns both in a tuple.
    Parameters: a list containing a tuple for each week, containing the date and dose count for that week
    Return Value: a tuple containing the date and dose count of the week with most vaccinations
    """

    biggest = 0
    for week in weeklyList:
        if week[1] > biggest:
            biggest = week[1]
            max_week = week
    return max_week



def total_vaccinations(weeklyList):
    """
    This function takes in a list of tuples that contain a date and count of something, ie. vaccinations.
    It calculates the sum of all weeks and returns this.
    Parameters: a list containing a tuple for each week, containing the date and dose count for that week
    Return Value: an integer, the number of total vaccinations
    """

    total_doses = 0
    for week in weeklyList:
        total_doses += week[1]
    return(total_doses)



def main():
    """
    This function takes in no parameters and has no return value. It asks the user to input a file name, which it opens.
    It reads the rows of the file into a list that contains a tuple for each row consisting of the date and weekly dose
    count. It computes the maximum, minimum, and total dose counts and prints this into a new file (vaccine_stats.txt).
    """

    totals_weeks = []

    with open('doses.csv', 'r') as input_file:
        reader = csv.reader(input_file, delimiter=',')
        for row in reader:
            row = (row[0], int(row[1]))
            totals_weeks.append(tuple(row))
    minimum_result = minimum(totals_weeks)
    maximum_result = maximum(totals_weeks)
    total_result = total_vaccinations(totals_weeks)
    pprint(totals_weeks, width=30)

    with open('vaccine_stats.txt', 'w') as output_file:
        output_file.write('Total doses: ' + str(total_result) + '\n'
                           'Minimum date: ' + str(minimum_result[0]) +', Doses: ' + str(minimum_result[1]))
        output_file.write('\nMaximum date: ' + str(maximum_result[0]) + ', Doses: ' + str(maximum_result[1]) +'\n')






main()