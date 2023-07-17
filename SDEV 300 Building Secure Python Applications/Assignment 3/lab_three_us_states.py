""" This program gives user ability to display and update all 50 US States info."""
# pylint said that the docstring was too long.
# Even after trying all the methods you had sent me last week.
# pylint: disable=line-too-long

import sys
from PIL import Image
import matplotlib.pyplot as plt
import requests

# Create a dictionary that contains all US states, capitals, flowers and population.
states = {"Alabama": {"Capital": "Montgomery", "Bird": "Yellowhammer",
                      "Flower": "Camellia", "Population": "5024279",
                      "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/camellia-flower.jpg"},
          "Alaska": {"Capital": "Juneau", "Bird": "Willow Ptarmigan",
                     "Flower": "Forget Me Not", "Population": "733391",
                     "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/styles/symbol_thumbnail__medium/public/primary-images/Alpineforgetmenot.jpg?itok=VxF44TUl"},
          "Arizona": {"Capital": "Phoenix", "Bird": "Cactus Wren",
                      "Flower": "Saguaro Cactus Blossom", "Population": "7151502",
                      "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/styles/symbol_thumbnail__medium/public/saguaroflowersFlickr.jpg?itok=DxWnZav5"},
          "California": {"Capital": "Sacramento", "Bird": "California Valley Quail",
                         "Flower": "Golden Poppy", "Population": "39538223",
                         "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/primary-images/CAflowerCaliforniaPoppy.jpg"},
          "Colorado": {"Capital": "Denver", "Bird": "Lark Bunting",
                       "Flower": "Rocky Mountain Columbine", "Population": "5773714",
                       "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/Colorado_columbine2.jpg"},
          "Connecticut": {"Capital": "Hartford", "Bird": "Robin",
                          "Flower": "Mountain Laurel", "Population": "3605944",
                          "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/primary-images/Mountain-Laural-flowers2.jpg"},
          "Delaware": {"Capital": "Dover", "Bird": "Blue Hen Chicken",
                       "Flower": "Peach Blossom", "Population": "989948",
                       "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/primary-images/peachblossomspeachflowers.jpg"},
          "Florida": {"Capital": "Tallahassee", "Bird": "Mockingbird",
                      "Flower": "Orange Blossom", "Population": "21538187",
                      "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/primary-images/OrangeBlossomsFloridaFlower.jpg"},
          "Georgia": {"Capital": "Atlanta", "Bird": "Brown Thrasher",
                      "Flower": "Cherokee Rose", "Population": "10711908",
                      "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/styles/symbol_thumbnail__medium/public/primary-images/CherokeeRoseFlower.jpg?itok=TKWxpzcw"},
          "Hawaii": {"Capital": "Honolulu", "Bird": "Nene",
                     "Flower": "Pua Aloalo", "Population": "1455271",
                     "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/styles/symbol_thumbnail__medium/public/primary-images/yellowhibiscusPuaAloalo.jpg?itok=Y2aYqLKY"},
          "Idaho": {"Capital": "Boise", "Bird": "Mountain Bluebird",
                    "Flower": "Syringa", "Population": "1839106",
                    "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/styles/large/public/primary-images/syringaPhiladelphuslewisiiflower.jpg?itok=f1D5blgD"},
          "Illinois": {"Capital": "Springfield", "Bird": "Cardinal",
                       "Flower": "Native Violet", "Population": "12812508",
                       "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/styles/symbol_thumbnail__medium/public/primary-images/singlebluevioletflower.jpg?itok=8i1uQHwg"},
          "Indiana": {"Capital": "Indianapolis", "Bird": "Cardinal",
                      "Flower": "Peony", "Population": "6785528",
                      "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/styles/large/public/primary-images/PeonyPaeoniaflowers.jpg?itok=he3eHONu"},
          "Iowa": {"Capital": "Des Moines", "Bird": "Eastern Goldfinch",
                   "Flower": "Wild Rose", "Population": "3190369",
                   "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/styles/symbol_thumbnail__medium/public/primary-images/WildPrairieRose.jpg?itok=zyo0qIMG"},
          "Kansas": {"Capital": "Topeka", "Bird": "Western Meadowlark",
                     "Flower": "Native Sunflower", "Population": "2937880",
                     "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/styles/large/public/primary-images/native-sunflowers.jpg?itok=_rKaWSgi"},
          "Kentucky": {"Capital": "Frankfort", "Bird": "Cardinal",
                       "Flower": "Goldenrod", "Population": "4505836",
                       "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/styles/large/public/primary-images/stateflowergoldenrod-bloom.jpg?itok=I5zDP8CK"},
          "Louisiana": {"Capital": "Baton Rouge", "Bird": "Eastern Brown Pelican",
                        "Flower": "Magnolia", "Population": "4657757",
                        "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/styles/symbol_thumbnail__medium/public/primary-images/MagnoliagrandifloraMagnoliaflower.jpg?itok=LQ7y9QJk"},
          "Maine": {"Capital": "Boise", "Bird": "Chickadee",
                    "Flower": "Pine Cone & Tassle", "Population": "1362359",
                    "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/styles/large/public/primary-images/whitepinemalecones.jpg?itok=GTE092lc"},
          "Maryland": {"Capital": "Annapolis", "Bird": "Baltimore Oriole",
                       "Flower": "Black Eyed Susan", "Population": "6177224",
                       "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/styles/symbol_thumbnail__medium/public/primary-images/FlowerMDBlack-eyedSusan.jpg?itok=I8jYSvFl"},
          "Massachusetts": {"Capital": "Boston", "Bird": "Chickadee",
                            "Flower": "Mayflower", "Population": "7029917",
                            "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/styles/large/public/primary-images/MayflowerTrailingArbutus.jpg?itok=0uHBzn8D"},
          "Michigan": {"Capital": "Lansing", "Bird": "Robin",
                       "Flower": "Apple Blossom", "Population": "10077331",
                       "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/styles/symbol_thumbnail__medium/public/primary-images/appleblossombeauty.jpg?itok=HxWn6VHl"},
          "Minnesota": {"Capital": "Saint Paul", "Bird": "Common Loon",
                        "Flower": "Lady Slipper", "Population": "5706494",
                        "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/styles/large/public/primary-images/pinkwhiteladysslipperflower1.jpg?itok=FMZrF1yB"},
          "Mississippi": {"Capital": "Jackson", "Bird": "Mockingbird",
                          "Flower": "Magnolia", "Population": "2961279",
                          "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/styles/large/public/primary-images/magnoliablossomflower01.jpg?itok=MvR8iSBr"},
          "Missouri": {"Capital": "Jefferson City", "Bird": "Bluebird",
                       "Flower": "Hawthorn", "Population": "6154913",
                       "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/styles/large/public/primary-images/hawthornflowersblossoms1.jpg?itok=CNduAlBu"},
          "Montana": {"Capital": "Helena", "Bird": "Western Meadowlark",
                      "Flower": "Bitteroot", "Population": "1084225",
                      "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/styles/symbol_thumbnail__medium/public/primary-images/bitterrootfloweremblem.jpg?itok=SnCwy78x"},
          "Nebraska": {"Capital": "Lincoln", "Bird": "Western Meadowlark",
                       "Flower": "Goldenrod", "Population": "1961504",
                       "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/styles/symbol_thumbnail__medium/public/primary-images/goldenrodflowersyellow4.jpg?itok=6X5qpm4c"},
          "Nevada": {"Capital": "Carson City", "Bird": "Mountain Bluebird",
                     "Flower": "Sagebrush", "Population": "3104614",
                     "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/styles/symbol_thumbnail__medium/public/primary-images/Nevada-Sagebrush-Artemisia-tridentata.jpg?itok=ij6RMnom"},
          "New Hampshire": {"Capital": "Concord", "Bird": "Purple Finch",
                            "Flower": "Purple Lilac", "Population": "1377529",
                            "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/styles/large/public/primary-images/lilacflowerspurplelilac.jpg?itok=Fm3ioLbs"},
          "New Jersey": {"Capital": "Trenton", "Bird": "Eastern Goldfinch",
                         "Flower": "Purple Violet", "Population": "9288994",
                         "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/styles/large/public/wood-violet.jpg?itok=E4vMQoOq"},
          "New Mexico": {"Capital": "Santa Fe", "Bird": "Roadrunner",
                         "Flower": "Yucca", "Population": "2117522",
                         "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/styles/large/public/primary-images/YuccaFlowersclose.jpg?itok=L5XECRcD"},
          "New York": {"Capital": "Albany", "Bird": "Blue Bird",
                       "Flower": "Rose", "Population": "20201249",
                       "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/styles/large/public/primary-images/redrosebeautystateflowerNY.jpg?itok=c8rOfDTL"},
          "North Carolina": {"Capital": "Raleigh", "Bird": "Cardinal",
                             "Flower": "Dogwood", "Population": "10439388",
                             "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/styles/symbol_thumbnail__medium/public/primary-images/floweringdogwoodflowers2.jpg?itok=p_1PGcNk"},
          "North Dakota": {"Capital": "Bismarck", "Bird": "Western Meadowlark",
                           "Flower": "Wild Prairie Rose", "Population": "779094",
                           "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/styles/large/public/primary-images/flowerwildprairierose.jpg?itok=49MUw9da"},
          "Ohio": {"Capital": "Columbus", "Bird": "Cardinal",
                   "Flower": "Scarlet Carnation", "Population": "11799448",
                   "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/styles/symbol_thumbnail__medium/public/primary-images/redcarnationOhioflower.jpg?itok=oCdw9u6V"},
          "Oklahoma": {"Capital": "Oklahoma City", "Bird": "Scissor-tailed Flycatcher",
                       "Flower": "Oklahoma Rose", "Population": "3959353",
                       "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/styles/symbol_thumbnail__medium/public/primary-images/Oklahoma-Rose-Tea-rose.jpg?itok=SV-t8moc"},
          "Oregon": {"Capital": "Salem", "Bird": "Ruffed Grouse",
                     "Flower": "Oregon Grape", "Population": "4237256",
                     "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/styles/symbol_thumbnail__medium/public/primary-images/Oregongrapeflowers2.jpg?itok=lVSJoqCE"},
          "Pennsylvania": {"Capital": "Harrisburg", "Bird": "Ruffed Grouse",
                           "Flower": "Mountain Laurel", "Population": "13002700",
                           "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/styles/symbol_thumbnail__medium/public/Mt_Laurel_Kalmia_Latifolia.jpg?itok=8VhW2Sms"},
          "Rhode Island": {"Capital": "Providence", "Bird": "Rhode Island Red",
                           "Flower": "Violet", "Population": "1097379",
                           "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/styles/symbol_thumbnail__medium/public/primary-images/violetsflowers.jpg?itok=KNMrrLfu"},
          "South Carolina": {"Capital": "Columbia", "Bird": "Great Carolina Wern",
                             "Flower": "Yellow Jessamine", "Population": "5118425",
                             "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/styles/symbol_thumbnail__medium/public/primary-images/CarolinaYellowJessamine101.jpg?itok=1tgcX6mj"},
          "South Dakota": {"Capital": "Pierre", "Bird": "Ring Necked Pheasant",
                           "Flower": "Pasque Flower", "Population": "886667",
                           "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/styles/symbol_thumbnail__medium/public/primary-images/Pasqueflower-03.jpg?itok=vMlGt_qW"},
          "Tennessee": {"Capital": "Nashville", "Bird": "Mockingbird",
                        "Flower": "Passion Flower", "Population": "6910840",
                        "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/styles/symbol_thumbnail__medium/public/primary-images/Pasqueflower-03.jpg?itok=vMlGt_qW"},
          "Texas": {"Capital": "Austin", "Bird": "Mockingbird",
                    "Flower": "Texas Blue Bonnet", "Population": "29145505",
                    "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/styles/symbol_thumbnail__medium/public/primary-images/BluebonnetsBlueRed.jpg?itok=taqKfWDs"},
          "Utah": {"Capital": "Salt Lake City", "Bird": "American Seagull",
                   "Flower": "Sego Lily", "Population": "3271616",
                   "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/styles/symbol_thumbnail__medium/public/SegoLily.jpg?itok=Hxt3DOTq"},
          "Vermont": {"Capital": "Montpelier", "Bird": "Hermit Thrush",
                      "Flower": "Red Clover", "Population": "643077",
                      "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/styles/symbol_thumbnail__medium/public/primary-images/redcloverstateflowerWV.jpg?itok=wvnkPA4C"},
          "Virginia": {"Capital": "Richmond", "Bird": "Cardinal",
                       "Flower": "Dogwood", "Population": "8631393",
                       "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/styles/symbol_thumbnail__medium/public/primary-images/floweringDogwoodSpring.jpg?itok=DFuNFYgS"},
          "Washington": {"Capital": "Olympia", "Bird": "Willow Goldfinch",
                         "Flower": "Coast Rhododendron", "Population": "7705281",
                         "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/styles/symbol_thumbnail__medium/public/primary-images/flower_rhododendronWeb.jpg?itok=0Xl911Zf"},
          "West Virginia": {"Capital": "Charleston", "Bird": "Robin",
                            "Flower": "Rhododendron", "Population": "1793716",
                            "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/styles/symbol_thumbnail__medium/public/primary-images/rhododendronWVstateflower.jpg?itok=7lJaeqWT"},
          "Wisconsin": {"Capital": "Madison", "Bird": "Robin",
                        "Flower": "Wood Violet", "Population": "5893718",
                        "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/styles/symbol_thumbnail__medium/public/wood-violet.jpg?itok=IJ0ft_8r"},
          "Wyoming": {"Capital": "Cheyenne", "Bird": "Western Meadowlark",
                      "Flower": "Indian Paint Brush", "Population": "576851",
                      "URL": "https://statesymbolsusa.org/sites/statesymbolsusa.org/files/styles/large/public/primary-images/indianpaintbrushWYflower.jpg?itok=uvJEaEJ4"},
          }


