# CS1026 - ASSIGNMENT 4
# RIA HAQUE - 251164501
# This program asks a user to input csv files to create and/or update streaming service information. The updated
# information is written to a new file with a name of their choosing. At any point, the user can choose to exit the
# program. Errors in file names, user input, or within the files themselves are indicated to the user.



from file_processing import *


def exit_program():
    """
    This function prints a short message to the user and then exits the program.
    :return: none
    """
    print("Exiting program...")
    exit()

yes_no = input("Would you like to update a file? Y/N\n").lower()
repeat = True
while repeat:
    try:
        if yes_no == 'y':
            invalid_name = True
            while invalid_name:
                file_name = input("Please enter the streaming service creation file (or 'done') to exit)\n")
                if file_name.lower() == 'done':
                    exit_program()
                newService = build_new_service(file_name)
                if newService is None:
                    print("Error in file contents or file name. Please try again.")
                else:
                    invalid_name = False

            invalid_update = True
            while invalid_update:
                update_name = input("PLease enter the update file you would like to read (or 'done' to exit):\n")
                if update_name.lower() == 'done':
                    exit_program()
                updated_service = update_service(update_name, newService)
                if updated_service is None:
                    print("Error in file contents or file name. Please try again.")
                else:
                    invalid_update = False
                    updated_service = updated_service.sort()

            new_name = input("Please enter the name of the new file to be written:\n")
            if new_name.lower() == 'done':
                exit_program()
            write_update(new_name, updated_service)
            yes_no = input("Would you like to update a file? Y/N\n").lower()
        elif yes_no == 'n':
            print("Exiting program...")
            exit_program()
        else:
            raise ValueError
    except ValueError:
        print('Invalid input. Please try again.')
        yes_no = input("Would you like to enter another set of files? Y/N\n").lower()
    except NameError:
        print("Error in file contents or file name. Please try again.")
        yes_no = input("Would you like to enter another set of files? Y/N\n").lower()