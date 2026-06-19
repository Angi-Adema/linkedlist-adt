package linkedlistADT;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class Main {
	
    // Create method to read in text file and call CustomLinkedList to process data output
    public static void readTextFile(String fileName, CustomLinkedList linkedList) {
    	
    	// Try with resources to close resources automatically and error handling for file access and content
    	// Use BufferedReader to read in the text file data
    	try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
    		
    		// Store read in text data
    		String text;
    		
    		// Check to see if there is still text to be read in, insert data to linked list and covert it to int from String
    		while((text = br.readLine()) != null) {
    			linkedList.insert(Integer.parseInt(text));
    		}
    	} catch (IOException e) {
    		
    		// Print error messages
    		System.out.println("Error reading the file, please try again!" + e.getMessage());
    		
    	} catch (NumberFormatException e) {
    		
    		// Print error messages
    		System.out.println("\nFile contains data that cannot convert to int. " + e.getMessage());
    	}
    }


	public static void main(String[] args) {
        CustomLinkedList linkedList = new CustomLinkedList();

        // Insert some elements
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        
        // Add an additional test value to test delete method
        linkedList.insert(8);
        
        // Print statement identifying the list prior to calling delete
        System.out.println("Insertion of integers to the linked list including test value of 8.");

        // Iterate and display elements
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        
        // Call delete method to delete the test item and reprint the linkedList
        linkedList.delete(8);
        System.out.println("\n\nList after test value 8 is removed:");
        
        iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        
        // Create a new linked list object to test text files
        CustomLinkedList testLinkedList = new CustomLinkedList();
        
        // Call readTextFile and read in the text file adding data to testLinkedList
        readTextFile("numbers2.txt", testLinkedList);
        
        // Text file print statement
        System.out.println("\n\nOutput of the text file:");
        
        // Create an iterator object for the text file iterator
        Iterator<Integer> textFileIterator = testLinkedList.iterator();
        
        // Loop through the text file and print the data
        while (textFileIterator.hasNext()) {
        	System.out.print(textFileIterator.next() + " ");
        }  
	}
}
