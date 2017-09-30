##print("What is your name?")
##name = input()
##print("Hello " + name + "!")
##
##print("How many states are in the USA?")
##answer = input()
##if answer == "50":
##    print("Correct!")
##else:
##    print("WRONG!!!!!")
##
##print("How old are you?")
##age = input()
##if age == "18":
##    print("You are an adult now! Yay!")
##print("Cool!")

# This is an example of a while loop
correct_number = 7
print("I'm thinking of a number between 1 and 10! Guess it!")
guess_number = int(input())
while guess_number != correct_number:
    if guess_number < correct_number:
        print("Too low. Try again!")
    else:
        print("Too high. Try again!")
    guess_number = int(input())
print("You got it!")

name = "Aaron"
print("Hello {}! How are you today?".format(name))

print("Hello world!")

