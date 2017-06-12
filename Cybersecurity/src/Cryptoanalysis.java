import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Cryptoanalysis {
	
	// variables
	
	private int key;
	private static HashMap<Character, Character> letters = new HashMap<Character, Character>();
	private static HashMap<Character, Character> reverseLetters = new HashMap<Character, Character>();
	
	
	// fill hash map with letters A-Z and corresponding shifted value
	
	public void buildHashes(){

		// get key from user
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter your cipher key: ");
		
		key = scan.nextInt();
		
		scan.close();
		
		
		// upper case letters for encryption
		
		for (int i = 65; i <= 90; i++)
		{
			if (i + key <= 90)
			{
				letters.put((char)i, (char)(i+key));
			}
			else
			{
				letters.put((char)i, (char)(i+key-26));
			}
		}
		
		
		// lower case letters for encryption
		
		for (int i = 97; i <= 122; i++)
		{
			if (i + key <= 122)
			{
				letters.put((char)i, (char)(i+key));
			}
			else
			{
				letters.put((char)i, (char)(i+key-26));
			}
		}
		
		
		// upper case letters for decryption
		
		for (int i = 65; i <= 90; i++)
		{
			if (i - key >= 65)
			{
				reverseLetters.put((char)i, (char)(i-key));
			}
			else 
			{
				reverseLetters.put((char)i, (char)(i-key+26));
			}
		}
		
		
		// lower case letters for decryption
		
		for (int i = 97; i <= 122; i++)
		{
			if (i - key >= 97)
			{
				reverseLetters.put((char)i, (char)(i-key));
			}
			else 
			{
				reverseLetters.put((char)i, (char)(i-key+26));
			}
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
		Cryptoanalysis ca = new Cryptoanalysis();
		
		ca.buildHashes();
		
		ca.encrypt();

		ca.decrypt();
	}
	
	
}
