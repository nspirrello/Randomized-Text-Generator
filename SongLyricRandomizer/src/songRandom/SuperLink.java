package songRandom;
/**
 * @author Nicholas Pirrello
 * The SuperLink objects are used as nodes for the SuperLinkedList, they contain a String reference to a specified word in the song, 
 * and the LinkedList that is contained in the node itself
 */
public class SuperLink {
	public String key;
	public BabyList bList;
	public SuperLink next;
	/**
	 * Constructor for the SuperLink object
	 * @param newWord - when a new word is encountered, the SuperLink takes it as "key" and uses that as a reference to the encountered word as well as 
	 * creates a blank LinkedList
	 */
	public SuperLink(String newWord){
		key = newWord;
		bList = new BabyList();
		next = null;
	}
	/**
	 * Displays the LinkedList contained in the node
	 */
	public void displayLink(){
		System.out.print(bList + " ");
	}
}
