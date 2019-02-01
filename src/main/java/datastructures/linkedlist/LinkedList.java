package datastructures.linkedlist;

public class LinkedList {
	
	private Node head;
	//One way to implement size, incremtent size when element is added to list
	//private int size;
	
	private static class Node{
		int data;
		Node next;
		public Node(int data) {
			this.data=data;
		}
		
	}
	
	public void addFront(int data) {
		Node newNode = new Node(data);
		
		if(this.head == null) {
			this.head = newNode;
			//what happens without below return
			return;
		}
		//point newNode next to head
		newNode.next = head;
		//point head to new node
		head = newNode;
		//size++;
	}
	
	public int getFirst() {
		//if(head == null) 
			//throw exception
		return head.data;
	}
	
	public int getLast() {
		if(head == null) 
			throw new IllegalStateException("Empty List!!!");
		
		Node current = head;
		
		while(current.next != null) {
			current = current.next;
		}
		//at the tail
		return current.data;
	}
	
	//adding another node to the tail
	public void addBack(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			return;
		}
		
		Node current = head;
		while(current.next != null) {
			current = current.next;
		}
		//we are at tail, add the new node to current tail.
		current.next = newNode;
		//size++;
	}
	
	//Second way to determine - Brute force approach O(n)
	public int size() {
		int size = 0;
		if(head != null) {
			size++;
			Node current = head;
			while(current.next != null) {
				size++;
				current = current.next;
			}
		}
		return size;
	}
			
	public void clear() {
		head = null;
	}
}
