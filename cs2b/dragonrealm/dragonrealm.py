# Dragon Realm
# A game by Lucy Hobson
# Sept 30, 2017

# In this game, the player is in a land full of dragons. The dragons all live
# in caves with their large piles of collected treasure. Some dragons are
# friendly and share their treasure. Other dragons are hungry and eat any
# one who enters their cave. The player approaches two caves, one with a
# friendly dragon and the other with a hungry dragon, but doesn’t know
# which dragon is in which cave. The player must choose between the two.

# import random and time modules
import random
import time


# Define functions
def display_intro():
    print('''You are in a land full of dragons. In front of you, you see two caves. 
In one cave, the dragon is friendly and will share his treasure with you. 
The other dragon is greedy and hungry, and will eat you on sight.''') # Multi-line string
    print()  # Blank line


def choose_cave():
    cave = ""
    while cave != "1" and cave != "2":
        print("Which cave will you enter? (1 or 2)")
        cave = input()
    return cave


def check_cave(cave_chosen):
    print("You approach the cave...")
    time.sleep(2)
    print("It is dark and spooky...")
    time.sleep(2)
    print("A large dragon jumps out in front of you! He opens his jaws and...")
    print()
    time.sleep(2)
    friendly_cave = random.randint(1, 2)
    if cave_chosen == str(friendly_cave):
        print("Gives you his treasure!")
    else:
        print("Gobbles you down in one bite!")


# Execute play loop
play_again = "yes"
while play_again == "yes" or play_again == "y":
    display_intro()
    cave_number = choose_cave()
    check_cave(cave_number)
    print("Do you want to play again? (yes or no)")
    play_again = input()
