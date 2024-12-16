/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Queue;

/**
 *
 * @author pooja
 */


class Queue {
    private int[] elements;
    private int front;
    private int rear;
    private int capacity;
    private int count;

    // Constructor is use to initialize the queue
    public Queue(int size) {
        capacity = size;
        elements = new int[capacity];
        front = 0;
        rear = -1;
        count = 0; // Tracks the number of elements in the queue
    }

    //add an element to the queue
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is Full! Cannot enqueue " + item);
            return;
        }
        rear = (rear + 1) % capacity; // Circular increment
        elements[rear] = item;
        count++;
    }

    // Method to remove and return the front element from the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty! Cannot dequeue.");
            return -1; 
        }
        int item = elements[front];
        front = (front + 1) % capacity; // Circular increment
        count--;
        return item;
    }

    //view the front element in the queue
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty! Cannot peek.");
            return -1; 
        }
        return elements[front];
    }

    //check if the queue is empty
    public boolean isEmpty() {
        return count == 0;
    }

    //check if the queue is full
    public boolean isFull() {
        return count == capacity;
    }

    //display the elements in the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }

        System.out.println("Queue elements:");
        for (int i = 0; i < count; i++) {
            int index = (front + i) % capacity;
            System.out.println(elements[index]);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue(5);

        queue.enqueue(100);
        queue.enqueue(200);
        queue.enqueue(300);
        queue.display();

        System.out.println("Peek: " + queue.peek());

        System.out.println("Dequeue: " + queue.dequeue());
        queue.display();

        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());
        queue.dequeue();
    }
}


