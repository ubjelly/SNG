package org.sng.util;

import java.util.Random;

/**
 * Serves to provide better generation of names.
 * @author Stephen Andrews
 */
public class NamingUtility {

	/**
	 * Formats a given string to have a capital letter followed
	 * by lower case letters.
	 * @param input The string to format.
	 * @return The formatted string.
	 */
	public static String format(String input) {
		return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
	}
	
	/**
	 * Replaces any 3 consecutive consants with a random vowel
	 * within a word.
	 * @param input The string to analyze.
	 * @return The new string.
	 */
	public static String replaceRepetitveConsonants(String input) {
		Random random = new Random();
		char[] vowels = {'a', 'e', 'i', 'o', 'u'};
		char lastChar = input.charAt(0);
		int repeatingCharacters = 0;
		int indexToReplace = 0;
		
		//Start at the second char.
		for (int i = 1; i < input.length(); i++) {
			if (input.charAt(i) == lastChar) {
				repeatingCharacters++;
				if (repeatingCharacters == 1) {
					indexToReplace = i;
				}
				if (repeatingCharacters == 2) {
					StringBuilder newString = new StringBuilder(input);
					newString.setCharAt(indexToReplace, vowels[random.nextInt(vowels.length)]);
					input = newString.toString();
				}
			} else {
				repeatingCharacters = 0;
			}
			lastChar = input.charAt(i);	
		}
		return input;
	}
}
