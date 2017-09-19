# Guess the Number
# A game by Lucy Hobson
# Sept 23, 2017

# First step is always to import! Saves you from re-inventing the wheel.
# We don't want to write code for generating random numbers.
# Instead, we'll just use the Python module that does it for us!
# You can think of it like a "plugin".
import random

# Game Introduction
author = "Aaron Hobson"
print("Welcome to Guess the Number!")
print("A game by {}".format(author))
print() # Blank line
print("Please enter your name below:")
player = input()
print("Hi " + player + "!")

# Play!
correct_number = random.randint(1, 20)
guess_number = 0
print("I'm thinking of a number between 1 and 20")
guesses = 0
max_guesses = 6
while guesses < max_guesses and correct_number != guess_number:
    print("Guesses left: {}".format(max_guesses - guesses))
    print("Enter your guess below:")
    guess_number = int(input())
    if guess_number < correct_number:
        print("Your guess is too low.")
        guesses += 1
    elif guess_number > correct_number:
        print("Your guess is too high.")
        guesses += 1
    else:
        print("Congratulations! You guessed it in {} guesses!".format(guesses + 1))
if guesses == max_guesses:
    print("Out of guesses!")
    print("The correct number is {}!".format(correct_number))
