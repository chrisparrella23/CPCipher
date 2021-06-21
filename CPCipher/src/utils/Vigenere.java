package utils;

public class Vigenere {
	
	public static char shiftChar(char letter, char key) {
		int val = (int) letter;
		int keyVal = (int) key;
		int difference = Math.abs(val - keyVal);
		int adjust = 0;
		if (val + keyVal > 90) {
			adjust = val + keyVal - 65;
			return (char) adjust;
		} else {
			return (char) (val + keyVal);
		}
	}
	
	public static String encrypt(String text, String key) {
		text = CaesarShift.removeSpaces(text);
	}

}
