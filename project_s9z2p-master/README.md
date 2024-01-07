# My Personal Project about TeamFight Tactics(TFT)

## This project will be about adding TFT characters.

My proposal:
- This application will allow users to be able to add Teamfight Tactics(TFT) Characters to the application and specify their character details. For example:  their own trait,class and items.


- Players that are new to TFT or if a new set of TFT characters are launched. As whenever there is a major update lots of new characters get introduced. Thus it will make it really confusing for players to understand what is going on in the game.


- As an avid fan of TFT. There are initially a lot of characters to start with, thus it can get very confusing for new players. Also after 3-4 months of the game, the game will update itself with new characters and traits in order to keep the game more refreshing.


An example of a **champion** would contain:

*Ahri* who has the trait of **Syndicate** and **Arcanist** .
The items for Ahri are **Infinity Edge**,**Blue Buff** and **Jeweled Gauntlet** and it is S tier.


User Stories:

As a user, I want to be able to add a champions to my champion pool.

As a user, I want to be able to add a champion's traits and items to my champion pool.

As a user, I want to be able to view the entire list of champions and their traits from the champion pool.

As a user, I want to be able to sort my champions by their cost.

As a user, I want to be able to save the entire state of my TFT champion list application to file.

As a user, I want to be able to load my saved file of my TFT champion list exactly where I left it off.

## Phase 4: Task 2
Fri Apr 01 00:33:51 PDT 2022
Added Champion to Championlist

Fri Apr 01 00:34:15 PDT 2022
Added Champion to Championlist

Fri Apr 01 00:34:31 PDT 2022
Sorted Champion to Championlist

Fri Apr 01 00:34:32 PDT 2022
Saved Champion to Championlist.json

Fri Apr 01 00:34:33 PDT 2022
Loaded Champion to Championlist.json

Fri Apr 01 00:34:33 PDT 2022
Added Champion to Championlist

Fri Apr 01 00:34:33 PDT 2022
Added Champion to Championlist

## Phase 4: Task 3
Instead of keeping every attribute of a Champion such as the items and traits. I could put them all in the same
class or save them in a 2D array. Thus I will not have so many lists, setter and getter method for each variable
inside the Champion and Championlist Class. Such that it will reducing coupling and improving cohesion.

Another way of making my project better is to make it error proof such as entering Integers in the Champion name or
Entering Strings in the Champion Cost.