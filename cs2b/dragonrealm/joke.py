# Joke Teller
# A game by Lucy Hobson
# Sept 30, 2017

# This game simply tells some jokes to the player.
# Really it's just an excuse for me to practice a few things to prep for our next big game.

# All jokes stolen from https://frugalfun4boys.com/2015/04/30/hilarious-jokes-for-kids/

# Here's a basic one. Note that all the strings are represented with double quotes.
print("How do all the oceans say hello to each other?")
input() # User just presses enter. Anything they type will be ignored anyway.
print("They wave!")
print("***HAHAHAHAHAHAHAHA***")
print() # Blank line


# Here's another basic one. The strings here are represented with single quotes.
print('What do you call a bear with no teeth?')
input()
print('A gummy bear!')
print('***HARDY HAR!!!***')
print()

# So should you use double or single quotes for strings? It's a matter of personal preference.
# The most important thing is that you are consistent. If you are using single quotes and double
# quotes in the same program, you need to make a decision and stick with it.

# Also important is what happens when you want to do stuff like this.
# Notice the single quote used as an apostrophe. No problem.
print("I'll tell you another joke.")
# But it DOES become a problem when I'm already using single quotes to represent the string.

# print('You'll laugh at this one, I promise!')

# The above won't even compile (hence why I commented it out), because it thinks the 'You' part is a complete string!
# So how do we fix this? We need to use escape characters!
# Escape characters are essentially instructions in your code to the compiler to do something fancy with the string.
# Example: I'm using single quotes, but I need an apostrophe.
print('You\'ll laugh at this one, I promise!')
# The escape character used above is \'
# This tells the compiler to actually print ' and not mistake it as something containing a string.

# Let's play with it one more time.
print('I\'ll we\'ll that\'s haven\'t.')

# You can do it with double quotes too.
print("The farmer said, \"That'll do pig. That'll do.\"")

# Here's another useful escape character.
print("Wait, these aren't jokes at all. \nI'm so sorry about that.")
# See what that did? It places anything after it on a new line.

# What if I want two print statements to be on the same line, though?
# That's where keyword parameter "end" comes in. Check it out.
print("I promise the next ", end="")
print("one will be a joke.")

# What I'm saying above is that I want the very last character in the string to be nothing at all.
# You see, without doing that, Python automatically adds the newline escape character \n to the end of each string.
# Essentially, Python does this:
# print("Hello world!", end="\n")

# Alright, I think that's enough for now. Let's do some more jokes to practice the stuff above!
print()
print("What did one wall say to the other wall?", end="")
input()
print("\"I'll meet you at the corner!\"")
print("***HWEEEEE DOGGY!!!***")
print()

# Practice with single quotes again.
print('What do you call choose that isn\'t yours?', end='')
input()
print('Nacho\tcheese!') # \t is the "tab" escape character!
print("***LOLOLOLOLOLOLOLOLOLOL***")
print()

# One last joke...
print("Where do cows go for entertainment?", end="")
input()
print("To the moo-vies!")
print("***HULLABALOOOOOO!!!!***")
print()

# I think that's enough for now. Hehe.
