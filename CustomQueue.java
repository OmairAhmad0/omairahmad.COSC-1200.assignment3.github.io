import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CustomQueue {
    private int maxSize;
    private Node head, tail;

    public CustomQueue() {
        head = null;
        tail = null;
        maxSize = 0;
    }

    // Insert an element in the queue
    void enQueue(int data) {
        Node newNode = new Node(data);

        if (maxSize == 0) { // if queue is empty, assign head to the new node.
            head = newNode;
        } else { // else assign tail to the new node.
            tail.next = newNode; 
        }
        tail = newNode;
        maxSize++;
    }

    // Remove the head element from the Queue
    int deQueue() {
        head = head.next;
        maxSize--;

        if (maxSize == 0) {
            tail = null;
        }

        return head.data;
    }

    // Display the elements of the Queue
    void display() {
        Node currentNode = head;

        if (maxSize == 0) {
            System.out.println("The queue is empty.");
        } else {
            System.out.println("\nQueue: ");
            while (currentNode != null) {
                System.out.println(currentNode.data);
                currentNode = currentNode.next;
            }
        }
    }

    // Read data.txt and append lines to the queue.
    public void read() throws FileNotFoundException {
        File sampleData = new File("data.txt");
        Scanner fileReader = new Scanner(sampleData);

        while (fileReader.hasNextLine()) {
            enQueue(Integer.valueOf(fileReader.nextLine()));
        }
        fileReader.close();
    }

    // Write contents of queue into new lines of data.txt
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
