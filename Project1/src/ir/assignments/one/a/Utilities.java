package ir.assignments.one.a;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A collection of utility methods for text processing.
 */
public class Utilities {
	/**
	 * Reads the input text file and splits it into alphanumeric tokens.
	 * Returns an ArrayList of these tokens, ordered according to their
	 * occurrence in the original text file.
	 * 
	 * Non-alphanumeric characters delineate tokens, and are discarded.
	 *
	 * Words are also normalized to lower case. 
	 * 
	 * Example:
	 * 
	 * Given this input string
	 * "An input string, this is! (or is it?)"
	 * 
	 * The output list of strings should be
	 * ["an", "input", "string", "this", "is", "or", "is", "it"]
	 * 
	 * @param input The file to read in and tokenize.
	 * @return The list of tokens (words) from the input file, ordered by occurrence.
	 */
	@SuppressWarnings("resource")
	public static ArrayList<String> tokenizeFile(File input) {
		// TODO Write body!
		ArrayList<String> list = new ArrayList<String>();
		Scanner sc = null;
		try {
			sc = new Scanner(input);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(sc.hasNextLine()){
			Scanner sc2 = new Scanner(sc.nextLine());
			while(sc2.hasNext()){
				String str = sc2.next();
				list.add(str.replaceAll("\\pP|\\pS", ""));
			}
		}
		return list;
	}
	
	/**
	 * Takes a list of {@link Frequency}s and prints it to standard out. It also
	 * prints out the total number of items, and the total number of unique items.
	 * 
	 * Example one:
	 * 
	 * Given the input list of word frequencies
	 * ["sentence:2", "the:1", "this:1", "repeats:1",  "word:1"]
	 * 
	 * The following should be printed to standard out
	 * 
	 * Total item count: 6
	 * Unique item count: 5
	 * 
	 * sentence	2
	 * the		1
	 * this		1
	 * repeats	1
	 * word		1
	 * 
	 * 
	 * Example two:
	 * 
	 * Given the input list of 2-gram frequencies
	 * ["you think:2", "how you:1", "know how:1", "think you:1", "you know:1"]
	 * 
	 * The following should be printed to standard out
	 * 
	 * Total 2-gram count: 6
	 * Unique 2-gram count: 5
	 * 
	 * you think	2
	 * how you		1
	 * know how		1
	 * think you	1
	 * you know		1
	 * 
	 * @param frequencies A list of frequencies.
	 */
	public static void printFrequencies(List<Frequency> frequencies) {
		// TODO Write body!
		int total = 0;
		for(int i = 0 ; i < frequencies.size() ; i++){
			total = total + frequencies.get(i).getFrequency();
		}
		if(frequencies.get(0).getText().contains(" ")){
			System.out.println("Total 2-gram count:"+total);
			System.out.println("Unique 2-gram count:"+frequencies.size());
		}else{
			System.out.println("Total item count:"+total);
			System.out.println("Unique item count:"+frequencies.size());
		}
		for(int i = 0; i<frequencies.size();i++){
			System.out.format("%15s%15d%n",frequencies.get(i).getText(),frequencies.get(i).getFrequency());
		}
		//Standard out
	}
}
