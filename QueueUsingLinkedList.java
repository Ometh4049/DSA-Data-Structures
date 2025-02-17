// Queue implementation using Linked List (a FIFO queue using linked list.)
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {
    private Node front, rear;

    public Queue() {
        this.front = this.rear = null;
    }

    // Enqueue operation (Add element to the rear)
    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println(data + " added to queue.");
    }

    // Dequeue operation (Remove element from the front)
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue underflow! Cannot dequeue.");
            return -1;
        }
        int removedData = front.data;
        front = front.next;
        if (front == null) {
            rear = null; // Reset queue if empty
        }
        return removedData;
    }

    // Peek operation (Get front element)
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        return front.data;
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Display queue elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        Node temp = front;
        System.out.println("Queue elements:");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

// Main class to test the Queue
public class QueueUsingLinkedList {
    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.display();

        System.out.println("Front element is: " + queue.peek());

        System.out.println("Dequeued element: " + queue.dequeue());
        queue.display();
    }
}
