"""This program allows a user to load one of two CSV files
then perform histogram analysis and plots for select variables on the datasets
The first dataset represents the population change for specific dates for U.S. regions.
The second dataset represents Housing data over an extended period of time
describing home age, number of bedrooms and other variables."""

import sys
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt


def population_menu():
    """ Function to display population change CSV Menu."""
    print("\n>> You have entered Population Data.")
    print("**************************************")
    while True:
        print("\n(1) Population Apr 1")
        print("(2) Population Jul 1")
        print("(3) Change in "
              "Population")
        print("(4) Exit Column")
        selection = input(">> Select the category you want to read (i.e. 1,2,3): ")

        # IF statement checks to determine which category to read
        if selection == "1":
            population_file = "PopChange"
            population_data = "Pop Apr 1"
            read_data(population_file, population_data)
        elif selection == "2":
            population_file = "PopChange"
            population_data = "Pop Jul 1"
            read_data(population_file, population_data)
        elif selection == "3":
            population_file = "PopChange"
            population_data = "Change Pop"
            read_data(population_file, population_data)
        elif selection == "4":
            break
        else:
            print(f"\t\n\"{selection}\" is an invalid selection. Try again!")


def housing_menu():
    """ Function to display Housing change menu."""
    print("\n>> You have entered Housing Data.")
    print("***********************************")
    while True:
        print("\n(1) Age")
        print("(2) Bed Rooms")
        print("(3) Built")
        print("(4) Rooms")
        print("(5) Utility")
        print("(6) Exit category")
        selection = input(">> Select the category you want to read (i.e. 1,2,3): ")

        # IF statement checks to determine which category to read.
        if selection == "1":
            housing_file = "Housing"
            housing_data = "AGE"
            read_data(housing_file, housing_data)
        elif selection == "2":
            housing_file = "Housing"
            housing_data = "BEDRMS"
            read_data(housing_file, housing_data)
        elif selection == "3":
            housing_file = "Housing"
            housing_data = "BUILT"
            read_data(housing_file, housing_data)
        elif selection == "4":
            housing_file = "Housing"
            housing_data = "ROOMS"
            read_data(housing_file, housing_data)
        elif selection == "5":
            housing_file = "Housing"
            housing_data = "UTILITY"
            read_data(housing_file, housing_data)
        elif selection == "6":
            break
        else:
            print(f"\t\n\"{selection}\" is an invalid selection. Try again!")


def read_data(file, data):
    """Function that takes user selected data set and computes the statistics and
     provides a histogram"""
    # Reads CSV file from my pc based on user input.
    get_csv = pd.read_csv(rf"H:\UMGC\SDEV 300\Assignment 5\{file}.csv")
    print(f"\n>> You selected: {data.title()}\n>> The statistics for this column are:")
    retrieved_data = pd.DataFrame(get_csv, columns=[f'{data}'])
    np_data = np.array(retrieved_data)
    if data in ("UTILITY", "BEDRMS"):
        print(f"Count (Excluding 0 inputs) = \
        {np.count_nonzero(np_data)}\nCount (Including"f" 0 inputs) =\
        {np.count_nonzero(np_data) + np.count_nonzero(np_data == 0)}")
    # Displays mean, min, max data.
    else:
        print("Count = ", np.count_nonzero(np_data))
        print(f"Mean = {f'{np.mean(np_data):.2f}'}")
        print(f'Standard Deviation = {f"{np.std(np_data):.2f}"}')
        print(f"Minimum = {f'{np.min(np_data):.2f}'}")
        print(f"Maximum = {f'{np.max(np_data):.2f}'}")
        print("\t\n>> Exit histogram to continue.\n")
        histogram = get_csv[f"{data}"]
        if file == "Housing":
            bins = np.arange(min(histogram), max(histogram) + 1, 1)
        else:
            bins = 1000
        # Plotting data to histogram
        plt.hist(get_csv[f"{data}"], bins)
        plt.title(f"{data.title()} Histogram")
        plt.xlabel(f"{data.title()}")
        plt.ylabel(f'{data.title()} Frequencies')
        plt.grid()
        plt.show()


def exit_program():
    """ Function to exit program."""
    sys.exit("\t>> Thank you for using this program... Come back soon!")



def main_menu():
    """ Display main menu and run program."""
    while True:
        print("\n\t##### Welcome to housing data program #####")
        print("***********************************************")
        print("\n(1) Population Data"
              "\n(2) Housing Data"
              "\n(3) Exit Program")
        selection = input(">> Select file you want to analyze: ")
        if selection == "1":
            population_menu()
        elif selection == "2":
            housing_menu()
        elif selection == "3":
            exit_program()
        else:
            print(f"\n\t{selection} is an invalid selection! Try again! ")


# Calling Function to run main menu and program.
main_menu()
