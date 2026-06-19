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
    
    // Delete method to remove the first occurrence of a node
    public void delete(int data) {
    	
    	// Starting from the head node
    	Node current = head;
    	
    	// Check if the head node is equal to null, return out if it is
    	if (head == null) {
    		return;
    	}
    	
    	// Check if the head node is equal to the data value passed in and if
    	// it is, make the next node the head node to remove the node from the list and return out
    	if (head.data == data) {
    		head = head.next;
    		return;
    	}
    	
    	// Loop through the linked list until the node before the data passed in is found
    	// or the end of the list is located
    	while (current.next != null && current.next.data != data) {
    		
    		// Move to the next node
    		current = current.next;
    	}
    	
    	// If the loop reaches a node that is equal to the passed in data, we skip over
    	// this node eliminating it from the list
    	if (current.next != null) {
    		current.next = current.next.next;
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
