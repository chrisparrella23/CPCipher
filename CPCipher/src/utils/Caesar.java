package utils;

import java.util.Optional;

import javafx.scene.control.TextInputDialog;

public class Caesar {
	
	/** Removes spaces from the text and capitalizes all letters.
	 * 
	 * @param str A String representing the text.
	 * @return The given String with all spaces removed and in all capital letters.
	 */
	public static String removeSpaces(String str) {
		StringBuilder sb = new StringBuilder();
		String[] output = str.split("[\\W]+");
		for (int i = 0; i < output.length; i++) {
			sb.append(output[i]);
		}
		return sb.toString().toUpperCase();
	}
	
	/** Shifts a character forward by a given number. It is designed to wrap around the alphabet. Numerals are unaffected.
	 * 
	 * @param letter A char.
	 * @param num An int representing the number of ASCII
	 * 		codes by which to shift the letter.
	 * @return A char after shifting.
	 */
	public static char shiftChar(char letter, int num) {
		int val = (int) letter;
		int adjust = 0;
		if (val >= 48 && val <= 57) {
			return (char) val;
		} else if (val + num > 90) {
			adjust = val + num - 26;
			return (char) adjust;
		}
		return (char) (val + num);
	}
	
	/** Encrypts the given plaintext.
	 * 
	 * @param text A String representing the plaintext.
	 * @param num An int representing the number of spaces
	 * 		by which to shift each letter in the plaintext.
	 * @return A String representing the shifted plaintext.
	 */
	public static String encrypt(String text) {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Encrypt");
		dialog.setContentText("Enter a number.");
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()) {
			int num = Integer.parseInt(result.get());
			
			text = removeSpaces(text);
			StringBuilder sb = new StringBuilder();
			char[] arr = text.toCharArray();
			char[] shiftedArr = new char[arr.length];
			for (int i = 0; i < arr.length; i++) {
				shiftedArr[i] = shiftChar(arr[i], num);
				sb.append(shiftedArr[i]);
			}
			return sb.toString();
		} else {
			// put exception handling here.
		}
		return text;
	}
	
	/** Shifts a character back by a given number to its original character. It is designed to wrap around the alphabet. Numerals are unaffected.
	 * 
	 * @param letter A char.
	 * @param num An int representing the number of ASCII
	 * 		codes by which to shift the letter.
	 * @return The original char after unshifting.
	 */
	public static char unshiftChar(char letter, int num) {
		int val = (int) letter;
		int adjust = 0;
		if (val >= 48 && val <= 57) {
			return (char) val;
		} else if (val - num < 65) {
			adjust = val - num + 26;
			return (char) adjust;
		} else {
			return (char) (val - num);
		}
	}
	
	/** Decrypts the given ciphertext.
	 * 
	 * @param text A String representing the ciphertext.
	 * @param num An int representing the number of spaces
	 * 		by which to shift each letter in the ciphertext.
	 * @return A String representing the decrypted plaintext.
	 */
	public static String decrypt(String text) {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Encrypt");
		dialog.setContentText("Enter a number.");
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()) {
			int num = Integer.parseInt(result.get());
			text = removeSpaces(text);
			StringBuilder sb = new StringBuilder();
			char[] arr = text.toCharArray();
			char[] shiftedArr = new char[arr.length];
			for (int i = 0; i < arr.length; i++) {
				shiftedArr[i] = unshiftChar(arr[i], num);
				sb.append(shiftedArr[i]);
			}
			return sb.toString();
		} else {
			// put exception handling here.
		}
		return text;
	}
}
