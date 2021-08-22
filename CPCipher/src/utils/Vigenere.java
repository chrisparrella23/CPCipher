package utils;

import java.util.Optional;

import javafx.scene.control.TextInputDialog;

public class Vigenere {
	
	/*TODO
	 * Do exception handling for empty/numeric input for key.
	 */
	
	/** Encrypts the given plaintext using the given key.
	 * @param text A String representing the plaintext 
	 * 		to be encrypted.
	 * @param key A String representing the key used for
	 * 		encryption.
	 * 
	 * @return A string representing the ciphertext.
	 */
	public static String encrypt(String text) {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Encrypt");
		dialog.setContentText("Enter the keyword.");
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()) {
			String key = result.get().toUpperCase();
			text = Caesar.removeSpaces(text);
			StringBuilder sb = new StringBuilder();
			char[] inputArr = text.toCharArray();
			char[] keyArr = key.toCharArray();
			char[] outputArr = new char[inputArr.length];
			int j = 0;
			for (int i = 0; i < inputArr.length; i++) {
				if (j == keyArr.length) {
					j = 0;
				}
				outputArr[i] = (char) (((inputArr[i] + keyArr[j]) % 26) + 65);
				sb.append(outputArr[i]);
				j++;
			}
			return sb.toString();
		} else {
			// put exception handling here.
		}
		return text;
	}
	
	/** Decrypts the given ciphertext.
	 * 
	 * @param text A String representing the ciphertext 
	 * 		to be decrypted.
	 * @param key A String representing the key used to
	 * 		decipher the ciphertext.
	 * @return A String representing the plaintext.
	 */
	public static String decrypt(String text) {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Encrypt");
		dialog.setContentText("Enter the keyword.");
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()) {
			String key = result.get().toUpperCase();
			StringBuilder sb = new StringBuilder();
			char[] inputArr = text.toCharArray();
			char[] keyArr = key.toCharArray();
			char[] outputArr = new char[inputArr.length];
			int j = 0;
			for (int i = 0; i < inputArr.length; i++) {
				if (j == keyArr.length) {
					j = 0;
				}
				outputArr[i] = (char) ((((inputArr[i] - keyArr[j]) + 26) % 26) + 65);
				sb.append(outputArr[i]);
				j++;
			}
			return sb.toString();
		} else {
			// Put exception handling here.
		}
		return text;
	}

}

