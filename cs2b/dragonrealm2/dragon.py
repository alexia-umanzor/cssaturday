# Dragon Realm
# A game by Aaron Hobson
# 10/7/2017

# import stuff
import random
import time

# Show Introduction
def show_intro():
    print('''You are in a land full of dragons. In front of you,
you see two caves. In one cave, the dragon is friendly
and will share his treasure with you. The other dragon
is greedy and hungry, and will eat you on site.''')
    print()


def choose_cave():
    cave = ""
    while cave != "1" and cave != "2":
        print("Which cave will you go into? (1 or 2)")
        cave = input()
    return cave

show_intro()
choose_cave()




