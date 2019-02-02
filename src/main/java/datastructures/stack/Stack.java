package datastructures.stack;

import java.util.EmptyStackException;

/*//Stack is Last In First Out(LIFO)
//implemented using Linked List
*/
public class Stack {
	
	private class Node{
		private int data;
		private Node next;
		private Node(int data) {
			this.data=data;
		}
	}
	
	private Node head;
	//This is same as adding node to the front of linked list
	//1.Create new node
	//2. point next of new node to head
	//3. Make new node as head
	public void push(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			return;
		}
		newNode.next = head;
		head = newNode;
	}
	
	public int pop() {
		if(head == null) {
			throw new EmptyStackException();
		}
		int data =head.data;
		head = head.next;
		return data;
		
	}
	//Returns last element of Stack without popping
	public int peek() {
		return head.data;
	}
	
	public boolean isEmpty(){
		return (head == null);
	}

}
