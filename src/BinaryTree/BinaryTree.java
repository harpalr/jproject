package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
	
	//int[] values = {10,7,13,9,11,22};
	int[] values = {11,7,13,9,22};
	//int[] values = new int[6];
	Node root;
	boolean findme = false;
	Queue<Node> q = new LinkedList<>();
	
	
	private void randomArray() {
		for (int i = 0; i < values.length; i++) {
			values[i] = (int)(Math.random() * ((10 - 1) + 1)) + 1;
		}
	}
	
	public void buildTree() {
		
		//randomArray();
		
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
	
	/*
	 * Breadth First Traversal
	 */
	public void BFStraversal(Node root) {
		Node focusNode = root;
		q.add(focusNode);
		
		while(q.isEmpty() == false) {
			
			focusNode = q.poll();
			System.out.print(focusNode.value + " ");
			if(focusNode.left != null) {
				q.add(focusNode.left);
			}
			if(focusNode.right != null) {
				q.add(focusNode.right);
			}
		}
		
	}
	
	/*
	 * Depth First Traversal
	 * InOrder Traversal
	 * Left -> Root -> Right
	 */
	public void InOrderTraversal(Node root) {
		if(root.left != null) InOrderTraversal(root.left);
		System.out.print(root.value + " ");
		if(root.right != null) InOrderTraversal(root.right);
	}
	
	/*
	 * Depth First Traversal
	 * PostOrder Traversal
	 * Left -> Right -> Root
	 */
	public void PostOrderTraversal(Node root) {
		if(root.left != null) PostOrderTraversal(root.left);
		if(root.right != null) PostOrderTraversal(root.right);
		System.out.print(root.value + " ");
	}
	
	/*
	 * Depth First Traversal
	 * PreOrder Traversal
	 * Root-> Left -> Right 
	 */
	public void PreOrderTraversal(Node root) {
		System.out.print(root.value + " ");
		if(root.left != null) PreOrderTraversal(root.left);
		if(root.right != null) PreOrderTraversal(root.right);
	}
	
	public boolean findValue(int value) {
            
            Node focusNode = root;
            
            while(focusNode != null){
                
                if(focusNode.value == value){
                    return true;
                } else if(value < focusNode.value){
                    focusNode = focusNode.left;
                } else {
                    focusNode = focusNode.right;
                }                
            }
		
            return false;
	}
	
	public Node[] findValueWithNode(int value) {
            Node[] nodes = new Node[2];
            nodes[0] = null;
            nodes[1] = null;
             
            Node focusNode = root;
            Node parent = root;
            while(focusNode != null){
                if(focusNode.value == value){
                    nodes[0] = parent;
                    nodes[1] = focusNode;
                    return nodes;
                } else if(value < focusNode.value){
                    parent = focusNode;
                    focusNode = focusNode.left;
                } else {
                    parent = focusNode;
                    focusNode = focusNode.right;
                }                
            }
            return nodes;
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
	
	public void remove(int value) {
            Node[] nodes = new Node[2];
            nodes = findValueWithNode(value);
            Node DeleteNodeParent = nodes[0];
            Node DeleteNode = nodes[1];
            
            if(isLeafNode(DeleteNode)){
                // delete leaf node and set parent reference to null
                if(DeleteNodeParent.left == DeleteNode)
                    DeleteNodeParent.left = null;
                else
                    DeleteNodeParent.right = null;
                DeleteNode = null;
                return;
            }
            
            if(hasOneChild(DeleteNode)){
                //replace it with the child
            }
            
            if(hasBothChild(DeleteNode)){
                
            }
		
	}
        
        private Node[] findMinRight(Node root){
            Node[] nodes = new Node[2];
            Node parent = root;
            Node focusNode = root.right;
            while(focusNode.left != null){
                parent = focusNode;
                focusNode = focusNode.left;
            }
            nodes[0] = parent;
            nodes[1] = focusNode;
            return nodes;
        }
        
        private Node[] findMaxLeft(Node root){
            Node[] nodes = new Node[2];
            Node focusNode = root.left;
            Node parent = root;
            
            while(focusNode.right != null){
                parent = focusNode;
                focusNode = focusNode.right;
            }
            nodes[0] = parent;
            nodes[1] = focusNode;
            return nodes;
        }
        
        private boolean hasBothChild(Node node){
            if(node.left != null && node.right != null) return true;
            return false;
        }
       
        private boolean hasOneChild(Node node){
            if(node.left == null && node.right != null) return true;
            if(node.left != null && node.right == null) return true;
            return false;

        }
        
        private boolean isLeafNode(Node node){
            if(node.left == null && node.right == null) return true;
            return false;
        }
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.buildTree();
		//bt.BFStraversal(bt.root);
		//System.out.println("");
		bt.InOrderTraversal(bt.root);
		System.out.println("");
		//bt.remove(10);
		bt.remove(22);
		bt.InOrderTraversal(bt.root);
		System.out.println("");
		
		//bt.PostOrderTraversal(bt.root);
		//System.out.println("");
		//bt.PreOrderTraversal(bt.root);
		//System.out.println("");
		//bt.traverse();
		//System.out.println("");
		//int findval = 5;
		//if(bt.findValue(findval)) System.out.println(findval + " Found");
                //else  System.out.println(findval + " NOT");
		//bt.ascendingOrderTree();
		//System.out.println("");
		//bt.descendingOrderTree();
		
	}

}
