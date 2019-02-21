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
	
	public void delete(int key) {
		root = delete(root, key);
	}

	private Node delete(Node node, int key) {
		if(node == null) {
			return null;
		}
		//Found element to be deleted
		if(key == node.key) {
			//Doesn't have children, directly made the node as null
			if(node.left == null && node.right == null) {
				node = null;
			}
			//If 
			else if(node.left == null && node.right != null) {
				node = node.right;
			}
			else if(node.left != null && node.right == null) {
				node = node.left;
			}
			else if(node.left != null && node.right != null) {
				Node minNode = min(node.right);
				node.key = minNode.key;
				node.value = minNode.value;
				
				node = delete(minNode.right,key);
			}
			
		}
		else if(key < node.key) {
			//GO look for in left sub tree recursively
			node = delete(node.left, key);
		}
		else if(key > node.key) {
			//GO look for in right sub tree recursively
			node = delete(node.right, key);
		}
		return node;
	}

	private Node findMinRight(Node node) {
		return node.left == null?node:findMinRight(node.left);
	}
	
/*	//Below are three Depth First traversal implementation
 * Remember left always comes before right
 * and Root corresponds to name of traversal as In order - Root in between
 * Pre - pre left , Post order post left and right
	1. In Order Traversal - left node, root, right node
	2. Pre Order Traversal - Root, Left Node, Right Node
	3. Post Order Traversal - Left Node, Right Node, Root*/
	
	
	public void printInOrderTraversal() {
		printInOrderTraversal(root);
	}

	private void printInOrderTraversal(Node node) {
		if(node != null) {
			printInOrderTraversal(node.left);
			System.out.println(node.key);
			printInOrderTraversal(node.right);
		}
	}
	
	public void printPreOrderTraversal() {
		printPreOrderTraversal(root);
	}

	private void printPreOrderTraversal(Node node) {
		if(node != null) {
			System.out.println(node.key);
			printInOrderTraversal(node.left);
			printInOrderTraversal(node.right);
		}
	}
	
	public void printPostOrderTraversal() {
		printPostOrderTraversal(root);
	}

	private void printPostOrderTraversal(Node node) {
		if(node != null) {
			printInOrderTraversal(node.left);
			printInOrderTraversal(node.right);
			System.out.println(node.key);
		}
	}
}
