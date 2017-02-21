/*
 * Claire O'Neill
 * 
 */

package lab4;

public class BinarySearchTree {
	
	//variables
	private static Node root;
	
	
	//getters and setters
	public Node getRoot() {
		return root;
	}
	public void setRoot(Node cRoot) {
		root = cRoot;
	}
	
		
	//methods
	private Node createNode(int cId) {
		Node node = new Node();
		
		node.setId(cId);
		
		return node;
	}	
	
	
	private void insert(Node newNode, Node currentRoot) {
		
		if (root == null) {
			
			root = newNode;
			
			System.out.println( "\nRoot: " + newNode.getId());
		
		} else {
			
			if (currentRoot.getId() < newNode.getId()) {
		
				if (currentRoot.getRightChild() != null) {
					
					insert (newNode, currentRoot.getRightChild());
			
				} else {
					
					currentRoot.setRightChild(newNode);
				}
				
				System.out.println( "\nRight child: " + newNode.getId() + " of " + currentRoot.getId());
				
			} else {
				
				if (currentRoot.getLeftChild() != null) {
				
					insert (newNode, currentRoot.getLeftChild());
				
				} else {
					
					currentRoot.setLeftChild(newNode);
				}
				
				System.out.println( "\nLeft child: " + newNode.getId() + " of " + currentRoot.getId());
			}
		}
	}
	
	
	public void insert (int id) {
		Node node = createNode(id);
		
		insert (node, root);
	}
	
	
	
	//print binary search tree in ascending order
	public static void printInOrder(Node currentRoot) {
		
		//check that root is not null
		if (currentRoot != null) {
			//if currentRoot is not null, call printInOrder method recursively until root(leftChild) is null. This is when we've reached the smallest element in the tree
			printInOrder(currentRoot.getLeftChild());
			//then print out the id of the root where currentRoot.getLeftChild == null
			System.out.print(currentRoot.getId() + " ");
			//check the right child of the current root by calling inOrder method recursively. if no further nodes will print. 
			printInOrder(currentRoot.getRightChild());
		} 		
	}
	
	

	
	
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		
		tree.insert(8);
		tree.insert(11);
		tree.insert(9);
		tree.insert(2);
		tree.insert(15);
		tree.insert(7);
		tree.insert(1);

		
		System.out.println();
		tree.printInOrder(root);

		
	}

}
