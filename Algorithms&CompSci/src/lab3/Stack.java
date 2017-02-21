/*
*
* Claire O'Neill
*
*
*/


package lab3;

//stack is first in last out

public class Stack {
	
	

	//inner class for person
	private class Person {
	
		//variables for Person class
		private String name;
		private Person next;
		private Person previous;
		

		//getters and setters for Person class
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Person getNext() {
			return next;
		}
		public void setNext(Person next) {
			this.next = next;
		}	
		public Person getPrevious() {
			return previous;
		}
		public void setPrevious(Person previous) {
			this.previous = previous;
		}
		
	}
	
	
	//variables for Stack class
	private Person first;
	private Person last;

	
	//constructor for empty stack
	public Stack () {
		first = null;
		last = null;
	}
	
	
	//method to create a new person
	private Person createPerson(String name) {
	
		Person person = new Person();
		person.setName(name);
		
		return person;
	}	
	
	

	public void insert(Person newPerson) {
			
		
		//if first is currently empty, the new person is placed at first
		if (first == null) {
			first = newPerson;
			System.out.println("First: " + first.getName());
		
			
		//if first is already filled, then traverse the stack until person.next is equal to null
		} else {
			Person previous = first;
			Person temp = first;
			while (temp != null) {
				previous = temp;
				temp = temp.getNext();
			}
			
			//person.next is null, end of stack reached, add newPerson here
			previous.setNext(newPerson);
			System.out.println("Previous: " + previous.getName() + ", new person: " + newPerson.getName());
				
		}
	}
	
	
	public void insert(String name) {
		
		//call createPerson method to create new person
		Person person = createPerson(name);
		//call insert method to insert new person into stack
		insert(person);
	}

	
	
	
	//remove last added person from list
	public void remove() {
		
		//throw exception if first is null, because this means the list is empty and there is nothing to remove
		if (first == null) {
			throw new NullPointerException();
			
					
			
		//remove last added item from the list. set person to first, then increment through list using person.next
		//once person.next is null, set person to null
		} else {
			Person previous = first;
			Person person = first;	
			
			while (person.getNext() != null) {
				previous = person;
				person = person.next;
			}
			
			if (person.getNext() == null) {
				System.out.println("Removed: " + person.getName());
				person = null;
				previous.setNext(null);	
			}	
		}
	}
		
	
	
	public static void main(String[] args) {
		
		//create new stack
		Stack stack = new Stack();
		

		//create new people and add to stack
		stack.insert("Claire");
		stack.insert("David");
		stack.insert("Justine");
		stack.insert("Michael");
		stack.insert("Lemon");
		stack.insert("Jones");
		stack.insert("Ruby");
		stack.insert("Margaret");
		
		//remove someone from the stack
		stack.remove();
		stack.remove();
		
		stack.insert("Hello");
		
		stack.remove();
		
	}

}
