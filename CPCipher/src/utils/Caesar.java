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
	
	
}
