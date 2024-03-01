
#Assignment One - CS1026
#Rifah Haque


#Part One - Name
name = input("What is your first name? ")
surname = input("What is your last name? ")
print("YOUR NAME IS " + name.upper() + " " + surname.upper() + ".")

# Part Two - User Input for Integers
int_one = int(input("Enter an integer: "))
int_two = int(input("Enter an integer: "))
int_three = int(input("Enter an integer: "))

#Check One: if the first number is larger than the second and the second is larger than the third
if int_one > int_two and int_two > int_three:
    print(str(int_one) + " is larger than " + str(int_two) + ", which is greater than " + str(int_three) + ".")

#Check Two (if Check One not met): if sum of second/third number is greater than first and second does not equal third
elif int_two + int_three > int_one and int_two != int_three:
    print(str(int_two) + " + " + str(int_three) +" is greater than " + str(int_one) + ", and " + str(int_two) +
    " is not equal to " + str(int_three) + ".")

#Check Three (if both not met): if any numbers are even
#if even, divide by two to find how many times and print message with this information
elif int_one % 2 == 0 or int_two % 2 == 0 or int_three % 2 == 0:
    if int_one % 2 == 0:
        div_one = int(int_one/2)
        print(str(int_one) + " is divisible by 2, " + str(div_one) + " time(s).")
    if int_two % 2 == 0:
        div_two = int(int_two/2)
        print(str(int_two) + " is divisible by 2, " + str(div_two) + " time(s).")
    if int_three % 2 == 0:
        div_three = int(int_three / 2)
        print(str(int_three) + " is divisible by 2, " + str(div_three) + " time(s).")

#If none of the conditions are true, print a short message
else:
    print("None of the conditions were true.")