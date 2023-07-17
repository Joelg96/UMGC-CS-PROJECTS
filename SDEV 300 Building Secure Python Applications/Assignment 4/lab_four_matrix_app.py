""" This program allows the user to enter phone number and create a matrix
 add multiply and subtract."""

import re
import sys

import numpy as np


# Functions for menus phone number and zipcode entry.
def operation_menu():
    """Function for operational main menu."""
    input_operator = int(input("# Please select a mathematical operation #\n"
                               "(1) Addition.\n(2) Subtraction.\n(3) Multiplication.\n"
                               "(4) Element by element Multiplication.\n(5) Exit."
                               "\n\tSelection: "))
    return input_operator


def menu_prompt():
    """ Displays the initial menu prompt for the program and validates user input."""

    print("\t##### Are you ready to enter the Matrix? #####\n")
    option = input("\tWould you like to begin? (Y)yes or (N)no: ").upper()
    while option not in ("Y", "N"):
        option = input("\tInvalid input, please enter (Y) or (N): ").upper()
    return option


def phone_number():
    """ Validates that user phone number is in correct format of 10 digits and
        prompts to re-enter if invalid. """
    number = input("Enter your phone number (i.e.XXX-XXX-XXXX): ")
    if not re.match(r"\d{3}-\d{3}-\d{4}", number):
        number = input("\tInvalid format(i.e.XXX-XXX-XXXX). Try again: ")


def zip_code():
    """ Validates user's input for zipcode + 4 """
    zip_code_four = input("Enter your zipcode+4 (i.e.XXXXX-XXXX):")
    # Regular expression for checking the zipcode format
    if not re.match(r"\d{5}-\d{4}", zip_code_four):
        zip_code_four = input("\tInvalid format(i.e.XXXXX-XXXX). Try again: ")


PHONE_NUMBER = ""
ZIP_CODE = ""
INPUT_OPTION = ""
RESULT = 0
first_option = menu_prompt()
if first_option == "Y":
    phone_number()
    zip_code()
elif first_option == "N":
    sys.exit("\tThank you for using this program... Come back soon!")

while True:
    # Taking user input for the first matrix.
    print("Enter first 3x3 (i.e. 1 2 3) matrix:")
    first_matrix = []
    for i in range(3):
        row = input().split()
        # Converting each element to integer.
        row = list(map(int, row))
        # Adding row to matrix.
        first_matrix.append(row)
    # Displaying first matrix.
    print("\tThe first entered 3x3 matrix is:")
    for i in range(3):
        for j in range(3):
            print(first_matrix[i][j], end=" ")
        print()
    # Taking user input for the second matrix.
    print("Enter second 3x3 (i.e. 1 2 3) matrix:")
    second_matrix = []
    for i in range(3):
        row = input().split()
        # Converting each element to integer.
        row = list(map(int, row))
        # Adding row to the matrix.
        second_matrix.append(row)
    # Displaying second matrix.
    print("\tThe second entered 3x3 matrix is:")
    for i in range(3):
        for j in range(3):
            print(second_matrix[i][j], end=" ")
        print()
    while True:
        selection = operation_menu()
        if selection == 1:
            print("\tThe selection you made was addition. The results are:")
            # Converting list to numpy arrays.
            first_matrix = np.array(first_matrix)
            second_matrix = np.array(second_matrix)
            # Adding.
            combination = first_matrix + second_matrix
            for i in range(3):
                for j in range(3):
                    print(combination[i][j], end=" ")
                print()
            print("\tThe Transpose is:")
            # Find Transpose of addition.
            transpose = np.transpose(combination)
            for i in range(3):
                for j in range(3):
                    print(transpose[i][j], end=" ")
                print()
            print("\tThe row and column mean values of the results are:")
            # Find mean of rows and columns from results.
            print("Row:", np.mean(combination, axis=1))
            print("Column:", np.mean(combination, axis=0))
        if selection == 2:
            print("\tThe selection you made was Subtraction. The results are:")
            # Converting list to numpy arrays.
            first_matrix = np.array(first_matrix)
            second_matrix = np.array(second_matrix)
            # Subtracting.
            combination = first_matrix - second_matrix
            for i in range(3):
                for j in range(3):
                    print(combination[i][j], end=" ")
                print()
            print("The Transpose is:")
            # Finding Transpose of subtraction.
            transpose = np.transpose(combination)
            for i in range(3):
                for j in range(3):
                    print(transpose[i][j], end=" ")
                print()
            print("The row and column mean values of the results are:")
            # Finding mean of rows and columns from results.
            print("Row:", np.mean(combination, axis=1))
            print("Column:", np.mean(combination, axis=0))
        if selection == 3:
            print("You selected Matrix Multiplication. The results are:")
            # Converting list to numpy arrays.
            first_matrix = np.matrix(first_matrix)
            second_matrix = np.matrix(second_matrix)
            # Multiplying.
            combination = first_matrix * second_matrix
            combination = np.array(combination)
            for i in range(3):
                for j in range(3):
                    print(combination[i][j], end=" ")
                print()
            print("The Transpose is:")
            # Finding transpose of multiplication.
            transpose = np.transpose(combination)
            for i in range(3):
                for j in range(3):
                    print(transpose[i][j], end=" ")
                print()
            print("The row and column mean values of the results are:")
            # Finding mean of rows and columns from results.
            print("Row:", np.mean(combination, axis=1))
            print("Column:", np.mean(combination, axis=0))
        if selection == 4:
            print("You selected Element by Element Multiplication. The results are:")
            # Converting list to numpy arrays.
            first_matrix = np.array(first_matrix)
            second_matrix = np.array(second_matrix)
            # Elementary multiplication.
            combination = first_matrix * second_matrix
            for i in range(3):
                for j in range(3):
                    print(combination[i][j], end=" ")
                print()
            print("The Transpose is:")
            # Finding the transpose.
            transpose = np.transpose(combination)
            for k in range(3):
                for j in range(3):
                    print(transpose[k][j], end=" ")
                print()
            print("The row and column mean values of the results are:")
            # Finding mean of rows and columns from results.
            print("Row:", np.mean(combination, axis=1))
            print("Column:", np.mean(combination, axis=0))
        if selection == 5:
            # exit program with message.
            sys.exit("\tThank you for using this program... Come back soon!")
