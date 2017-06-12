import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

// do frequency analysis on encrypted text. Use the outcomes to decipher at least the 3 commonest letters

// first, need to iterate through the encrypted file, and find the most frequent letters. keep count of the letters in a hashmap with each letter and count 
public class FrequencyAnalysis {
	
	// variables 
	
	private static HashMap<Character, Integer> letters = new HashMap<Character, Integer>();
	private static HashMap<Character, Character> orderedLetters = new HashMap<Character, Character>();
	private static ArrayList<Character> freqLetters = new ArrayList<Character>();
	
	
	// build initial map and array of letters ordered by frequency
	
	public void buildMap()
	{
		for (int i = 65; i <= 90; i++)
		{
			// add letters A-Z
			
			letters.put((char)i, 0);
		}

		
		// letters in order of frequency: etaoinshrdlcumwfgypbvkjxqz
		
		freqLetters.add('E');
		freqLetters.add('T');
		freqLetters.add('A');
		freqLetters.add('O');
		freqLetters.add('I');
		freqLetters.add('N');
		freqLetters.add('S');
		freqLetters.add('H');
		freqLetters.add('R');
		freqLetters.add('D');
		freqLetters.add('L');
		freqLetters.add('C');
		freqLetters.add('U');
		freqLetters.add('M');
		freqLetters.add('W');
		freqLetters.add('F');
		freqLetters.add('G');
		freqLetters.add('Y');
		freqLetters.add('P');
		freqLetters.add('B');
		freqLetters.add('V');
		freqLetters.add('K');
		freqLetters.add('J');
		freqLetters.add('X');
		freqLetters.add('Q');
		freqLetters.add('Z');	
	}
	
	public void analyseFile()
	{
		// read file
		
		String text = "";
		
		try
	    {
	        BufferedReader br = new BufferedReader(new FileReader("encryptedfile.txt"));
	        String line;
	        while ((line = br.readLine()) != null)
	        {
	            text += (line);
	        }
	        br.close();
	    }
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } 
		catch (IOException e) {
	        e.printStackTrace();
	    }
		
		
		// count number of occurrences of each character
		
		for (int i = 0; i < text.length(); i++)
		{
			char letter = Character.toUpperCase(text.charAt(i));
			if (letters.containsKey(letter))
			{
				int value = letters.get(letter);
				value = value + 1;
				letters.put(letter, value);
			}
		}
		
		
		// pair letters from text with letters by frequency in English language, desc
		
		int j = 0;
		
		for (int i = 0; i < 26; i++)
		{
			int highestFreq = 0;
			char key = 'A';
			int value = 1;
				
			for (HashMap.Entry<Character, Integer> entry : letters.entrySet()) {
			    
				value = entry.getValue();

				if (value > highestFreq) 
				{	
					highestFreq = value;
					key = entry.getKey();
				}
			}
			orderedLetters.put(key, freqLetters.get(j));
			letters.remove(key);
			j++;
		}
				
		
		// replace letters in text string with corresponding letter from hash
			
		try
		{
			FileWriter fw = new FileWriter("freqAnalysis.txt");

			for (int i = 0; i < text.length(); i++)
			{
				char key = Character.toUpperCase(text.charAt(i));

				if (key >= 65 && key <= 90)
				{
					char value = orderedLetters.get(key);
					
					fw.write(value);
				}

				// if any other character
				else
				{
					fw.write(text.charAt(i));
				}
			}
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	
	public static void main (String[] args)
	{
		FrequencyAnalysis fa = new FrequencyAnalysis();
		
		fa.buildMap();
		
		fa.analyseFile();
	}

}
