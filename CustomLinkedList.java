import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CustomLinkedList {
    private Node head;

    public CustomLinkedList() {
    }

    // Insert Node at head of linked list.
    public void insert(int data) {
        Node newNode = new Node(data);

        // If head is empty, change head to new node.
        if (this.head == null) {
            head = newNode;
        } else { // else assign node to last position of linked list.
            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
    }

    // Delete node at index.
    public void delete(int index) {
        Node currentNode = head;
        for (int i = 0; i < index - 1; i++) { // iterate through linked list until the index point.
            currentNode = currentNode.next; // resign nodes to the next nodes.
        }
        currentNode.next = currentNode.next.next; // resign next nodes to nodes further in the linked list.
    }

    // Display nodes of linked list.
    public void display() {
        Node currentNode = head;

        // If head is not empty.
        if (head != null) {
            System.out.println("\nLinked List: ");
            while (currentNode != null) { // until the current node is not empty.
                System.out.println(currentNode.data); 
                currentNode = currentNode.next; // resign current node to next node to iterate loop.
            }
        } else {
            System.out.println("Empty Linked List.");
        }
    }

    // Read from data.txt and insert each line into linked list.
    public void read() throws FileNotFoundException {
        File sampleData = new File("data.txt");
        Scanner fileReader = new Scanner(sampleData);

        while (fileReader.hasNextLine()) {
            insert(Integer.valueOf(fileReader.nextLine()));
        }
        fileReader.close();
    }

    // Write contents of linked list into new lines of data.txt.
    public void write() throws IOException {
        FileWriter fileWriter = new FileWriter("data.txt");
        if (head != null) {
            Node currentNode = head;
            while (currentNode != null) {
                fileWriter.write(currentNode.data + "\n");
                currentNode = currentNode.next;
            }
        }
        fileWriter.close();
    }
}
