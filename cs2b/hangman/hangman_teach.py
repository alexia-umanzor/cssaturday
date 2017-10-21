# Hangman
# A game by Aaron Hobson
# 10/21/2017

import random

# constants
HANGMAN_PICS = ['''
  +---+
      |
      |
      |
    ===''','''
  +---+
  0   |
      |
      |
    ===''','''
  +---+
  0   |
  |   |
      |
    ===''','''
  +---+
  0   |
 /|   |
      |
    ===''','''
  +---+
  0   |
 /|\  |
      |
    ===''','''
  +---+
  0   |
 /|\  |
 /    |
    ===''','''
  +---+
  0   |
 /|\  |
 / \  |
    ===''']

WORDS = '''ant baboon badger bat bear beaver camel cat clam cobra cougar coyote
crow deer dog donkey duck eagle ferret fox frog goat goose hawk lion lizard llama
mole monkey moose mouse mule newt otter owl panda parrot pigeon python rabbit ram
rat raven rhino salmon seal shark sheep skunk sloth snake spider stork swan tiger
toad trout turkey turtle weasel whale wolf wombat zebra'''.split()


# ["dog", "cat", "frog", "pig"]
def get_random_word(word_list):
    word_index = random.randint(0, len(word_list) - 1)
    return word_list[word_index]














