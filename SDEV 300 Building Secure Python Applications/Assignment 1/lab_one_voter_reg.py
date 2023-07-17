"""
This program is designed to complete voter registration app which will prompt user for:
    first name
    last name
    age
    country of citizenship
    state of residence
    zipcode
    valid once all fields entered.
check continuation at:
    at least 18 yrs old and US citizen
    if not no further questions
States should be 2 letters
re prompt if invalid input
option to exit at anytime
Output to summarize inputted data and congrats if eligible to vote
"""


# Start of functions to obtain user data.
import sys


def end_registration():
    """This method is to allow user to exit the app at certain times."""
    while True:
        # Prompt user to enter whether they'd like to continue registration or not.
        answer = input('Would you like to continue voter registration? (yes or no)').lower()
        if answer == 'yes':
            print('\tNext question...')
            return True
        if answer == 'no':
            exit('\t Thank you for using this application, hope to see you soon!')
            return False
        else:
            print('\tThere seems to be an error, invalid input, try again!')


def valid_age():
    """ This method will be to validate the user's age in order to continue."""
    while True:
        try:
            # Prompt user to enter age.
            age = int(input('Enter Age: '))
        except ValueError:
            print('\tThere seems to be an error, invalid input, try again!')
        # Check if user is under 18. if so, end.
        if age < 18:
            exit('\tUnfortunately, the entered age does not meet age requirements to continue!')
        # acceptable age range.
        elif 18 <= age <= 120:
            print('\tNext question...')
            return age
        # Check for unrealistic ages.
        elif age > 120:
            print('\tHmm... Seems unlikely, please try again!')


def citizenship():
    """ This method is to check if U.S. Citizen or not. if not, no further questions."""
    while True:
        # Prompt user to enter if U.S. Citizen or not.
        status = str(input('Are you a U.S. Citizen? (yes or no)')).lower()
        if status == 'yes':
            return 'Yes'
        if status == 'no':
            sys.exit('\tUnfortunately, you must be a U.S. Citizen to continue registration!')
        else:
            print('\tThere seems to be an error, invalid input, try again!')


def get_name():
    """ This method is to get user's name."""
    # Prompt user to enter first and last name.
    first_name = str(input('Enter First name: ')).capitalize()
    last_name = str(input('Enter Last name: ')).capitalize()
    print(f'\nThank you,{first_name}')
    return first_name, last_name


def get_state():
    """ This method is to validate and obtain user state"""
    while True:
        # Prompt and check user to enter State.
        state = input('Enter the state in which you live? (ie:MD,PA,VA): ').upper()
        if len(state) == 2:
            return state
        if len(state) != 2:
            print('\tState must be in two letter format! (MD)')
        else:
            print('\tInvalid input, try again!')


def get_zipcode():
    """ This method is to obtain and validate user's zipcode(5 digit zip)"""
    while True:
        # Prompt user to enter zipcode,Then validate.
        zipcode = input('Enter Zipcode: ')
        if len(zipcode) == 5:
            return int(zipcode)
        else:
            print('\tInvalid input, must be 5 digits! please try again! (ie: 21158)')


# Displaying of all entered data. and run through of code.(calling functions)
print('############ Welcome To Voter Registration Application! ##########')
print('\tLet\'s begin registration!')
# While loop to run through functions.
while True:
    AGE = valid_age()
    end_registration()
    COUNTRY = citizenship()
    end_registration()
    NAME = get_name()
    end_registration()
    STATE = get_state()
    end_registration()
    CODE = get_zipcode()
    break
# Display all entered data.
print('\n\tCongratulations, you have finished voter registration! You entered the following:')
print('####################')
print(f'\tName(F,L):{NAME}\n'
      f'\tU.S. Citizen?:{COUNTRY}\n'
      f'\tAge:{AGE}\n'
      f'\tState of Residence:{STATE}\n'
      f'\tZipcode:{CODE}')
print('####################')
print('Thank you for registering to vote!')
