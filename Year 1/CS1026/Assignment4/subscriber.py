# CS1026 - ASSIGNMENT 4
# RIA HAQUE - 251164501
# This program contains the Subscriber class that represents subscribers of a streaming service.



class Subscriber:

    def __init__(self, name='', userid='', password=''):
        """
        Constructor for Subscriber class
        :param name: string, subscriber name
        :param userid: string, their username
        :param password: string, subscriber password
        """
        self._name = name
        self._userid = userid
        self._password = password

    def get_name(self):
        """
        Getter for subscriber name
        :return: string, subscriber name
        """
        return self._name

    def get_id(self):
        """
        Getter for subscriber username
        :return: string, subscriber username
        """
        return self._userid

    def get_password(self):
        """
        Getter for subscriber password
        :return: a string, subscriber password
        """
        return self._password

    def set_name(self, name):
        """
        Setter for subscriber name
        :param name: string, new subscriber name
        :return: none
        """
        self._name = name

    def set_id(self, userid):
        """
        Setter for subscriber username
        :param userid: string, new subscibrer username
        :return: none
        """
        self._userid = userid

    def set_password(self, password):
        """
        Setter for subscriber password
        :param password: string, new password
        :return: none
        """
        self._password = password

    def __repr__(self):
        """
        Returns a string that can be used to rebuild a Subscriber object
        :return: string, representation of Subsciber object
        """
        return f'Subscriber("{self._name}", "{self._userid}", "{self._password}")'


# TESTS
#bill = Subscriber('Bill', 'Ted_is_my_dude', 'b2exc3llent')
#print(bill)
#bill2 = bill.__repr__()
#print(bill2)