def display_state():
    """ This function displays all states."""
    print("State    ", " Capital     ", "   Population    ", " Flower  ")
    for state, j in states.items():
        print(f'{state:<10} {j["Capital"]:<15}'f' {j["Population"]:<15} {j["Flower"]:<15}')


def search_state(states_name):
    """ Function to search and display state info."""
    print("State    ", " Capital     ", "   Population    ", " Flower  ")
    for i, j in states.items():
        if i.lower() == states_name:
            print(f'{i:<10} {j["Capital"]:<15}'f' {j["Population"]:<15} {j["Flower"]:<15}')
            url_pic = j["URL"]
            # Get flower data
            flower = requests.get(url_pic, stream=True)
            # Display flower image
            img = Image.open(flower.raw)
            img.show()


def graph():
    """ Function to display bar graph of top 5 states."""
    data = []
    for i, value in states.items():
        data.append([-int(states[i]['Population']), i])
    data.sort()

    # Create x and y-axis data for bar graph
    x_axis = []
    y_axis = []
    num = min(len(data), 5)
    for i in range(num):
        x_axis.append(-data[i][0])
        y_axis.append(data[i][1])
        i += 1

    # plot the graph and show
    plt.figure()
    plt.title("Most Populated States")
    plt.plot()
    plt.xlabel("States")
    plt.ylabel("Population")
    plt.bar(y_axis, x_axis)
    plt.show()


