package linkedlistADT;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class Main {
	
    // Create method to read in text file and call CustomLinkedList to process data output
    public void readTextFile(String fileName, CustomLinkedList linkedList) {
    	
    	// Try with resources to close resources automatically and error handling for file access
    	// Use BufferedReader to read in the text file data
    	try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
    		
    		// Store read in text data
    		String text;
    		
    		// Check to see if there is still text to be read in and covert it to int from String
    		while((text = br.readLine()) != null) {
    			linkedList.insert(Integer.parseInt(text));
    		}
    	} catch (IOException e) {
    		
    		// Print error messages
    		System.out.println("Error reading the file, please try again!" + e.getMessage());
    	}
    }


	public static void main(String[] args) {
        CustomLinkedList linkedList = new CustomLinkedList();

        // Insert some elements
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);

        // Iterate and display elements
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        
	}
}
