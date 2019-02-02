package datastructures.queue;
//First in first out
//implemented using Linked list
public class Queue {
	private class Node{
		private int data;
		private Node next;
		private Node(int data) {
			this.data=data;
		}
	}

	/*
	 * Two pointers are required to implement Queue as adding happens on tail and
	 * removing happens on head. Initially head and tail will be same but when add
	 * elements to tail. we will remove from head making it FIFO implementation
	 */	
	private Node head;
	private Node tail;
	
	public void add(int data) {
		Node newNode = new Node(data);
		if(tail != null) {
			tail.next=newNode;
		}
		tail = newNode;
		if(head==null) {
			head = tail;
		}
	}
	
	public int remove() {
		//Check what happens if head is null
		int data = head.data;
		head = head.next;
		
		if(head==null) {
			tail=null;
		}
		return data;
	}
	
	//Returns first element of queue without removing
	public int peek() {
		return head.data;
	}
	
	public boolean isEmpty(){
		return (head == null);
	}

}
