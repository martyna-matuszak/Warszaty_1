# Workshop - Java Basics

## Main1 - Number Guessing Game

When the user launches the program the computer randomly generates a number between 1 and 100. The user now must guess the number based on the responses showed on the screen. <br>
When the inserted numer will be equal to the number tah computer stores, the user will see a prompt saying "Zgadłeś!", that means that user managed to guess the number. Afterward the process will be finished.

## Main2 - LOTTO Simulator

LOTTO is a numbers game, that draws 6 numbers from 1 to 49. The user must correctly guess the 6 drawn numbers. Hitting 3, 4, 5 or 6 correct numbers is rewarded.
The program will ask the user to insert selected numbers and at the same time it will check the conditions below:
* if the inserted string of characters is a number,
* if this number wasn't inserted before,
* if chosen number is between 1 and 49.

After the numbers are inserted, it'll sort them in ascending order and show them on the screen. 
Next it'll generate 6 random numbers from the range and show them on the screen. Finally user will be informed if at least three guesses were correct.

## Main3 - Inverted Number Guessing Game

The Number Guessing Game becomes inverted. The user's task is to think of a number between 1 and 1000. Then a computer will guess the number in up to 10 tries.

The user must respond to the computer's guesses with "za dużo" (too much), "za mało" (too little) or "zgadłeś" (you guessed). All other responses will be ignored.

## Main4 - RPG Dice Throw Simulator

In board games and paper RPG games players use lots of different dice types, not only the standard six-sided dice. Often the player must throw the dice several times andd the final score is affected by the modifier, that adds or subtracts fixed value from the score.

To simplify the notation we use code that shortens the command, e.g. "2D12+10" means " throw 2 times with the twelve-sided dice and add 10 to the score".

The user has to insert a command in the notation above. The number of throws and modifiers can be ignored if they are not neccesary.

The program will check if the command inserted by the user is correct, if the chosen dice type exists and it will return final, random score and show it on the screen.

## Main5 - Search engine for the most popular words

**For the program to work properly, the jsoup library must be imported to the project.** It can be downloaded here: https://jsoup.org/download

The program will search chosen internet internet portal's headlines and then it will save every single word found in them to the file called *popular_words.txt*.

Next it will create the file *filtered_popular_words.txt*, which will include every found word except for the ones that are shorter than 3 characters or excluded (e.g. oraz, ponieważ).
