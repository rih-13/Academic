# Scrabble Calculator

## Description

This program, given the letters of seven randomized Scrabble tiles, determines the set of scores that a player could possibly obtain by placing these tiles. Provided is a text file consisting of all 279,496 words published in the 2019 version of the Collins Scrabble Word dictionary.

It assumes three traits that differ slightly from the traditional game of Scrabble:
There is an unlimited amount of every letter within the scrabble bag, thus it is reasonable to assume (though incredibly unlikely) that you could obtain something like [‘A’, ‘A’, ‘A’, ‘A’, ‘A’, ‘A’, ‘A’].
The tiles will be placed during the first turn on theboard, such that the word does not need to combine with any pre-existing letters that might have already been placed on the Scrabble board.
There exists no word or letter bonuses.

Given the randomized tiles: {‘A’, ‘C’, ‘A’, ‘A’, ‘B’, ‘A’, ‘H’}
The output should be: a list of words that can be created using these letters and the scores for each of the words

## Date

Summer 2022
