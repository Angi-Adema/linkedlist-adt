package linkedlistADT;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomLinkedList {
    private Node head;

    // Other methods...

    public Iterator<Integer> iterator() {
        return new LinkedListIterator();
    }

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

    // Other methods...

}
