package lab5And6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath {
	
	//variables
	
	
	
		//constructor
		
		
		
		//methods
		public void shortestPath(int sourceNode, int targetNode, AdjacencyLists obj) {
			
			//array of booleans to keep track of which nodes have been visited
			Boolean[] visitedNodes = new Boolean [obj.getGraph().length];
			
			
			//array of predeseccor nodes
			
				
			//queue of nodes to check
			Queue<Integer> queue = new LinkedList<Integer>();
			
			//add source node to array, update boolean to true
			queue.add(sourceNode);
				
			
			
			while (!queue.isEmpty()) {    
			
				int currentNode = queue.remove();
				
				if (visitedNodes[currentNode] ) continue;
				
				visitedNodes[currentNode] = true;
				
				System.out.println(currentNode);
				
				
				
				ArrayList<Integer>[] graph = obj.getGraph();
				
				ArrayList<Integer> neighbours = graph[sourceNode];
				
				
				for (int i = 0; i < neighbours.size(); i++) {
					
					if (!visitedNodes[neighbours.get(i)]) {
						
						queue.add(neighbours.get(i));
					}
				}
				
			}
			
		}
	
	
	

	public static void main(String[] args) {
		
		AdjacencyLists obj = new AdjacencyLists(5);
		
		obj.addEdge(0, 1);
		obj.addEdge(0, 4);
		
		obj.addEdge(1, 2);
		obj.addEdge(1, 3);
		obj.addEdge(1, 4);
	
		obj.addEdge(2, 3);
		obj.addEdge(2, 4);
	
		obj.addEdge(3, 4);
		
		obj.addEdge(4, 1);
		
		obj.print();
		
		
		ShortestPath sp = new ShortestPath();
		
		sp.shortestPath(0, 0, obj);
	}

}
