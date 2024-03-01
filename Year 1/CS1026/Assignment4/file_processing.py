# CS1026 - ASSIGNMENT 4
# RIA HAQUE - 251164501
# This program contains functions needed for processing the csv files on streaming service data, for building the
# object, to updating and writing to a new file.




import csv
from streaming_service import *
from program import *
from subscriber import *


def build_new_service(datafile):
    """
    This function uses the data from a csv file to create a StreamingService object, or returns None if the file name
    cannot be found.
    :param datafile: a csv file containing information on a streaming service's program and subscribers, separated by
    two headers
    :return: a StreamingService object built from the information in the csv file, None if the file cannot be found
    """
    new_service = StreamingService()

    try:
        with open(datafile, 'r') as input_file:
            reader = csv.reader(input_file)
            name = next(reader)[0].title()
            new_service.set_name(name)
            next(reader)  # programs header

            for line in reader:
                try:
                    new_program = Program(line[0], line[1], line[2], line[3])
                    print(f'Adding Program...{new_program.get_title()}')
                    new_service.add_program(new_program)
                except (TypeError,IndexError):
                    if line[0] != 'SUBSCRIBERS':
                        new_subscriber = Subscriber(line[0], line[1], line[2])
                        print(f'Adding subscriber...{new_subscriber.get_name()}')
                        new_service.add_subscriber(new_subscriber)
        return new_service
    except FileNotFoundError:
        return None


def update_service(update_file, old_service):
    """
    This function will use a csv file with any changes made to a streaming service and update the given StreamingService
    object. If an update is made to a program or subscriber that is not found, it returns None.
    :param update_file: a csv file containing information on any changes to be made to the streaming service's data in
    the StreamingService object
    :param old_service: the StreamingService object that is to be updated
    :return: a new StreamingService object with any changes outlined if update file is valid or None if a program or
    subscriber update is applied to one that doesn't exist
    """
    updated_service = StreamingService(old_service.get_name(), old_service.get_programs(), old_service.get_subscribers())
    try:
        with open(update_file, 'r') as input_file:
            reader = csv.reader(input_file)
            name = next(reader)[0].title()
            updated_service.set_name(name)
            next(reader)  # programs header

            subs = False
            for line in reader:
                if line[0] == 'SUBSCRIBERS':
                    subs = True
                if not subs:
                    title = line[1]
                    if line[0] == '+':
                        new_program = Program(title, line[2], line[3], line[4])
                        print(f'Adding program...{title}')
                        updated_service.add_program(new_program)
                    elif line[0] == '-':
                        if updated_service.get_program(title) is None:
                            raise NameError
                        updated_service.remove_program(title)
                        print(f'Removing program...{title}')
                    elif line[0] == '^':
                        if updated_service.get_program(title) is None:
                            raise NameError
                        updated_service.update_program(title, line[2], line[3], line[4])
                        print(f'Updating program...{title}')
                else:
                    if line[0] != 'SUBSCRIBERS':
                        name = line[1]
                        if line[0] == '+':
                            new_subscriber = Subscriber(name, line[2], line[3])
                            updated_service.add_subscriber(new_subscriber)
                            print(f'Adding subscriber...{name}')
                        elif line[0] == '-':
                            if updated_service.get_subscriber(name) is None:
                                raise NameError
                            updated_service.remove_subscriber(name)
                            print(f'Removing subscriber...{name}')
                        elif line[0] == '^':
                            if updated_service.get_subscriber(name) is None:
                                raise NameError
                            updated_service.update_subscriber(name, line[2], line[3])
                            print(f'Updating subscriber...{name}')
        return updated_service
    except FileNotFoundError:
        return None
    except NameError:
        print('Error in update file. Please try again.')
        return None

def write_update(filename, service):
    """
    This function will create a new csv file documenting the updated streaming service.
    :param filename: the name of the csv file to be created and/or written to with updated streaming service information
    :param service: the StreamingService object whose information will be written into the file
    :return: none
    """
    with open (filename, 'w') as output_file:
        output_file.write(service.get_name().upper()) #service name
        output_file.write('\nPROGRAMS\n')
        for program in service.get_programs():
            output_file.write(f'{program.get_title()},{program.get_genre()},{program.get_creator()},{program.get_release_date()}\n')
        output_file.write('SUBSCRIBERS\n')
        for subscriber in service.get_subscribers():
            output_file.write(f'{subscriber.get_name()},{subscriber.get_id()},{subscriber.get_password()}\n')
        print(f'Writing updates to {filename}')


