package datastructures.linkedlist;

public class LinkedList {
	
	private Node head;
	
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
		
		while(current != null) {
			current = current.next;
		}
		
		return current.data;
	}
			
}
