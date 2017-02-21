/**
 * 
 */
package lab5And6_Dio;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author dathanas
 *
 */
public class BFS {

	public void traverse( int sourceNode, AdjacencyList obj ){

		boolean[] visited = new boolean[ obj.getGraph().length ];

		Queue<Integer> queue = new LinkedList<Integer>();

		queue.add( sourceNode );


		while( ! queue.isEmpty() ){

			int currentNode = queue.remove();

			if( visited[ currentNode ] ) continue;

			visited[ currentNode ] = true;

			System.out.println( currentNode );


			ArrayList<Integer>[] graph = obj.getGraph();

			ArrayList<Integer> neighbors = graph[ currentNode ];

			for( int i = 0; i < neighbors.size(); ++i ){

				if( ! visited[ neighbors.get( i ) ] && ! queue.contains( neighbors.get( i ) ) ) queue.add( neighbors.get( i ) );
			}

			//System.out.println( queue.toString() );
		}
	}
	
	public static void main(String[] args) {

		AdjacencyList obj = new AdjacencyList( 6 );

		obj.addEdge( 0, 1 );
		obj.addEdge( 0, 2 );

		obj.addEdge( 2, 3 );
		obj.addEdge( 2, 4 );

		obj.addEdge( 3, 5 );

		obj.addEdge( 4, 5 );

		//obj.print();


		BFS bfs = new BFS();

		bfs.traverse( 0 , obj );
	}

}
