package org.sng.engine;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import org.sng.Window;
import org.sng.util.NamingUtility;

/**
 * Generates unique random names based on the user's input.
 * @author Stephen Andrews
 */
public class Generator {

	/**
	 * An output object to prevent duplicate generations.
	 */
	private Output output;
	
	/**
	 * A list of all the inputted names to be used in the
	 * generation process.
	 */
	private ArrayList<String> userInput;
	
	/**
	 * How long our generation process took.
	 */
	private long duration;
	
	/**
	 * The current name to add.
	 */
	private String currentName;
	
	/**
	 * Construct a generator object.
	 */
	public Generator() {
		output = new Output();
		userInput = new ArrayList<String>();
		duration = 0;
		currentName = "";
	}
	
	/**
	 * Gets the user's input and formats it, while simultaneously
	 * adding data into the ArrayList.
	 * @param input The input to format.
	 */
	private void getInput(String input) {
		String[] data = input.split(",\n");
		for (String str : data) {
			userInput.add(str);
		}
	}
	
	/**
	 * Selects a random string from the user's input. Next it takes
	 * a random substring of a length ranging from 1 to 3 characters
	 * starting at a random index based on the string's length.
	 */
	private String getPart() {
		Random random = new Random();
		String selectedString = userInput.get(random.nextInt(userInput.size()));
		int range = random.nextInt(3) + 1;
		int startingIndex = random.nextInt(selectedString.length());
		
		//Out of bounds prevention
		if (startingIndex + range > selectedString.length()) {
			return selectedString.substring(startingIndex);
		}
		
		return selectedString.substring(startingIndex, startingIndex + range);
	}
	
	/**
	 * Concatenates 3 strings to form a name.
	 * @return The name formed.
	 */
	private String formName() {
		String raw = getPart() + getPart() + getPart();
		raw = NamingUtility.replaceRepetitveConsonants(raw);
		raw = NamingUtility.format(raw);
		return raw;
	}
	
	/**
	 * Displays the generated names in the output area.
	 */
	private void showOutput() {
		String result = "";
		for (String str : output.get()) {
			result += str + "\n";
		}
		Window.getOutput().setText(result);
	}
	
	/**
	 * The steps taken to generate a name.
	 * @param input The user's input.
	 */
	private void generationProcess(String input) {
		if (!canGenerate(input)) {
			JOptionPane.showMessageDialog(null, "Please format your input correctly! \n\n"
					+ "Example, \n"
					+ "Example1, \n"
					+ "Example2, \n");
			return;
		}
		
		getInput(input);
		currentName = formName();
		while (!output.get().contains(currentName)) {
			output.add(currentName);
			currentName = formName();
		}
		showOutput();
	}
	
	/**
	 * The main loop to constantly generate names.
	 * @param input The user's input.
	 */
	public void generate(String input) {
		output.get().clear();
		long startTime = System.nanoTime();
		generationProcess(input);
		if (!canGenerate(input)) return;
		long endTime = System.nanoTime();
		duration = (endTime - startTime);
		JOptionPane.showMessageDialog(null, "Generated " + output.get().size() 
				+ " results in " + getDuration() + "ms.");
	}
	
	/**
	 * Determines whether or not a user can generate names.
	 * @param input The user's input
	 * @return true If the user can.
	 */
	private boolean canGenerate(String input) {
		if (input.equals("") || !input.contains(",")) {
			return false;
		}
		return true;
	}
	
	/**
	 * Returns the duration in ms.
	 * @return The duration.
	 */
	private long getDuration() {
		return duration/1000000;
	}
}
