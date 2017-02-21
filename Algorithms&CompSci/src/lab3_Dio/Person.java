package lab3_Dio;

/**
 * 
 * @author Dionysis Athanasopoulos <dionysiscsuoi@gmail.com>
 *
 */
public class Person {

	//Attributes.
	private int id;
	private String name;
	private Person next;


	public Person ( int cID, String cName ){

		id = cID;

		name = cName;
	}


	//Setters.
	protected void setID( int cID ){

		id = cID;
	}

	protected void setName( String cName ){

		name = cName;
	}

	protected void setNext( Person p ){

		next = p;
	}


	//Getters.
	protected int getID(){ return id; }
	protected String getName(){ return name; }
	protected Person getNext(){ return next; }


	//Print.
	protected String print(){

		return id + ": " + name;
	}
}
