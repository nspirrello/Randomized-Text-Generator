package songRandom;
/**
 * @author Nicholas Pirrello
 * This class acts as the node for the BabyList (LinkedList) and contains a word as a String
 */
public class BabyLink {
	public String word;
	public BabyLink next;
	/**
	 * Constructor for the BabyLink
	 * @param w - String that acts as the song lyric added to the BabyList
	 */
	public BabyLink(String w){
		this.word = w;
	}
	/**
	 * Displays the content of the BabyLink (node)
	 */
	public void displayLink(){
		System.out.print(word + " ");
	}
}
