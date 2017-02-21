package lab5And6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
	

	public void traverse(int sourceNode, AdjacencyLists obj) {
		
		//array of booleans to keep track of which nodes have been visited
		boolean[] visitedNodes = new boolean [obj.getGraph().length];
		
			
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
			
			ArrayList<Integer> neighbours = graph[currentNode];
			
			
			for (int i = 0; i < neighbours.size(); i++) {
				
				if (!visitedNodes[neighbours.get(i)]) {
					
					queue.add(neighbours.get(i));
				}
			}
			
		}
		
	}
	
	//give each node a boolean, once visited add to list and change boolean to true. do not add any nodes with a true boolean to the list
	
	
	
	
	
	public static void main(String[] args) {
		
AdjacencyLists obj = new AdjacencyLists(5);
		
		obj.addEdge(0, 1);
		obj.addEdge(0, 2);
		
		obj.addEdge(1, 2);
		obj.addEdge(1, 3);

	
		obj.addEdge(2, 3);
		obj.addEdge(2, 4);
	
		obj.addEdge(3, 4);
		
		obj.addEdge(4, 1);
		
		//obj.print();
		
		BreadthFirstSearch bfs = new BreadthFirstSearch();
		
		bfs.traverse(0, obj);
	}

}
