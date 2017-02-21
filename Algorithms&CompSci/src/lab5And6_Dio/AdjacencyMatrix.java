/**
 * 
 */
package lab5And6_Dio;

/**
 * @author dathanas
 *
 */
public class AdjacencyMatrix {

	//Attributes.
	private boolean[][] graph;

	//Constructor.
	AdjacencyMatrix( int size ){

		graph = new boolean[ size ][ size ];
	}


	//Getters.
	boolean[][] getGraph(){

		return graph;
	}


	//Methods.
	void addEdge( int node, int neighbor ){

		graph[ node ][ neighbor ] = true;
		graph[ neighbor ][ node ] = true;
	}

	void print(){

		for( int i = 0; i < graph.length; ++i ){

			System.out.print( i + ": " );

			for( int j = 0; j < graph[ 0 ].length; ++j ){

				if( graph[ i ][ j ] ) System.out.print( "1 " );

				else System.out.print( "0 " );
			}
		
			System.out.println();
		}
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		AdjacencyMatrix obj = new AdjacencyMatrix( 5 );

		obj.addEdge( 0, 1 );
		obj.addEdge( 0, 4 );

		obj.addEdge( 1, 2 );
		obj.addEdge( 1, 3 );
		obj.addEdge( 1, 4 );

		obj.addEdge( 2, 3 );
	
		obj.addEdge( 3, 4 );

		obj.print();
	}
}
