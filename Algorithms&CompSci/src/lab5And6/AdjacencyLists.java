package lab5And6;

import java.util.ArrayList;

public class AdjacencyLists {

	//variables
	private ArrayList<Integer>[] graph;
	
	//constructor
	//size = number of nodes in the graph
	public AdjacencyLists(int size) {
		graph = new ArrayList[size];
	}
	
	//getters and setters
	public ArrayList<Integer>[] getGraph() {
		return graph;
	}
	
	
	//methods
	public void addEdgeInternally(int node, int neighbour) {
		ArrayList<Integer> neighbours = graph [node];
		
		if (neighbours == null) {
			//create new arraylist for holding neighbours
			neighbours = new ArrayList<Integer>();
		}
		//add neighbour to arraylist of neighbours
		neighbours.add(neighbour);
		
		graph[node] = neighbours;
	}
	
	

	public void addEdge(int node, int neighbour) {
		addEdgeInternally(node, neighbour);
		//use above line twice if list is bi-directional, once if only one-directional
		//addEdgeInternally(neighbour, node);
	}
	
	
	public void print() {
		
		for (int i = 0; i < graph.length; i++) {
			
			ArrayList<Integer> neighbours = graph [i];
			
			System.out.print(i + ": ");
			
			for (int j = 0; j < neighbours.size(); j++) {
				System.out.print(neighbours.get(j) + " ");
			}	
			System.out.println();
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
	}


}
