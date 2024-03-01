# CS1026 - ASSIGNMENT 4
# RIA HAQUE - 251164501
# This program contains the Program class which is used to handle program objects for a streaming service. It includes
# functions to add, remove, or update programs.

class Program:
    """
    A class to represent programs (ie. movies, TV shows) available on a streaming service
    """

    def __init__(self, title='', genre='', creator='', date=''):
        """
        Constructor for Program class
        :param title: a string, program title
        :param genre: a string, genre of program
        :param creator: a string, creator of program
        :param date: a string, year program was released
        """
        self._title = title
        self._genre = genre
        self._creator = creator
        self._date = date

    def get_title(self):
        """
        Getter for Program title
        :return: Program title
        """
        return self._title

    def get_genre(self):
        """
        Getter for Program genre
        :return: Program genre
        """
        return self._genre

    def get_creator(self):
        """
        Getter for Program creator
        :return: Program creator
        """
        return self._creator

    def get_release_date(self):
        """
        Getter for Program release date
        :return: Program release date
        """
        return self._date

    def set_title(self, title):
        """
        Setter for Program title
        :param title: string, updated Program title
        :return: none
        """
        self._title = title

    def set_genre(self, genre):
        """
        Setter for Program genre
        :param genre: string, updated Program genre
        :return: none
        """
        self._genre = genre

    def set_creator(self, creator):
        """
        Setter for Program creator
        :param creator: string, updated Program creator
        :return: none
        """
        self._creator = creator

    def set_date(self, date):
        """
        Setter for Program release date
        :param date: string, Program release date
        :return: none
        """
        self._date = date

    def __repr__(self):
        """
        Returns a string that can be used to rebuild a Program object
        :return: string, representation of Project object
        """
        return (f'Program("{self._title}", "{self._genre}", "{self._creator}", "{self._date}")')


#TESTS
#matrix = Program("Matrix; The", "Sci-Fi", "The Wachowskis", "1999")
#print(matrix)