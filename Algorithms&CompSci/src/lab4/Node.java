package lab4;

public class Node {

	//variables
	private int id;
	private Node leftChild, rightChild;
	
	
	//getters and setters
	public int getId() {
		return id;
	}
	public void setId(int cId) {
		id = cId;
	}
	public Node getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(Node cLeft) {
		leftChild = cLeft;
	}
	public Node getRightChild() {
		return rightChild;
	}
	public void setRightChild(Node cRight) {
		rightChild = cRight;
	}
	
	
}
