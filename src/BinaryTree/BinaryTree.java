package BinaryTree;

public class BinaryTree {
	
	//int[] values = {10,7,13,9,11};
	int[] values = new int[10];
	Node root;
	boolean findme = false;
	
	private void randomArray() {
		for (int i = 0; i < values.length; i++) {
			values[i] = (int)(Math.random() * ((100 - 1) + 1)) + 1;
		}
	}
	
	public void buildTree() {
		
		randomArray();
		
		for(int value: values) {
			Node node = new Node(value);
			if(root == null) {
				root = node;
			} else {
				findNodeAndAdd(root, value);
			}
		}
	}
	
	private void findNodeAndAdd(Node node, int value) {
		if(value <= node.value && node.left == null) {
			node.left = new Node(value); 
		} else if(value > node.value && node.right == null) {
			node.right = new Node(value);
		} else if(value <= node.value && node.left != null) {
			findNodeAndAdd(node.left, value);
		} else if(value > node.value && node.right != null) {
			findNodeAndAdd(node.right, value);
		}
		
	}
	
	public void traverse() {
		traverseBinaryTree(root);
	}
	
	private void traverseBinaryTree(Node node) {

		if(node != null) {
			System.out.print(node.value + " ");
		}
		if(node.left != null) {
			traverseBinaryTree(node.left);
		}
		if(node.right != null) {
			traverseBinaryTree(node.right);
		}
	}
	
	private boolean findBinaryTree(Node node, int value) {
		if(node != null && node.value == value) {
			return true;
		}
		if(node.left != null) {
			return findBinaryTree(node.left, value);
		}
		if(node.right != null) {
			return findBinaryTree(node.right, value);
		}
		return false;
	}
	
	public void findValue(int value) {
		if(findBinaryTree(root, value) == true) {
			System.out.println("Yes : " + value);
		} else {
			System.out.println("Nope : " + value);
		}
	}
	
	
	private void ascTree(Node node) {
		
		if(node.left != null && node.left.visited == false) {
			ascTree(node.left);
		}
		System.out.print(node.value + " ");
		node.visited = true;
		if(node.right != null && node.right.visited == false) {
			ascTree(node.right);
		}
		
	}
	
	public void ascendingOrderTree() {
		ascTree(root);
	}
	
	private void dscTree(Node node) {
		
		if(node.right != null && node.right.visited == false) {
			dscTree(node.right);
		}
		System.out.print(node.value + " ");
		node.visited = true;
		if(node.left != null && node.left.visited == false) {
			dscTree(node.left);
		}
		
	}
	
	public void descendingOrderTree() {
		dscTree(root);
	}
	
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.buildTree();
		bt.traverse();
		System.out.println("");
		//int findval = 13;
		//bt.findValue(findval);
		bt.ascendingOrderTree();
		System.out.println("");
		//bt.descendingOrderTree();
		
	}

}
