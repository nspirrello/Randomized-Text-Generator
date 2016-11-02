This project is focused on the implemetation of LinkedLists.

The ultimate goal is to take song lyrics written into a text file and with them generate a randomized sentence. The program does so by collecting unique words and storing them as nodes in a LinkedList (referred to as SuperLinkedList). Then the program grabs the next word and stores it as a node (BabyLink) of the nested LinkedList (BabyList). This process continues for the entire text file. 

The program utilizes JavaFx to create a workable GUI for the user. The GUI includes a menu which features a File Chooser (handles importing), as well as TextFields to gather vital information such as the length of the sentence and the starting word. Output is handled in two ways. One being through a TextArea visible in the GUI and the other being stored in a text file called "output.txt".

In order to provide a randomized sentence, the application uses the given word, adds it to a String, and finds the matching LinkedList (SuperLinkedList) and then randomly selects (using Math.random) a node in the LinkedList. Then the program adds that word to the String and then randomly generates the next the same way as the first. This continues until the amount of words in the String equals the amount of words desired by the user.
