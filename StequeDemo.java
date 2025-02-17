// Node class for the Steque
class StequeNode {
    int data;
    StequeNode next;

    public StequeNode(int data) {
        this.data = data;
        this.next = null;
    }
}

// Steque class (Stack + Queue)
class Steque {
    private StequeNode front, rear;

    public Steque() {
        this.front = this.rear = null;
    }

    // Push (Insert at the front - Stack behavior)
    public void push(int data) {
        StequeNode newNode = new StequeNode(data);
        if (front == null) {
            front = rear = newNode;
        } else {
            newNode.next = front;
            front = newNode;
        }
        System.out.println(data + " pushed to Steque.");
    }

    // Enqueue (Insert at the end - Queue behavior)
    public void enqueue(int data) {
        StequeNode newNode = new StequeNode(data);
        if (front == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println(data + " enqueued to Steque.");
    }

    // Pop (Remove from the front - Stack behavior)
    public int pop() {
        if (front == null) {
            System.out.println("Steque is empty.");
            return -1;
        }
        int value = front.data;
        front = front.next;
        if (front == null)
            rear = null; // If list becomes empty
        System.out.println(value + " popped from Steque.");
        return value;
    }

    // Display Steque
    public void display() {
        if (front == null) {
            System.out.println("Steque is empty.");
            return;
        }
        StequeNode temp = front;
        System.out.print("Steque: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

// Main class to test the Steque
public class StequeDemo {
    public static void main(String[] args) {
        Steque steque = new Steque();

        steque.push(10);
        steque.push(20);
        steque.enqueue(30);
        steque.enqueue(40);

        steque.display();

        steque.pop();
        steque.display();
    }
}
