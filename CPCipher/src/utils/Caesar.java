package utils;

public class Caesar {
	public static String removeSpaces(String str) {
		StringBuilder sb = new StringBuilder();
		String[] output = str.split("[\\W]+");
		for (int i = 0; i < output.length; i++) {
			sb.append(output[i]);
		}
		return sb.toString().toUpperCase();
	}
	
	public static char shiftChar(char letter, int num) {
		int val = (int) letter;
		int adjust = 0;
		if (val + num > 90) {
			adjust = val + num - 26;
			return (char) adjust;
		} else {
			return (char) (val + num);
		}
	}
	
	public static String encrypt(String text, int num) {
		text = removeSpaces(text);
		StringBuilder sb = new StringBuilder();
		char[] arr = text.toCharArray();
		char[] shiftedArr = new char[arr.length];
		for (int i = 0; i < arr.length; i++) {
			shiftedArr[i] = shiftChar(arr[i], num);
			sb.append(shiftedArr[i]);
		}
		return sb.toString();
	}
	
	public static char unshiftChar(char letter, int num) {
		int val = (int) letter;
		int adjust = 0;
		if (val - num < 65) {
			adjust = val - num + 26;
			return (char) adjust;
		} else {
			return (char) (val - num);
		}
	}
	
	public static String decrypt(String text, int num) {
		text = removeSpaces(text);
		StringBuilder sb = new StringBuilder();
		char[] arr = text.toCharArray();
		char[] shiftedArr = new char[arr.length];
		for (int i = 0; i < arr.length; i++) {
			shiftedArr[i] = unshiftChar(arr[i], num);
			sb.append(shiftedArr[i]);
		}
		return sb.toString();
	}
}
