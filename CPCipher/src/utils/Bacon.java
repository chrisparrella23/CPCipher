package utils;

import java.util.ArrayList;

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
			case '1':	output = "00001";
				break;
			case '2':	output = "00010";
				break;
			case '3':	output = "00011";
				break;
			case '4':	output = "00100";
				break;
			case '5':	output = "00101";
				break;
			case '6':	output = "00110";
				break;
			case '7':	output = "00111";
				break;
			case '8':	output = "01000";
				break;
			case '9':	output = "01001";
				break;
			case '0':	output = "00000";
				break;
		}
		return output;
	}
	
	/*TODO
	 * Using an ArrayList instead of an Array for groupedArr frees it from the iteration,
	 * and gets around the Out of Bounds exception that using an array would cause.
	 * Is this good practice?
	 */
	
	/** Decrypts the given ciphertext.
	 * 
	 * @param text A String represented the encoded message.
	 * @return The deciphered plaintext.
	 */
	public static String decrypt(String text) {
		text = Caesar.removeSpaces(text);
		StringBuilder sb = new StringBuilder();
		ArrayList<String> groupedArr = new ArrayList<>();
		int index = 0;
		while (index < text.length()) {
			groupedArr.add(text.substring(index, Math.min(index + 5, text.length())));
			index += 5;
		}
		
		groupedArr.forEach(str -> {
			sb.append(decode(str));
		});
		return sb.toString();
	}
	
	/**Decodes a character that is encoded as a string. It is based on the Latin alphabet,
	 *	so I/J and U/V share the same encoded form.
	 * 
	 * @param str A string representing the encoded character.
	 * @return The deciphered character.
	 */
	public static char decode(String str) {
		char c = '?';
		switch(str) {
			case "AAAAA":	c = 'A';
				break;
			case "AAAAB":	c = 'B';
				break;
			case "AAABA":	c = 'C';
				break;
			case "AAABB":	c = 'D';
				break;
			case "AABAA":	c = 'E';
				break;
			case "AABAB":	c = 'F';
				break;
			case "AABBA":	c = 'G';
				break;
			case "AABBB":	c = 'H';
				break;
			case "ABAAA":	c = 'I';
				break;
			case "ABAAB":	c = 'K';
				break;
			case "ABABA":	c = 'L';
				break;
			case "ABABB":	c = 'M';
				break;
			case "ABBAA":	c = 'N';
				break;
			case "ABBAB":	c = 'O';
				break;
			case "ABBBA":	c = 'P';
				break;
			case "ABBBB":	c = 'Q';
				break;
			case "BAAAA":	c = 'R';
				break;
			case "BAAAB":	c = 'S';
				break;
			case "BAABA":	c = 'T';
				break;
			case "BAABB":	c = 'V';
				break;
			case "BABAA":	c = 'W';
				break;
			case "BABAB":	c = 'X';
				break;
			case "BABBA":	c = 'Y';
				break;
			case "BABBB":	c = 'Z';
				break;
			case "00001":	c = '1';
				break;
			case "00010":	c = '2';
				break;
			case "00011":	c = '3';
				break;
			case "00100":	c = '4';
				break;
			case "00101":	c = '5';
				break;
			case "00110":	c = '6';
				break;
			case "00111":	c = '7';
				break;
			case "01000":	c = '8';
				break;
			case "01001":	c = '9';
				break;
			case "00000":	c = '0';
				break;
		}
		return c;
	}
}
