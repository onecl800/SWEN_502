package lab3_Dio;

/*
 * 
 * @author Dionysis Athanasopoulos <dionysiscsuoi@gmail.com>
 *
 */
public class PersonList {

	//Attributes.
	private Person first;


	//Methods.
	public void addPerson( String name ){

		int newID = 0;


		Person previous = null, tmp = first;

		while( tmp != null ){

			previous = tmp;

			tmp = tmp.getNext();

			newID++;
		}


		Person p = new Person( newID, name );

		if( previous == null ) first = p;

		else previous.setNext( p );
	}

	public void print(){

		Person tmp = first;

		System.out.print( "List content = " );

		while( tmp != null ){

			System.out.print( tmp.print() + ", " );


			tmp = tmp.getNext();
		}
	}


	public static void main(String[] args) {

		PersonList list = new PersonList();


		list.addPerson( "dio1" );

		list.addPerson( "dio2" );

		list.addPerson( "dio3" );


		list.print();
	}
}
