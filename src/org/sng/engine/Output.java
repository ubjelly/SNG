package org.sng.engine;

import java.util.ArrayList;

/**
 * Deals specifically with storing all of the uniquely generated names.
 * @author Stephen Andrews
 */
public class Output {

	/**
	 * Contains all of the names that have already been generated.
	 */
	private ArrayList<String> generatedNames;
	
	/**
	 * Constructs our output object.
	 */
	public Output() {
		generatedNames = new ArrayList<String>();
	}
	
	/**
	 * Adds an output to the generated names array list.
	 * @param output The output to add.
	 */
	public void add(String output) {
		generatedNames.add(output);
	}
	
	/**
	 * Gets all the outputs.
	 * @return The generated names array list.
	 */
	public ArrayList<String> get() {
		return generatedNames;
	}
	
}
