/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
public class Stack {
    private int[] elements;
    private int top;
    private int capacity;
    
    //constructor
    public Stack(int size){
        capacity = size;
        elements = new int[capacity];
        top = -1;
    }
    
    // Method to add an element to the stack
    public void push(int item){
        if(top==capacity-1){
            System.out.println("Stack is Full. You can't Push Element.");
            return;
        }
        elements[++top] = item;
    }
    
    // Method to remove and return the top element from the stack
    public int pop(){
        if(top==-1){
            System.out.println("Stack is Empty. You can't Pop Element.");
        return -1;
        }
        return elements[top--];
    }
    
    //use to view the top element
    public int peek(){
        if(top==-1){
            System.out.println("Stack is Empty. No peek Element.");
        return -1;
        }
        return elements[top];
    }
    
    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }
    
    // Method to display the elements in the stack
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return;
        }

        System.out.println("Stack elements:");
        for (int i = top; i >= 0; i--) {
            System.out.println(elements[i]);
        }
    }
    
}

class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(5); // Stack with size 5

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.display();

        System.out.println("Peek: " + stack.peek());

        System.out.println("Pop: " + stack.pop());
        stack.display();

        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        
        stack.push(60);
        stack.display();
        
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        stack.display();
        
        System.out.println("Pop: " + stack.pop());
        stack.pop();
    }
}
