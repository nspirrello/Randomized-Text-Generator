package songRandom;
/**
 * @author Nicholas Pirrello
 * This class acts as the LinkedList contained within the SuperLink objects
 */
public class BabyList {
	public BabyLink first;
	public BabyLink last;
	public int n;
	/**
	 * Constructor for the BabyList class
	 */
	public BabyList(){
		first = null;
		last = null;
	}
	/**
	 * Checks if the LinkedList is empty
	 * @return true or false
	 */
	public boolean isEmpty(){
		return first == null;
	}
	
	/**
	 * Takes in a String, uses the String to create a BabyLink - the node of the BabyList - and adds the new node to the end of the LinkedList
	 * @param d - String used to create the BabyList
	 */
	public void insertLast(String d){
		BabyLink newLink = new BabyLink(d);
		if(isEmpty()){
			first = newLink;
		} else {
			last.next = newLink;
		}
		last = newLink;
		n++;
	}
	/**
	 * When called this method returns the node picked at random using Math.random and returns the nodes word at that location
	 * @return current.word
	 */
	public String getNextWord(){
		int num = (int)(Math.random() * n);
		BabyLink current = first;
		for(int i = 0;i < num;i++){
			current = current.next;
		}
		return current.word;
	}
	
	/**
	 * Displays each node the of the LinkedList
	 */
	public void displayList(){
		BabyLink current = first;
		while(current != null){
			current.displayLink() ;
			current = current.next;
		}
		System.out.println();
	}
}
