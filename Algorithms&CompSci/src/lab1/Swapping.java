package lab1;

/**
 * 
 * @author Dionysis Athanasopoulos <dionysiscsuoi@gmail.com>
 *
 */
public class Swapping {

	public static void main( String[] args ){
		
		Swapping s = new Swapping();
		
		int x = 10, y = 15;


		s.swap( x, y );

		
	}

	private void swap( int x, int y ){

		int temp = x;

		x = y;

		y = temp;
		
		System.out.println( "x = " + x  + ", y = " + y );
	}
} 

