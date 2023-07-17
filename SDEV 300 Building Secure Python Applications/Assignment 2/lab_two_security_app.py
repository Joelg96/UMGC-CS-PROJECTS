""" This application is designed to use calculate percentage, solve a triangle, date/time,
  volume of a cylinder, and password using command line prompts."""
import math
import datetime
import random
import string
import sys

print("\t##### Welcome To Security and Math Calculator #####")


def generate_password(password_length, has_upper, has_lower, has_number, has_symbol):
    """ This function is to allow user to create a secure password."""
    print("\tLet\'s Get Started!...\n")

    # prompt user to enter desired password length.
    password_length = int(input("Enter Desired Password Length: "))
    while password_length <= 0:
        password_length = int(input("Please enter a password length greater than zero! Try Again"))

    # If user wants upper case. #pylint: disable=line-too-long
    has_upper = input("Would you like your password to include upper case letters? (Y) yes (N) no?: ").upper()
    if has_upper == "Y":
        has_upper = string.ascii_uppercase
    if has_upper == "N":
        has_upper = ""

    # If user wants lower case.
    has_lower = input("Would you like your password to include lower case letters? (Y) yes (N) no?:").upper()
    if has_lower == "Y":
        has_lower = string.ascii_lowercase
    if has_lower == "N":
        has_lower = ""

    # If user wants numbers.
    has_number = input("Would you like your password to include numbers? (Y) yes (N) no?:").upper()
    if has_number == "Y":
        has_number = string.digits
    if has_number == "N":
        has_number = ""
    # If user wants special characters.
    has_symbol = input("Would you like your password to include special characters? (Y) yes (N) no?:").upper()
    if has_symbol == "Y":
        has_symbol = string.punctuation
    if has_symbol == "N":
        has_symbol = ""

    characters = has_lower + has_upper + has_number + has_symbol

    if characters == "":
        print("\tUnfortunately, it is not possible to have a blank password. Please try again!")

    password = "".join(random.sample(characters, password_length))

    print("\t****Your generated password is: " + password)


def percentage():
    """ This function is to calculate percentage based on user input such as numerator
    denominator and decimal places."""
    # Calculate percentage based on user input.
    try:
        numerator = float(input("Enter numerator: "))
        denominator = float(input("Enter denominator: "))
        decimal = int(input("Enter number of decimals places: "))
        result_percent = round((numerator / denominator) * 100, decimal)
        print(f"The calculated percentage is: {result_percent}%")
    except ValueError:
        print("\tInvalid input! Try again...")


def days_til_2025():
    """ This function is to calculate today's date until July 4, 2025 """
    print("\tLet\'s see how many days until the 4th of July, 2025...\n")
    # Subtract dates to get differance.
    future_date = datetime.date(2025, 7, 4)
    present_date = datetime.date.today()
    delta = future_date - present_date
    print(delta.days, "days")


def leg_of_triangle(side_a, side_b, angle_of_c):
    """ This function is to calculate"""
    print("\tOkay, Enter the triangle sides...\n")
    # Get sides of triangle.
    side_a = int(input("Enter Side a: "))
    side_b = int(input("Enter side b: "))
    angle_of_c = int(input("Enter angle C (radians): "))

    # Calculate
    formula = round((side_a**2) + (side_b**2) - (2 * side_a * side_b) * (math.cos(angle_of_c)))
    side_c = math.sqrt(formula)
    print("Measurement of side c is: ", side_c)


def volume(radius, height):
    """ This function is to calculate the volume of a cylinder."""
    # Get user input for height and radius.
    radius = int(input("Enter the radius of the cylinder: "))
    height = int(input("Enter the height of the cylinder: "))

    # Calculate cylinder volume using formula.
    math_pi = math.pi
    cylinder_volume = math_pi * radius ** 2 * height
    print("The volume of the cylinder is:", cylinder_volume)
    return cylinder_volume


def main_menu():
    """ This function is to display main menu options."""
    while True:
        print("# Please select an option from the following menu. #")
        print("(1) Generate Secure Password")
        print("(2) Calculate and Format Percentage")
        print("(3) Number Days from Current Date to July 4, 2025")
        print("(4) Calculate Leg of Triangle")
        print("(5) Calculate Volume of Right Circular Cylinder")
        print("(6) Exit Program")

        # Get User's choice.
        choice = int(input("\nEnter Selection Here (1-6): "))
        if choice == 1:
            generate_password(password_length=0, has_upper=0, has_number=0, has_symbol=0, has_lower=0)
        if choice == 2:
            percentage()
        if choice == 3:
            days_til_2025()
        if choice == 4:
            leg_of_triangle(side_a=0, side_b=0, angle_of_c=0)
        if choice == 5:
            volume(height=0, radius=0)
        if choice == 6:
            print("\t\nThank you for using this calculations and password application!\
            Come back soon!")
            sys.exit()


# display menu and run program. #pylint disable=line-too-long
main_menu()
