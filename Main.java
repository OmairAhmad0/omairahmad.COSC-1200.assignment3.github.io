import java.io.FileWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        CustomLinkedList customLinkedList = new CustomLinkedList();
        CustomQueue customQueue = new CustomQueue();
        CustomStack customStack = new CustomStack();

        FileWriter fileWriter = new FileWriter("data.txt");
        fileWriter.write("1\n2\n3\n4\n5\n6");
        fileWriter.close();

        customLinkedList.read();
        customLinkedList.display();
        customLinkedList.delete(0);
        customLinkedList.delete(1);
        customLinkedList.delete(2);
        customLinkedList.insert(8);
        customLinkedList.insert(10);
        customLinkedList.write();

        customQueue.read();
        customQueue.display();
        customQueue.deQueue();
        customQueue.deQueue();
        customQueue.deQueue();
        customQueue.write();

        customStack.read();
        customStack.display();
        customStack.pop();
        customStack.pop();
        customStack.push(9);
        customStack.push(7);
        customStack.push(5);
        customStack.push(3);
        customStack.push(1);
        customStack.write();

        customStack.pop();
        customStack.pop();
        customStack.pop();
        customStack.pop();
        customStack.pop();
        customStack.pop();
    }
}
