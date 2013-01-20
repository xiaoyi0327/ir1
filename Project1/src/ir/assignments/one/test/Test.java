package ir.assignments.one.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import ir.assignments.one.a.Frequency;
import ir.assignments.one.a.Utilities;
import ir.assignments.one.b.WordFrequencyCounter;
import ir.assignments.one.c.TwoGramFrequencyCounter;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("src/analysis.txt");
		List<String> list = Utilities.tokenizeFile(file);
		List<Frequency> frequencies = WordFrequencyCounter.computeWordFrequencies(list);
		Utilities.printFrequencies(frequencies);
	}

}
