package datastructures.hashtable;

public class HashTable {
	
	private int INTIAL_SIZE = 16;
	private HashEntry[] data; //linkedlist like structure
	//is it possible to have a head element of linked list, there by avoiding looping through linked list elements while putting???
	
	private class HashEntry{
		String key;
		String value;
		HashEntry next;
		HashEntry(String key, String value){
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}
	
	HashTable(){
		data = new HashEntry[INTIAL_SIZE];
	}
	
	public void put (String key, String value) {
		int index = getIndex(key);
		HashEntry entry = new HashEntry(key, value);
		if(data[index] == null) {
			data[index] = entry;
		}
		else {
			HashEntry entries = data[index];
			//adding new entry at end of the list, can it be improved further to be able to add at start of list itself????
			while(entries.next != null) {
				entries = entries.next;
			}
			entries.next = entry;
			
		}
		
	}
	
	private int getIndex(String key) {
		int hashcode = key.hashCode();
		//convert hash to index, we are using modulus reporter to make sure index is one of indexes of array we defined
		//int index = hashcode % INTIAL_SIZE;  hashcode could be a negative, to make it positive using & operator 
		int index = (hashcode & 0xffffffff) % INTIAL_SIZE; 
		
		return index;
	}

	public String get(String key) {
		int index = getIndex(key);
		HashEntry entries = data[index];
		if (entries != null) {
			while (!entries.key.equals(key)) {
				entries = entries.next;
			}
			//Does a check required here or can it be assumed as we got a index, then key is part of linked list
			return entries.value;
		}
		
		return null;
		
	}

}
