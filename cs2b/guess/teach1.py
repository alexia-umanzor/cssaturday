# Your first Python program.

# First, let's get the player name and print it.
# "Print" just means display it to the player.

# First, let's just print a string.
# A string is anything in quotes.
print("Hello!")

# Now let's get the player's name using the input() function.
# You know it's a function because it has () after it.
# Whatever the player types in will be stored as a string.
print("What is your name?")
name = input()

# Now just print the player's name, which is stored in the variable "name"
# The + sign just smashes the strings together. This is known as "concatenation".
print("Hello " + name + "!")

# Let's try something more complicated. Let's ask the user how many states
# there are in the United States?
print("How many states are there in the United States?")
answer = input()

# To determine what to do if the user is right or wrong, we need an "if statement"
if answer == "52":
    print("You're correct!")
else:
    print("Sorry, you're wrong!")

# The if-statement is called a "flow control statement", since it controls the flow
# or direction of a program based on specific outcomes.
# Flow control statements are one of the most fundamental elements of computer programming
# and game design. It's how we can make a program do different things based on different
# circumstances.

# Let's try another one.
print("How old are you?")
answer = input()

if answer == "18":
    print("Hey! You're an adult!")
print("Cool, thanks for letting me know.")

# Notice that I didn't include an else here. What is the difference between what happens here
# and what happens in the code we wrote above?

# Let's say we want to let the user try to answer a question multiple times
# until they get the right answer.
# We would require another flow control statement called a "loop".
# The simplest loop is the "while loop".
# It's just like an if-statement, only we keep going until the condition becomes false.

# Notice where that last print statement is. It's not in the loop. Why?
correct_number = "7"
print("I'm thinking of a number between 1 and 10. Guess it!")
guess_number = input()
while guess_number != correct_number:
    print("Sorry, that's wrong! Try again!")
    guess_number = input()
print("You got it! Congratulations!")

# "While" can get you in a lot of trouble if you don't have a way to terminate it.
# For example:
# while "3" == "3":
#     print("INFINITE LOOP!!!")

# The last thing I want to talk about is types, casting, and formatting strings.
# So far, our numbers are being treated like strings.
# This makes it hard for us to do mathematical stuff with them.
# For example, what is the value of z below?
x = "3"
y = "4"
z = x + y
print("z is " + z)

# If you guessed "34", you are correct!
# If we want to actually add 3 and 4 and store the answer in z, we need to
# cast them as integers.
z = int(x) + int(y)
print("now z is {}".format(z))

# That last thing I did was called "formatting a string". It's a cleaner way to
# do concatenation, but it also works for inputting non-strings into a string.
# For example, the following wouldn't work:
#
# num = 3
# print("num is " + num)
#
# That doesn't work because you can only concatenate a strings with other strings.
# The format() function takes care of this for strings as well as other data types, like integers.
my_string = "Hello {}".format("World!")
print(my_string)
my_string_two = "I am {} years old"
print(my_string_two.format(32))

# With this knowledge about formatting, we can now parse or "read" input strings as
# integer values, which let us do stuff like this:

correct_number = 7
print("I'm thinking of a number between 1 and 10. Guess it!")
guess_number = int(input())
while guess_number != correct_number:
    if guess_number < correct_number:
        print("Too low. Try again!")
    else:
        print("Too high. Try again!")
    guess_number = int(input())
print("You got it! Congratulations!")

# Are you ready to write the whole game? Let's begin!
