package lab2;

/**
 * 
 * @author Dionysis Athanasopoulos <dionysiscsuoi@gmail.com>
 *
 */
public class ConcatTwoArrays {

	public static void main( String[] args ){

		double[] inA = new double[]{ 1, 5, 10, 15, 20 };

		double[] inB = new double[]{ 3, 8, 13, 18, 23 };


		double[] outC = concat( inA, inB );

		for( int i = 0; i < outC.length; i++ ) System.out.println( "outC[ " + i + " ] = " + outC[ i ] );

	}

	public static double[] concat( double[] inA, double[] inB ){

		if( inA == null || inB == null ) return null;


		double[] outC = new double[ inA.length + inB.length ];


		int a = 0, b = 0, c = 0;

		while ( c < inA.length + inB.length ){

			if( b == inB.length || ( a < inA.length && inA[ a ] < inB[ b ] ) ){

				outC[ c ] = inA[ a ];

				++a;
			}

			else{

				outC[ c ] = inB[ b ];

				++b;
			}


			++c;
		}


		return outC;
	}
}
