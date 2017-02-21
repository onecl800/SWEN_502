package lab5And6;

import java.util.ArrayList;
import java.util.Stack;

/*
 * 
 * Claire O'Neill
 * 
 */

public class DepthFirstSearch {
	
	
	public void traverse(int sourceNode, AdjacencyLists obj) {
		
		//array of booleans to keep track of which nodes have been visited
		boolean[] visitedNodes = new boolean [obj.getGraph().length];		
					
		//stack of nodes to check
		Stack<Integer> stack = new Stack<Integer>();
				
		//add source node to array, update boolean to true
		stack.push(sourceNode);
					
		//while loop stops when nothing new has been added to the stack
		while (!stack.isEmpty()) {    
			
			//remove current node to stack
			int currentNode = stack.pop();
			
			//if current node has already been visited continue to the next node in the list
			if (visitedNodes[currentNode] ) continue;
			
			//update visited status of current node
			visitedNodes[currentNode] = true;
			
			//print out current node
			System.out.println(currentNode);	
			
			
			ArrayList<Integer>[] graph = obj.getGraph();
			
			//get neighbours of current node and add to list if not visited
			ArrayList<Integer> neighbours = graph[currentNode];
			
			for (int i = 0; i  < neighbours.size(); i++) {
				if (!visitedNodes[neighbours.get(i)]) {
					stack.push(neighbours.get(i));
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
		
		//obj.print();
		
		DepthFirstSearch dfs = new DepthFirstSearch();
		
		dfs.traverse(0, obj);


	}

}
