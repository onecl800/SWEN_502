package chatbot;


import java.util.ArrayList;
import java.util.Scanner;

public class ChatBot {
	
	
	String userInput;
	String response;
	
	ArrayList<String> responses = new ArrayList<String>();

	
	//add possible responses to responses array
	public void addResponses() {
		
		responses.add("Hello");
		responses.add("Hi there!");
		responses.add("How are you today?");
		responses.add("Good thanks, what can I get for you today?");
		responses.add("What flavour ice cream would you like?");
		responses.add("We have chocolate, vanilla, strawberry and banana flavours");
		responses.add("Would you like a single or double ice cream?");
		responses.add("Would you like it dipped in chocolate?");
		responses.add("Here's your ice cream, the cost is $5");
		responses.add("Thanks, see ya");
		responses.add("Have a nice day");
		responses.add("Enjoy your ice cream!");
	}

	
	//read in userInput
	public void readInput() {
		Scanner scan = new Scanner(System.in);
		userInput = scan.next();		
	}
	
	
	//respond appropriately by printing output
	//improvements - help the chatbot respond more appropriately by checking for key words in the userInput 
	//and selecting a response that based on that keyword
	public void respondToUser() {
		int rand;
		
		if (userInput.contains("hello") || userInput.contains("hi")) {
			rand = (int)(Math.random()*3);
			if (rand < 1) {
				System.out.println(responses.get(0));
			} else if (rand > 1 && rand < 2) {
				System.out.println(responses.get(1));
			} else {
				response = responses.get(2).toString();
				System.out.println(response);
			}			
			
		} else if (userInput.contains("good") || userInput.contains("how") || userInput.contains("are") || userInput.contains("you")) {
			System.out.println(responses.get(3));
			
		} else if (userInput.contains("ice") || userInput.contains("cream") || userInput.contains("please") || userInput.contains("you")) {
			rand = (int)(Math.random()*3);
			if (rand < 1) {
				System.out.println(responses.get(4));
			} else if (rand > 1 && rand < 2) {
				System.out.println(responses.get(5));
			} else {
				response = responses.get(6).toString();
				System.out.println(response);
			}	
			
			
		} else if (userInput.contains("flavour") || userInput.contains("flavours") || userInput.contains("what")) {
			rand = (int)(Math.random()*2);
			if (rand < 1) {
				System.out.println(responses.get(4));
			} else {
				System.out.println(responses.get(5));
			}
			
		} else if (userInput.contains("yes") || userInput.contains("can") || userInput.contains("have") || userInput.contains("banana")) {
			rand = (int)(Math.random()*3);
			if (rand < 1) {
				System.out.println(responses.get(6));
			}else if (rand < 2) {
				System.out.println(responses.get(7));
			} else {
				System.out.println(responses.get(8));
			}
			
		} else if (userInput.contains("thanks") || userInput.contains("bye") || userInput.contains("see you later")) {
			rand = (int)(Math.random()*3);
			if (rand < 1) {
				System.out.println(responses.get(9));
			}else if (rand < 2) {
				System.out.println(responses.get(10));
			} else {
				System.out.println(responses.get(11));
			}
			
		} else {
			System.out.println("Sorry I don't know how to respond");
		}
	}
	
	
	//have a convo with the chatbot as long as the user keeps entering input
	public void haveAConversation() {
		Scanner scan = new Scanner(System.in);
		System.out.println("**Enter text to start talking to the chatbot**");
		
		while (scan.hasNext()) {

			readInput();
		
			respondToUser();
		}
		
	}
	
	

	public static void main(String[] args) {
		
		ChatBot chat = new ChatBot();
		
		chat.addResponses();
		
		chat.haveAConversation();
		
	}
	
}
