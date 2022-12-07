# AssassinGameProject - Copypasta of instructions

1 of 5
Programming Project: Assassin Game
This program focuses on implementing a linked list. Turn in the following files: AssassinManager.java,
AssassinNode.java, and AssassinMain.java. You will create a text file called names.txt that will consist of 7
player names.
Program Description:
"Assassin" is a game played by many people. Each person playing has a particular target that he/she is trying to
"assassinate." One of the things that makes the game more interesting to play is that each person knows only
who they are assassinating; they don't know who is trying to assassinate them, nor do they know whom the
other people are trying to assassinate.
The game of assassin is played as follows: You start out with a group of people who want to play the game. For
example, let's say that there are five people playing named Carol, Chris, Jim, Joe, Sally. A circular chain of
assassination targets (called the "kill ring" in this program) is randomly established. For example, we might
decide Joe should stalk Sally, Sally should stalk Jim, Jim should stalk Carol, Carol should stalk Chris, and Chris
should stalk Joe. (In the actual linked list that implements this kill ring, Chris's next reference would be null.
But conceptually we can think of it as though the next person after Chris is Joe, the front person in the list.)
Here is a picture of this "kill ring":
When someone is assassinated, the links need to be changed to "skip" that person. For example, suppose that
Jim is assassinated by Sally. Sally needs a new target, so we give her Jim's target: Carol. The kill ring
becomes:
If the first person in the kill ring is assassinated, the front of the list must adjust. If Chris kills Joe, the list
becomes:
Write a program that models a game of Assassin. The game reads the names of the initial Kill ring from a file
and puts them into a linked list. The program will prompt the user repeatedly for the name of a person that has
been assassinated. The game continues until only one player remains and is declared the winner. The program
should also have methods for printing the current contents of the kill ring and printing a graveyard of all players
who have been assassinated.
front Joe Sally Carol Chris
front Joe Sally Jim Carol Chris
front Joe Sally Jim Carol Chris
2 of 5
• You will write a java class AssassinNode that represents a single node in a linked list for a game of
Assassin: player name, killer name, and reference to next node.
• You will write a java class AssassinManager that keeps track of who is stalking whom and the history
of who assassinated whom. You will maintain two linked lists: a list of people currently alive (the "kill
ring") and a list of those who have been assassinated (the "graveyard"). As people are assassinated, you
will move them from the kill ring to the graveyard by rearranging links between nodes. The game ends
when only one node remains in the kill ring, representing the winner.
• You will write a client program called AssassinMain. It should read a file of names and construct an
object of your class AssassinManager. This main program will ask the user for the names of each victim
to assassinate until there is just one player left alive (at which point the game is over and the last
remaining player wins). AssassinMain calls methods of the AssassinManager class to carry out the tasks
involved in administering the game.
3 of 5
Sample Log of Execution (user input underlined):
Your program should follow the general behavior demonstrated below, but do not recreate this exact scenario.
Current kill ring:
 Erica Kane is stalking Ruth Martin
 Ruth Martin is stalking Jackson Montgomery
 Jackson Montgomery is stalking Bobby Warner
 Bobby Warner is stalking Joe Martin
 Joe Martin is stalking Anita Santos
 Anita Santos is stalking Tad Martin Tad Martin is stalking Phoebe Wallingford
 Phoebe Wallingford is stalking Erica Kane
Current graveyard:
next victim? Ruth Martin
Current kill ring:
 Erica Kane is stalking Jackson Montgomery
 Jackson Montgomery is stalking Bobby Warner Bobby Warner is stalking Joe Martin
 Joe Martin is stalking Anita Santos
 Anita Santos is stalking Tad Martin
 Tad Martin is stalking Phoebe Wallingford
 Phoebe Wallingford is stalking Erica Kane
Current graveyard:
 Ruth Martin was killed by Erica Kane
next victim? Ruth Martin
Ruth Martin is already dead.
Current kill ring:
 Erica Kane is stalking Jackson Montgomery
 Jackson Montgomery is stalking Bobby Warner
 Bobby Warner is stalking Joe Martin
 Joe Martin is stalking Anita Santos Anita Santos is stalking Tad Martin
 Tad Martin is stalking Phoebe Wallingford
 Phoebe Wallingford is stalking Erica Kane
Current graveyard:
 Ruth Martin was killed by Erica Kane
next victim? bobby warner
Current kill ring:
 Erica Kane is stalking Jackson Montgomery Jackson Montgomery is stalking Joe Martin
 Joe Martin is stalking Anita Santos
 Anita Santos is stalking Tad Martin
 Tad Martin is stalking Phoebe Wallingford
 Phoebe Wallingford is stalking Erica Kane
Current graveyard:
 Bobby Warner was killed by Jackson Montgomery
 Ruth Martin was killed by Erica Kane
next victim? ERICa kaNE
Current kill ring:
 Jackson Montgomery is stalking Joe Martin
 Joe Martin is stalking Anita Santos
 Anita Santos is stalking Tad Martin
 Tad Martin is stalking Phoebe Wallingford Phoebe Wallingford is stalking Jackson Montgomery
Current graveyard:
 Erica Kane was killed by Phoebe Wallingford
 Bobby Warner was killed by Jackson Montgomery
 Ruth Martin was killed by Erica Kane
next victim? ANITA SANTOS
(continued)
Current kill ring:
 Jackson Montgomery is stalking Joe Martin
 Joe Martin is stalking Tad Martin
 Tad Martin is stalking Phoebe Wallingford
 Phoebe Wallingford is stalking Jackson Montgomery
Current graveyard:
 Anita Santos was killed by Joe Martin Erica Kane was killed by Phoebe Wallingford
 Bobby Warner was killed by Jackson Montgomery
 Ruth Martin was killed by Erica Kane
next victim? phoebe wallingford
Current kill ring:
 Jackson Montgomery is stalking Joe Martin
 Joe Martin is stalking Tad Martin
 Tad Martin is stalking Jackson Montgomery
Current graveyard:
 Phoebe Wallingford was killed by Tad Martin
 Anita Santos was killed by Joe Martin
 Erica Kane was killed by Phoebe Wallingford
 Bobby Warner was killed by Jackson Montgomery Ruth Martin was killed by Erica Kane
next victim? Jane doe
Unknown person.
Current kill ring:
 Jackson Montgomery is stalking Joe Martin
 Joe Martin is stalking Tad Martin
 Tad Martin is stalking Jackson Montgomery
Current graveyard: Phoebe Wallingford was killed by Tad Martin
 Anita Santos was killed by Joe Martin
 Erica Kane was killed by Phoebe Wallingford
 Bobby Warner was killed by Jackson Montgomery
 Ruth Martin was killed by Erica Kane
next victim? Joe Martin
Current kill ring:
 Jackson Montgomery is stalking Tad Martin
 Tad Martin is stalking Jackson Montgomery
Current graveyard:
 Joe Martin was killed by Jackson Montgomery
 Phoebe Wallingford was killed by Tad Martin
 Anita Santos was killed by Joe Martin
 Erica Kane was killed by Phoebe Wallingford
 Bobby Warner was killed by Jackson Montgomery
 Ruth Martin was killed by Erica Kane
next victim? jackson montgomery
Game was won by Tad Martin
Final graveyard is as follows:
 Jackson Montgomery was killed by Tad Martin Joe Martin was killed by Jackson Montgomery
 Phoebe Wallingford was killed by Tad Martin
 Anita Santos was killed by Joe Martin
 Erica Kane was killed by Phoebe Wallingford
 Bobby Warner was killed by Jackson Montgomery
 Ruth Martin was killed by Erica Kane
4 of 5
Implementation Details:
Your node class AssassinNode should construct an object that represents a single node in a linked list for a game of
Assassin as specified in the instructions above.
For this project, specific fields, methods, and constructor has been provided below to help you develop
AssassinManager.java:
You must have exactly the following two fields; you are not allowed to have any others:
• a reference to the front node of the kill ring
• a reference to the front node of the graveyard (null if empty)
public AssassinManager(List<String> names)
In this constructor you should initialize a new assassin manager over the given list of people. Your constructor should not
save the List<String> itself as a field, nor modify the list; but instead it should build your own kill ring of linked nodes that
contains these names in the same order. For example, if the list contains ["John", "Sally", "Fred"], the initial kill ring should
represent that John is stalking Sally who is stalking Fred who is stalking John (in that order). You may assume that the
names are non-empty, non-null strings and that there are no duplicates.
You should throw an IllegalArgumentException if the list is null or has a size of 0.
s
public void printKillRing()
In this method you should print the names of the people in the kill ring, one per line, indented by two spaces, as "name is
stalking name". The behavior is unspecified if the game is over. For the names on the first page, the initial output is:
 Joe is stalking Sally
 Sally is stalking Jim
 Jim is stalking Carol
 Carol is stalking Chris
 Chris is stalking Joe
s
public void printGraveyard()
In this method you should print the names of the people in the graveyard, one per line, with each line indented by two
spaces, with output of the form "name was killed by name". It should print the names in the opposite of the order in which
they were killed (most recently killed first, then next more recently killed, and so on). It should produce no output if the
graveyard is empty. For example, from the previous names, if Jim is killed, then Chris, then Carol, the output is:
 Carol was killed by Sally
 Chris was killed by Carol
 Jim was killed by Sally
s
public boolean killRingContains(String name)
In this method you should return true if the given name is in the current kill ring and false otherwise. It should ignore case
in comparing names; for example, if passed "salLY", it should match a node with a name of "Sally". s
public boolean graveyardContains(String name)
In this method you should return true if the given name is in the current graveyard and false otherwise. It should ignore
case in comparing names; for example, if passed "CaRoL", it should match a node with a name of "Carol". s
public boolean isGameOver()
In this method you should return true if the game is over (i.e., if the kill ring has just one person) and false otherwise. s
public String winner()
In this method you should return the name of the winner of the game, or null if the game is not over. s
public void kill(String name)
In this method you should record the killing of the person with the given name, transferring the person from the kill ring
to the front of the graveyard. This operation should not change the relative order of the kill ring (i.e., the links of who is
5 of 5
killing whom should stay the same other than the person who is being killed/removed). Ignore case in comparing names.
A node remembers who killed the person in its killer field. It is your code's responsibility to set that field's value.
You should throw an IllegalStateException if the game is over, or an IllegalArgumentException if the given name is not part
of the kill ring (if both of these conditions are true, the IllegalStateException takes precedence).
The kill method is the hardest one, so write it last.
The AssassinMain.java is the main client program for assassin game management. It should read names from a file
names.txt and uses them to start the game. The user is asked for the name of the next victim until the game is over.
Guidelines and Grading:
Part of your grade will come from appropriately utilizing linked lists and nodes. Redundancy is another major grading
focus; some methods are very similar, and you should avoid repeated logic as much as possible.
You should follow good general style guidelines such as: making fields private and avoiding unnecessary fields;
appropriately using control structures like loops and if/else statements; properly using indentation, good variable names
and proper types.
Comment your code descriptively in your own words at the top of your class, each method, and on complex sections of
your code. Comments should explain each method's behavior, parameters, return, pre/post-conditions, and exceptions.
You should have three java files: AssassinNode, AssassinManager, and AssassinMain. Be sure to fulfil all requirements.
Include all member names. 
