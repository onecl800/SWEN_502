import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

// do the same with atbashII cipher - all letters are shifted first by a word, then by a chosen number

public class AtbashCipherII {

	// variables
	
	private int key;
	private String word;
	private static HashMap<Character, Character> letters = new HashMap<Character, Character>();
	private static HashMap<Character, Character> reverseLetters = new HashMap<Character, Character>();
	
	
	// fill hash map with letters A-Z and corresponding shifted value
	
	public void buildHashes(){

		// get keyword and key from user
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter your cipher word: ");
		
		word = scan.next();
		
		System.out.println("Enter your cipher key: ");
		
		key = scan.nextInt();
		
		scan.close();
		
		
		// build word cipher (upper case)
		
		int j = 65;
		
		for (int i = 0; i < word.length(); i++)
		{
			if (Character.isLetter(word.charAt(i)))
			{
				char key = Character.toUpperCase(word.charAt(i));
				letters.put(key, (char)(j));
				j++;
			}
		}
		
		
		// rest of upper case letters for encryption
		
		for (int i = 65; i <= 90; i++)
		{
			// check if key is already in the list (from the key word)
			if (letters.containsKey((char)(i)))
			{
				continue;
			}
			else 
			{
				letters.put((char)i, (char)(j));
				j++;		
			}
		}
		
		
		// build word cipher (lower case)
		
		int k = 97;
		
		for (int i = 0; i < word.length(); i++)
		{
			if (Character.isLetter(word.charAt(i)))
			{
				char letter = Character.toLowerCase(word.charAt(i));
				letters.put(letter, (char)(k));
				k++;
			}
		}
		
		
		// rest of lower case letters for encryption
		
		for (int i = 97; i <= 122; i++)
		{
			if (letters.containsKey((char)i))
			{
				continue;
			}
			else
			{
				letters.put((char)i, (char)(k));
				k++;
			}
		}
		
		
		// upper case letters for decryption
		
		for (HashMap.Entry entry : letters.entrySet())
		{	
			char key = (char)entry.getKey();
			char value = (char)entry.getValue();
			reverseLetters.put(value, key);
		}
	}
	
	
	// encrypt text
	
	public void encrypt()
	{
		// read file to be encrypted
		
		String text = "";
		
		try
	    {
	        BufferedReader br = new BufferedReader(new FileReader("100YearsOfSolitude.txt"));
	        String line;
	        while ((line = br.readLine()) != null)
	        {
	            text += (line);
	        }
	        br.close();
	    }
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

		
		// write encrypted text to new file
		
		try {
			FileWriter fw = new FileWriter("encryptedfile.txt");
					
			for (int i = 0; i < text.length(); i++)
			{
				// if character is upper case or lower case
				if ((int)(text.charAt(i)) >= 65 && (int)(text.charAt(i)) <= 90 || (int)(text.charAt(i)) >= 97 && (int)(text.charAt(i)) <= 122)
				{
					char newLetter = letters.get(text.charAt(i));
					fw.write(newLetter);
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
		
		System.out.println("Plain text file has been encrypted");
	}
	
	
	// decrypt text
	
	public void decrypt()
	{
		// read file to be decrypted
		
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
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

		
		// write decrypted text to new file
		
		try {
			FileWriter fw = new FileWriter("decryptedfile.txt");

			for (int i = 0; i < text.length(); i++)
			{
				// if character is upper case or lower case i.e. between 65 and 90, and 97 and 122
				if ((int)(text.charAt(i)) >= 65 && (int)(text.charAt(i)) <= 90 || (int)(text.charAt(i)) >= 97 && (int)(text.charAt(i)) <= 122)
				{
					char newLetter = reverseLetters.get(text.charAt(i));
					fw.write(newLetter);
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
		
		System.out.println("Encrypted file has been decrypted");
	}
	
	
	public static void main(String[] args) 
	{
		AtbashCipherII ac = new AtbashCipherII();
		
		ac.buildHashes();
		
		ac.encrypt();

		ac.decrypt();
	}
		

}
