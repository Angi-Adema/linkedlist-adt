package linkedlistADT;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomLinkedList {
	
	// Reference to the first node in the LinkedList
	// When list is empty, head is set to null by default
    private Node head;

    // Insert method to create a new node at the end of the list
    public void insert(int data) {
    	
    	// Create a new node object to store integer data
    	Node newNode = new Node(data);
    	
    	// Check if variable head is equal to null. Set head to reference
    	// new node, making it the first node in the list
    	if (head == null) {
    		head = newNode;
    	} else {
    		
    		// Starting from the head node
    		Node current = head;
    		
    		// Loop through the nodes in the list to get to the last node
    		while (current.next != null) {
    			current = current.next;
    		}
    		
    		// Link last node to the new node being added to the list
    		current.next = newNode;
    	}
    	
    }
    
    // REFACTORED to handle edge cases such as duplicate values or removing from empty list
    // Delete method to remove the first occurrence of a node
    public void delete(int data) {
    	
    	// ADDED - delete duplicate nodes within the list
    	while (head != null && head.data == data) {
    		head = head.next;
    	}
    	
    	// Check if list is empty, return out if it is
    	if (head == null) {
    		return;
    	}
    	
    	// Starting from the head node
    	Node current = head;
    	
    	// REFACTORED - Loop through the linked list and skip the next node if it matches data to remove
    	while (current.next != null) {
    		if (current.next.data == data) {
    			current.next = current.next.next;
    		} else {
    			current = current.next;
    		}
    	}
    }

    // Iterator method
    public Iterator<Integer> iterator() {
        return new LinkedListIterator();
    }

    // Node inner class where data is equal to integer value and next node
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private class LinkedListIterator implements Iterator<Integer> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int data = current.data;
            current = current.next;
            return data;
        }
    }
}
