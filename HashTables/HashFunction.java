
public class HashFunction {

	WordList[] theArray;
	int arraySize;
	int itemsInArray = 0;

	public String[][] elementsToAdd = {
			{ "ace", "Very good" },
			{ "act", "Take action" },
			{ "add", "Join (something) to something else" },
			{ "age", "Grow old" },
			{ "ago", "Before the present" },
			{ "aid", "Help, assist, or support" },
			{ "aim", "Point or direct" },
			{ "air", "Invisible gaseous substance" },
			{ "all", "Used to refer to the whole quantity" },
			{ "amp",
					"Unit of measure for the strength of an electrical current" },
			{ "and", "Used to connect words" }, { "ant", "A small insect" },
			{ "any", "Used to refer to one or some of a thing" },
			{ "ape", "A large primate" },
			{ "apt", "Appropriate or suitable in the circumstances" },
			{ "arc", "A part of the circumference of a curve" },
			{ "are", "Unit of measure, equal to 100 square meters" },
			{ "ark", "The ship built by Noah" },
			{ "arm", "Two upper limbs of the human body" },
			{ "art", "Expression or application of human creative skill" },
			{ "ash", "Powdery residue left after the burning" },
			{ "ask", "Say something in order to obtain information" },
			{ "asp", "Small southern European viper" },
			{ "ass", "Hoofed mammal" },
			{ "ate", "To put (food) into the mouth and swallow it" },
			{ "atm", "Unit of pressure" },
			{ "awe", "A feeling of reverential respect" },
			{ "axe", "Edge tool with a heavy bladed head" },
			{ "aye", "An affirmative answer" } };

	public int stringHashFunction(String wordToHash) {

		int hashKeyValue = 0;

		for (int i = 0; i < wordToHash.length(); i++) {

			// 'a' has the character code of 97 so subtract
			// to make our letters start at 1

			int charCode = wordToHash.charAt(i) - 96;

			int hKVTemp = hashKeyValue;

			// Calculate the hash key using the 26 letters
			// plus blank

			hashKeyValue = (hashKeyValue * 27 + charCode) % arraySize;

			System.out.println("Hash Key Value " + hKVTemp
					+ " * 27 + Character Code " + charCode + " % arraySize "
					+ arraySize + " = " + hashKeyValue);

		}
		System.out.println();

		return hashKeyValue;

	}

	HashFunction(int size) {

		arraySize = size;

		theArray = new WordList[size];

		// Fill the array with WordLists

		for (int i = 0; i < arraySize; i++) {

			theArray[i] = new WordList();

		}

		addTheArray(elementsToAdd);

	}

	public void insert(Word newWord) {

		String wordToHash = newWord.theWord;

		// Calculate the hashkey for the Word

		int hashKey = stringHashFunction(wordToHash);

		// Add the new word to the array and set
		// the key for the word

		theArray[hashKey].insert(newWord, hashKey);

	}

	public Word find(String wordToFind) {

		// Calculate the hash key for the word

		int hashKey = stringHashFunction(wordToFind);

		// NEW

		Word theWord = theArray[hashKey].find(hashKey, wordToFind);

		return theWord;

	}

	public void addTheArray(String[][] elementsToAdd) {

		for (int i = 0; i < elementsToAdd.length; i++) {

			String word = elementsToAdd[i][0];
			String definition = elementsToAdd[i][1];

			// Create the Word with the word name and
			// definition

			Word newWord = new Word(word, definition);

			// Add the Word to theArray

			insert(newWord);

		}

	}

	public void displayTheArray() {

		for (int i = 0; i < arraySize; i++) {

			System.out.println("theArray Index " + i);

			theArray[i].displayWordList();

		}

	}

}