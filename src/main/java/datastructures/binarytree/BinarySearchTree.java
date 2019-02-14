package datastructures.binarytree;

//All keys must be unique(no duplicates)
//Left<root<right
public class BinarySearchTree {

	private Node root;

	private class Node {
		private int key;
		private String value;
		private Node left;
		private Node right;

		Node(int key, String value) {
			this.key = key;
			this.value = value;
		}

	}
	
	//We are inserting a node(key,value)
	public void insert(int key, String value) {
		//we always insert at root
		root = insertItem(root, key, value);
	}

	private Node insertItem(Node node, int key, String value) {
		// Node newNode = new Node(key, value);
		if (node == null) {
			// node = newNode;
			node = new Node(key, value);
			return node;
		}

		if (key < node.key) {
			node.left = insertItem(node.left, key, value);
		} else if (key > node.key) {
			node.right = insertItem(node.right, key, value);
		}

		return node;
	}

	// From outside we are looking for a key
	public String find(int key) {
		// In tree, we always start at root
		Node node = find(root, key);
		return node == null ? null : node.value;
	}

	// O(log n) runtime characteristic as we essentially split the search area by
	// half each time
	private Node find(Node node, int key) {
		if (node == null || node.key == key) {
			return node;
		} else if (key < node.key) {
			// recursive calls, remember binary tree is made up of smaller binary trees
			return find(node.left, key);
		} else if (key > node.key) {
			return find(node.right, key);
		}

		return null;
	}

	public Node min() {
		return min(root);
	}

	private Node min(Node node) {
		if(node.left == null) {
			return node;
		}
		else {
			return min(node.left);
		}
		
	}
}
