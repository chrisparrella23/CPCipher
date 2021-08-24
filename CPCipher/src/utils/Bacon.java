package utils;

public class Bacon {
	
	/*TODO
	 * See if there is a shorter way to write the encode method.
	 * Perhaps a dictionary to abstract away the switch statement?
	 */
	
	/** Encrypts the given plaintext.
	 * 
	 * @param text A String representing the text.
	 * @return The ciphertext.
	 */
	public static String encrypt(String text) {
		text = Caesar.removeSpaces(text);
		StringBuilder sb = new StringBuilder();
		char[] arr = text.toCharArray();
		String[] cipherArr = new String[arr.length];
		for (int i = 0; i < arr.length; i++) {
			cipherArr[i] = encode(arr[i]);
			sb.append(cipherArr[i]);
		}
		return sb.toString();
	}
	
	/** Encodes a character as a string. It is based on the Latin alphabet,
	 *	so I/J and U/V share the same encoded form.
	 * 
	 * @param c A char representing the character.
	 * @return The String used to represent the original char.
	 */
	public static String encode(char c) {
		String output = "";
		switch(c) {
			case 'A':	output = "AAAAA";
				break;
			case 'B':	output = "AAAAB";
				break;
			case 'C':	output = "AAABA";
				break;
			case 'D':	output = "AAABB";
				break;
			case 'E':	output = "AABAA";
				break;
			case 'F':	output = "AABAB";
				break;
			case 'G':	output = "AABBA";
				break;
			case 'H':	output = "AABBB";
				break;
			case 'I':	output = "ABAAA";
				break;
			case 'J':	output = "ABAAA";
				break;
			case 'K':	output = "ABAAB";
				break;
			case 'L':	output = "ABABA";
				break;
			case 'M':	output = "ABABB";
				break;
			case 'N':	output = "ABBAA";
				break;
			case 'O':	output = "ABBAB";
				break;
			case 'P':	output = "ABBBA";
				break;
			case 'Q':	output = "ABBBB";
				break;
			case 'R':	output = "BAAAA";
				break;
			case 'S':	output = "BAAAB";
				break;
			case 'T':	output = "BAABA";
				break;
			case 'U':	output = "BAABB";
				break;
			case 'V':	output = "BAABB";
				break;
			case 'W':	output = "BABAA";
				break;
			case 'X':	output = "BABAB";
				break;
			case 'Y':	output = "BABBA";
				break;
			case 'Z':	output = "BABBB";
				break;
		}
		return output;
	}
}
