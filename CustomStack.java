import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CustomStack {

    private int maxSize;
    private Node head;

    public CustomStack() {
        maxSize = 0;
        head = null;
    }

    // Push nodes to top of stack.
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        maxSize++;
    }

    // Pop nodes at top of stack.
    public int pop() throws CustomDataStructureException { 
        if (maxSize == 0) {
            throw new CustomDataStructureException(); // custom exception.
        }

        Node currentNode = head;
        head = head.next;
        maxSize--;
        return currentNode.data;
    }

    // Display nodes of the stack.
    public void display() {
        Node currentNode = head;

        System.out.println("\nStack: ");
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }

    // Read contents of data.txt and push each line onto stack.
    public void read() throws FileNotFoundException {
        File sampleData = new File("data.txt");
        Scanner fileReader = new Scanner(sampleData);

        while (fileReader.hasNextLine()) {
            push(Integer.valueOf(fileReader.nextLine()));
        }
        fileReader.close();
    }

    // Write contents of stack into data.txt in new lines.
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
