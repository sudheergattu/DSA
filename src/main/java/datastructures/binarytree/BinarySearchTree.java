package datastructures.binarytree;

public class BinarySearchTree {
	
	private Node root;
	
	private class Node{
		private int key;
		private String value;
		private Node left;
		private Node right;
		Node(int key, String value){
			this.key=key;
			this.value=value;
		}
		
	}
	
	public void insert(int key, String value) {
		root = insertItem(root, key, value);
	}
	
	private Node insertItem(Node node, int key, String value) {
		//Node newNode = new Node(key, value);
		if(node == null) {
			//node = newNode;
			node = new Node(key, value);
			return node;
		}
		
		if(key < node.key) {
			node.left = insertItem(node.left, key, value);
		}
		else if( key > node.key) {
			node.right = insertItem(node.right, key, value);
		}
		
		return node;
	}
	
	public String find(int key) {
		Node node = find(root,key);
		return node == null ? null: node.value;
	}

	private Node find(Node node, int key) {
		if(node == null || node.key == key) {
			return node;
		}
		else if(key < node.key) {
			return find(node.left, key);
		}
		else if(key > node.key) {
			return find(node.right, key);
		}
		
		return null;
	}


}