def update_state(states_name, state_population):
    """ Function to update State population."""
    for i, value in states.items():
        if i.lower() == states_name:
            value['Population'] = state_population


def display_menu():
    """ Function to display menu. """
    print("\t#####  Welcome To U.S. States Information Center######")
    print("\n(1) Display all U.S. States in Alphabetical Order With the Capital, State Population, and Flower. ")
    print("(2) Search For a Specific State and Display State Information. ")
    print("(3) Display Bar graph of Top 5 Most Populated States.")
    print("(4) Update Population For Specific State.")
    print("(5) Exit Program")


while True:
    # Display Menu to user
    display_menu()

    # Prompt user to enter selection with conditionals.
    choice = input("Enter Your Choice 1 - 5: ")

    if choice[0] == '1':
        display_state()

    elif choice[0] == '2':
        state_name = input("Enter State name to search for: ").lower()
        search_state(state_name)

    elif choice[0] == '3':
        graph()

    elif choice[0] == '4':
        state_name = input("Enter State Name You Want To Update: ").lower()
        population = int(input("Please Update the Population: "))
        update_state(state_name, population)
        print("Thank you, the population has been updated!")

    elif choice[0] == '5':
        sys.exit("\tThank you! Bye now...")
    else:
        print("\tTry Again. Enter Number (1-5): ")
