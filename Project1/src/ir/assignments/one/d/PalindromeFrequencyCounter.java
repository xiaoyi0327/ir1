package ir.assignments.one.d;

import ir.assignments.one.a.Frequency;
import ir.assignments.one.a.Utilities;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PalindromeFrequencyCounter {
	/**
	 * This class should not be instantiated.
	 */
	private PalindromeFrequencyCounter() {}
	
	/**
	 * Takes the input list of words and processes it, returning a list
	 * of {@link Frequency}s.
	 * 
	 * This method expects a list of lowercase alphanumeric strings.
	 * If the input list is null, an empty list is returned.
	 * 
	 * There is one frequency in the output list for every 
	 * unique palindrome found in the original list. The frequency of each palindrome
	 * is equal to the number of times that palindrome occurs in the original list.
	 * 
	 * Palindromes can span sequential words in the input list.
	 * 
	 * The returned list is ordered by decreasing size, with tied palindromes sorted
	 * by frequency and further tied palindromes sorted alphabetically. 
	 * 
	 * The original list is not modified.
	 * 
	 * Example:
	 * 
	 * Given the input list of strings 
	 * ["do", "geese", "see", "god", "abba", "bat", "tab"]
	 * 
	 * The output list of palindromes should be 
	 * ["do geese see god:1", "bat tab:1", "abba:1"]
	 *  
	 * @param words A list of words.
	 * @return A list of palindrome frequencies, ordered by decreasing frequency.
	 */
	private static List<Frequency> computePalindromeFrequencies(ArrayList<String> words) {
		// TODO Write body!
		// You will likely want to create helper methods / classes to help implement this functionality
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		List<Frequency> list = new ArrayList<Frequency>();
		for(int i = 0; i < words.size() ; i++){
			String strA = words.get(i);
			if(checkPalindrome(strA)){
				if(!map.containsKey(strA))
					map.put(strA, 1);
				else
					map.put(strA, map.get(strA) + 1);
			}
			for(int j = i + 1; j < words.size(); j++){
				strA = strA + words.get(j);
				if(checkPalindrome(strA)){
					if(!map.containsKey(strA))
						map.put(strA, 1);
					else
						map.put(strA, map.get(strA) + 1);
				}
				
			}
		}
		for(String key : map.keySet()){
			Frequency fr = new Frequency(key, map.get(key));
			list.add(fr);
		}
		return list;
	}
	
	private static boolean checkPalindrome(String str){
		if(str.length() == 1)
			return false;
		for(int i = 0 ; i <= str.length()/2 ; i++){
			if(str.charAt(i) == str.charAt(str.length() - i - 1))
				continue;
			else 
				return false;
		}
		return true;
	}
	
	/**
	 * Runs the 2-gram counter. The input should be the path to a text file.
	 * 
	 * @param args The first element should contain the path to a text file.
	 */
	public static void main(String[] args) {
		File file = new File("src/analysis.txt");
		ArrayList<String> words = Utilities.tokenizeFile(file);
		List<Frequency> frequencies = computePalindromeFrequencies(words);
		Utilities.printFrequencies(frequencies);
	}
}
