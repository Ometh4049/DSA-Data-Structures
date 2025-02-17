// Circular Queue implementation using an array
class CircularQueue {
    private int[] queue;
    private int front, rear, size, capacity;

    // Constructor
    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = this.size = 0;
        this.rear = capacity - 1; // Set rear to last index initially
    }

    // Check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Enqueue operation
    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + data);
            return;
        }
        rear = (rear + 1) % capacity; // Move rear circularly
        queue[rear] = data;
        size++;
        System.out.println(data + " enqueued.");
    }

    // Dequeue operation
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }
        int data = queue[front];
        front = (front + 1) % capacity; // Move front circularly
        size--;
        System.out.println(data + " dequeued.");
        return data;
    }

    // Get front element
    public int getFront() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        return queue[front];
    }

    // Get rear element
    public int getRear() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        return queue[rear];
    }

    // Display queue elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Circular Queue: ");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % capacity] + " ");
        }
        System.out.println();
    }
}

// Main class to test Circular Queue
public class CircularQueueDemo {
    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5); // Capacity 5

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60); // Queue full (Should not be inserted)

        queue.display();

        queue.dequeue();
        queue.dequeue();

        queue.display();

        queue.enqueue(60);
        queue.enqueue(70);

        queue.display();
        System.out.println("Front: " + queue.getFront());
        System.out.println("Rear: " + queue.getRear());
    }
}
