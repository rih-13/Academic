# CS1026 - ASSIGNMENT 4
# RIA HAQUE - 251164501
# This program contains the StreamingService class which is used to represent streaming services.



from program import Program
from subscriber import Subscriber
from pprint import pprint


class StreamingService:
    """
    Represents streaming services
    """
    def __init__(self, name='', program_list=None, subscriber_list=None):
        """
        Constructor for streaming service
        :param name: string, name
        :param program_list: list of Program objects
        :param subscriber_list: list of Subscriber objects
        """
        if program_list is None:
            program_list = []
        if subscriber_list is None:
            subscriber_list = []
        self._name = name
        self._programs = program_list
        self._subscribers = subscriber_list

    # GETTERS
    def get_name(self):
        """
        Gets StreamingService name
        :return: string, StreamingService name
        """
        return self._name

    def get_programs(self):
        """
        Gets StreamingService list of programs
        :return: list of Program objects
        """
        return self._programs

    def get_subscribers(self):
        """
        Gets StreamingService list of subscribers
        :return: list of Subscriber objects
        """
        return self._subscribers

    def get_program(self, title):
        """
        Returns Program object if in list of programs, otherwise none
        :param title: title of Program
        :return: Program object if found, otherwise none
        """
        for program in self._programs:
            if program.get_title() == str(title):
                return (program)
        else:
            return None

    def get_subscriber(self, name):
        """
        Returns Program object if in list of subscribers, otherwise none
        :param name: name of Subscriber
        :return: Subscriber object if found, otherwise none
        """
        for subscriber in self._subscribers:
            if subscriber.get_name() == str(name):
                return subscriber
        else:
            return None

    # SETTERS
    def set_name(self, name):
        """
        Sets StreamingService name
        :param name: string, name
        :return: none
        """
        self._name = name

    # REMOVE AND ADD
    def add_program(self, program):
        """
        Adds to list of  StreamingService programs
        :param program: Program object
        :return: none
        """
        self._programs.append(program)

    def add_subscriber(self, subscriber):
        """
        Adds to list of StreamingService subscribers
        :param subscriber: Subscriber object
        :return: none
        """
        self._subscribers.append(subscriber)

    def remove_program(self, title):
        """
        Removes from list of  StreamingService programs
        :param title: title of program to be removed, string
        :return: none
        """
        for program in self._programs:
            if program.get_title() == title:
                self._programs.remove(program)

    def remove_subscriber(self, name):
        for subscriber in self._subscribers:
            if subscriber.get_name() == name:
                self._subscribers.remove(subscriber)

    def update_program(self, title, genre, creator, date):
        for program in self._programs:
            if program.get_title() == str(title):
                if genre != '':
                    program.set_genre(genre)
                if creator != '':
                    program.set_creator(creator)
                if date != '':
                    program.set_date(date)

    def update_subscriber(self, name, userid, password):
        for subscriber in self._subscribers:
            if subscriber.get_name() == str(name):
                if userid != '':
                    subscriber.set_id(userid)
                if password != '':
                    subscriber.set_password(password)

    def sort(self):
        """
        Sorts the program and subscriber lists for a StreamingService object
        :return: a StreamingService object with sorted program and subscriber lists
        """
        programSort = []
        subscriberSort = []
        for program in self._programs:
            programSort.append(program._title)
        for subscriber in self._subscribers:
            subscriberSort.append(subscriber._name)
        programSort.sort()
        subscriberSort.sort()
        sortedStreamingService = StreamingService(self._name, None, None)
        for title in programSort:
            for program in self._programs:
                if program._title == title:
                    sortedStreamingService._programs.append(Program(program.get_title(),
                                                                    program.get_genre(),
                                                                    program.get_creator(),
                                                                    program.get_release_date()))
        for name in subscriberSort:
            for subscriber in self._subscribers:
                if subscriber._name == name:
                    sortedStreamingService._subscribers.append(Subscriber(subscriber.get_name(),
                                                                          subscriber.get_id(),
                                                                          subscriber.get_password()))
        return sortedStreamingService

    def __repr__(self):
        return f'StreamingService("{self._name}", {self._programs}, {self._subscribers})'


#guardiansofthegalaxy = Program('Guardians of the Galaxy', 'Sci-Fi', 'James Gunn', '2014')
#wandavision = Program('WandaVision', 'Sci-Fi', 'Jac Schaeffer', '2021')
#hiddenfigures = Program("Hidden Figures", 'Drama', 'Theodore Melfi', '2016')
#walt = Subscriber('Walt', 'thefounder', '133t')
#stan = Subscriber('Stan', 'thewriter', 'lee1922')

#disneyplus = StreamingService('Disney+', [guardiansofthegalaxy, wandavision], [walt, stan])
#disneyplus.add_program(hiddenfigures)
#disneyplus.update_program('Hidden Figures', '', '', '2019')
#disneyplus.update_subscriber('Walt', '', 'newpassword')
#pprint(disneyplus)
#pprint(disneyplus.sort())

