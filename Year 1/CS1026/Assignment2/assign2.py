#CS1026 Assignment 2
#Main program, user input and output, calls area calculation functions 
from typing import List, Any

import area_calculation

def is_valid_shape(in_value):
    '''is_valid_shape: function takes in an input, in_value, and returns True if the input is a valid input
    for this program or False if the input is invalid
    Parameters: in_value
    Return Value: True or False
    '''
    validVal = ('rectangle', 'ellipse', 'trapezoid', 'done') #provide valid input values
    #Check if in_value is included in the valid input values
    if in_value in validVal:
        return True
    if in_value not in validVal:
        return False

def main():
   """main: takes no parameters, asks user what shape to calculate and evaluates if shape is possible for program.
    if invalid, prompts the user again
    if valid, asks for shape dimensions and prints area to two decimal places
    Once user indicates they are done, prints all calculated areas from smallest to largest"""
   shape = str(input("What shape would you like to calculate?\n").lower())
   areaList = []
   while shape != "done":
        if is_valid_shape(shape) == True: #if shape is valid, calculate area and add to list
            if shape == "ellipse":
                major = float(input("What is the major radius of the ellipse?\n"))
                minor = float(input("What is the minor radius of the ellipse?\n"))
                result = area_calculation.ellipse_area(major,minor)
                result = round(result, 2)
                areaList.append(result)
                print(f"The calculated area is {result}\n")

            if shape == "trapezoid":
                top = float(input("What is the length of the trapezoid's top?\n"))
                bottom = float(input("What is the length of the trapezoid's bottom?\n"))
                height = float(input("What is the trapezoid's height?\n"))
                result = area_calculation.trapezoid_area(top, bottom, height)
                result = round(result, 2)
                areaList.append(result)
                print(f"The calculated area is {result}\n")

            if shape == "rectangle":
                base = float(input("What is the length of the rectangle's base?\n"))
                height = float(input("What is the height of the rectangle?\n"))
                result = area_calculation.rectangle_area(base,height)
                result = round(result, 2)
                areaList.append(result)
                print(f"The calculated area is {result}\n")

            shape = str(input("What shape would you like to calculate?\n").lower())

        else: #if shape input is not valid, ask again
            print("Sorry, but that shape doesn't exist in our system. Please try again\n")
            shape = str(input("What shape would you like to calculate?\n").lower())

    #If the user inputs 'done'
   areaList = sorted(areaList)
   print("Thanks for using this program! Here is a list of the areas that we calculated for you: \n\n" + str(areaList))





main()