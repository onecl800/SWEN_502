package lab5And6;

public class AdjacencyMatrix {
	
	//variables
	boolean[][] graph;
	
	//constructor
	//size = number of nodes in the graph
	public AdjacencyMatrix(int size) {
		graph = new boolean[size][size];
	}
	
	//getters and setters
	public boolean [][] getGraph() {
		return graph;
	}
	
	
	//methods
	public void addEdge(int node, int neighbour) {
		graph [node][neighbour] = true;
		graph [neighbour][node] = true;
	}
	
	
	public void print() {
		
		for (int i = 0; i < graph.length; i++) {
			System.out.print(i + ": ");
			for (int j = 0; j < graph[0].length; j++) {
				if (graph[i][j] == true) {
					System.out.print("1 ");
				} else {
					System.out.print("0 ");
				}
				
			}
			System.out.println();
		}
		
		
	}

	public static void main(String[] args) {
		
		AdjacencyMatrix obj = new AdjacencyMatrix(5);
		
		obj.addEdge(0, 1);
		obj.addEdge(0, 4);
		
		obj.addEdge(1, 0);
		obj.addEdge(1, 2);
		obj.addEdge(1, 3);
		obj.addEdge(1, 4);
		
		obj.addEdge(2, 1);
		obj.addEdge(2, 3);
		
		obj.addEdge(3, 1);
		obj.addEdge(3, 4);
		
		obj.addEdge(4, 0);
		obj.addEdge(4, 1);
		obj.addEdge(4, 3);
		
		obj.print();
	}

}
