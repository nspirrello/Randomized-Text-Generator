package songRandom;


/**
 * @author Nicholas Pirrello
 * This is the Main LinkedList that will ultimately contain LinkedLists as nodes
 */
public class SuperLinkList {
	public SuperLink first;
	public SuperLink last;
	/**
	 * Constructor for the SuperLinkedList object
	 */
	public SuperLinkList(){
		first = null;
		last = null;
	}
	/**
	 * Checks if the LinkedList is empty
	 */
	public boolean isEmpty(){
		return first == null;
	}
	/**
	 *  Takes a String value and creates a new LinkedList, then the method adds it to the end of the existing LinkedList
	 */
	public void insertLast(String key){
		SuperLink newSuperLink = new SuperLink(key);
		if(isEmpty()){
			first = newSuperLink;
		} else {
			last.next = newSuperLink;
		}
		last = newSuperLink;
	}
	/**
	 * This method searches through the LinkedList using a String key and if found returns true otherwise returns false
	 * @param key - A string reference for comparison 
	 * @return true or false
	 */
	public boolean findLink(String key){
		SuperLink current = first;
		while(current != null){
			if(current.key.equals(key)){
				return true;
			}
			current = current.next;
		}
		return false;
	}
	/**
	 * Displays each node in the LinkedList
	 */
	public void displayList(){
		System.out.println("List <First --> Last>: ");
		SuperLink current = first;
		while(current != null){
			current.displayLink();
			current = current.next;
		}
		System.out.println();
	}
	/**
	 * This method searches for a node in the LinkedList using the String key and when found returns that node in the LinkedList
	 * @param key - String reference for comparison
	 * @return current
	 */
	public SuperLink getLink(String key){
		SuperLink current = first;
		while(current != null){
			if(current.key.equals(key)){
				return current;
			}
			current = current.next;
		}
		return null;
	}
}
