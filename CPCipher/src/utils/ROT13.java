package utils;

public class ROT13 {
	
	/** Rotates the message by 13 letters. E.g., 'ABCDE' becomes 'NOPQR'.
	 * 
	 * @param text A string representing the text to be rotated.
	 * @return The string after rotation.
	 */
	public static String rotate(String text) {
		text = Caesar.removeSpaces(text);
		StringBuilder sb = new StringBuilder();
		char[] arr = text.toCharArray();
		char[] shiftedArr = new char[arr.length];
		for (int i = 0; i < arr.length; i++) {
			shiftedArr[i] = rotateChar(arr[i]);
			sb.append(shiftedArr[i]);
		}
		return sb.toString();
	}
	
	/** Rotates the given letter by 13 places. E.g., 'A' becomes 'N'.
	 * 
	 * @param letter A char representing the letter to be rotated.
	 * @return The rotated letter.
	 */
	public static char rotateChar(char letter) {
		int val = (int) letter;
		int adjust = 0;
		if (val >= 48 && val <= 57) {
			return (char) val;
		} else if (val + 13 > 90) {
			adjust = val + 13 - 26;
			return (char) adjust;
		}
		return (char) (val + 13);
	}
}
