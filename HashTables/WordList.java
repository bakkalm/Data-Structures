import java.util.Scanner;

class WordList {

	// Reference to first Link in list
	// The last Link added to the LinkedList

	public Word firstWord = null;

	public void insert(Word newWord, int hashKey) {

		Word previous = null;
		Word current = firstWord;

		newWord.key = hashKey;

		while (current != null && newWord.key > current.key) {

			previous = current;
			current = current.next;

		}

		if (previous == null)
			firstWord = newWord;

		else
			previous.next = newWord;

		newWord.next = current;

	}

	public void displayWordList() {

		Word current = firstWord;

		while (current != null) {

			System.out.println(current);
			current = current.next;

		}

	}

	public Word find(int hashKey, String wordToFind) {

		Word current = firstWord;

		// Search for key, but stop searching if
		// the hashKey < what we are searching for
		// Because the list is sorted this allows
		// us to avoid searching the whole list

		while (current != null && current.key <= hashKey) {

			// NEW

			if (current.theWord.equals(wordToFind))
				return current;

			current = current.next;

		}

		return null;

	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		// Make a 11 item array that will hold words
		// and definitions

		HashFunction wordHashTable = new HashFunction(11);

		String wordLookUp = "a";

		// Keep retrieve requests until x is entered

		while (!wordLookUp.equalsIgnoreCase("x")) {

			System.out.println(": ");

			wordLookUp = input.nextLine();

			// Look for the word requested and print
			// it out to screen

			System.out.println(wordHashTable.find(wordLookUp));

		}

		// Display every item in the array with
		// the index they are associated with

		wordHashTable.displayTheArray();

	}
}