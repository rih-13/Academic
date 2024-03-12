# Pyramid X

## Description

World renown Archeology Professor J. has discovered the mystical pyramid of X, which is believed to hide a number of priceless treasures. The inside of pyramid X is divided into interconnected hexagonal chambers. Many of the chambers have lethal traps in them, so it is very important that the professor only walks through chambers where enough light enters so he can walk through them safely. There are several types of chambers in the pyramid:
• Sealed chambers: chambers where the professor cannot enter.
• Lighted chambers: chambers that have a skylight, a hole in the ceiling where sunlight enters. The professor can safely walk through these chambers as there is enough light in them to spot the traps.
• Dim chambers: these are chambers that are adjacent to a lighted chamber. Enough light enters these chambers to make it safe to walk through them.
• Dark chambers: these are chambers where there is no light, so the professor should not enter them as he would not be safe. A dark chamber is one that has no adjacent lighted chambers.
• Entrance chamber: this is the chamber through which the professor can enter the pyramid. The entrance chamber is lighted.
• Treasure chambers: these are chambers that hold invaluable relics. Treasure chambers are lighted.

The program finds a path from the entrance chamber to all the treasure chambers that does not include any sealed or dark chambers. As the path is being computed. It follows the rules:
• if the program has a choice between moving into a treasure chamber or a chamber without a treasure it chooses the treasure chamber
• if the program has a choice between moving to a lighted chamber or moving to a dim chamber, it choosed the lighted chamber
The figure in EXAMPLE.jpg shows an example of the possible chambers of the pyramid. The entrance chamber has an arrow inside of it, lighted chambers have a yellow skylight in the middle, dim chambers do not have a skylight, dark chambers are black, sealed chambers are filled with rocks, and treasure chambers have a treasure in them. The path from the entrance to all the treasure chambers is marked in blue.

## Running the Program

Place all files in the same directory, compile them with javac.

Then, run the program by typing o java Pyramid inputFile where inputFile is one of the provided sample input files: map1.txt, map2.txt,

## Date

Summer 2022
