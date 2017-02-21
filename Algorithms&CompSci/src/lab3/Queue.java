/*
*
* Claire O'Neill
*
*
*/

package lab3;

//first in first out

public class Queue {
	
	
	//inner class for person
	private class Person {
		
		//variables for Person class
		public String name;
		public Person next;
			

		//person getters and setters
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
	}
		
	//variables for Queue class
	private Person first;

		
	//Queue constructor for empty list
	public Queue () {
		first = null;
	}
		
	
	
	//method to create a new person
	private Person createPerson(String name) {
		
		//create new person object
		Person person = new Person();
		
		//set name
		person.setName(name);
		
		return person;
	}		
	
	
	//method to insert person into list
	public void insert(Person newPerson) {
		
		//if first is currently empty, the new person is placed at first
		if (first == null) {
			first = newPerson;
			System.out.println("First: " + first.getName());
			
		
		
		//if first is already filled, then traverse the stack until newPerson.next is equal to null, and place the new person at the end of the stack
		} else {
			Person person = first;
			while (person.getNext() != null) {
				person = person.next;
			}
			if (person.next == null) {
				person.setNext(newPerson);
				System.out.println("Queue: " + newPerson.getName());
			}
			
		}
	}
	
	
	public void insert(String name) {
		
		//call createPerson method to create new person
		Person person = createPerson(name);
		
		//call insert method to insert new person into stack
		insert(person);
	}

		
	//remove person from list	
	public Person remove() {
			
		if (first == null) {
			throw new NullPointerException();
		}
		
		//item after first person becomes new first
		Person person = first;
		first = person.next;
		System.out.println("New first: " + first.getName());
	
		return person;
	}
		
		
	public static void main(String[] args) {
		
		//create new queue
		Queue queue = new Queue();
			
		//add persons to queue
		queue.insert("Claire");
		queue.insert("Lolly");
		queue.insert("Cake");
		queue.insert("Icecream");
		queue.insert("MarsBar");
		queue.insert("Caramel");
		queue.insert("Licorice");
		
			
		//remove person from queue
		queue.remove();
		queue.remove();
	
		
		queue.insert("Chocolate");
		queue.remove();
	}

}
