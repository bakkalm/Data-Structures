
public class Word {

	public String theWord;
	public String definition;

	public int key;

	// Reference to next Word made in the WordList

	public Word next;

	public Word(String theWord, String definition) {

		this.theWord = theWord;
		this.definition = definition;

	}

	public String toString() {

		return theWord + " : " + definition;

	}

}