package datastructures.linkedlist;


public class LinkedList {
	//No random access
	//No fixed capacity
	
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
	//repeatedly update head-O(1) killer feature
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
	
	//adding another node to the tail - O(n)
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
	
	//Deleting a node from a list
	public void deleteValue(int data) {
		if(head != null) {
			//if head is being deleted, then make next element of head as new head
			if(head.data == data) {
				head = head.next;
				return;
			}
			//Loop through the list
			Node current = head;
			while(current.next != null) {
				//check if next elements data is the one that needs to be deleted.
				//then point current next to next of current next which essentially deletes 
				//the node from list
				if(current.next.data == data) {
					current.next = current.next.next;
					return;
				}
				current = current.next;
			}
			
		}
		
	}
}
