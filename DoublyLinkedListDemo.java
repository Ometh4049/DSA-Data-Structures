// Node class for Doubly Linked List
class DNode {
    int data;
    DNode prev, next;

    public DNode(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}

// Doubly Linked List class
class DoublyLinkedList {
    private DNode head, tail;

    public DoublyLinkedList() {
        this.head = this.tail = null;
    }

    // Insert at the end
    public void insertAtEnd(int data) {
        DNode newNode = new DNode(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println(data + " inserted at the end.");
    }

    // Insert at the beginning
    public void insertAtBeginning(int data) {
        DNode newNode = new DNode(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println(data + " inserted at the beginning.");
    }

    // Delete by value
    public void deleteByValue(int data) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.data == data) { // Delete head
            head = head.next;
            if (head != null)
                head.prev = null;
            else
                tail = null; // If list is now empty
            System.out.println(data + " deleted.");
            return;
        }
        DNode temp = head;
        while (temp != null && temp.data != data) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println(data + " not found.");
            return;
        }
        if (temp.next != null)
            temp.next.prev = temp.prev;
        if (temp.prev != null)
            temp.prev.next = temp.next;
        if (temp == tail)
            tail = temp.prev;
        System.out.println(data + " deleted.");
    }

    // Search for an element
    public boolean search(int key) {
        DNode temp = head;
        while (temp != null) {
            if (temp.data == key) {
                System.out.println(key + " found in the list.");
                return true;
            }
            temp = temp.next;
        }
        System.out.println(key + " not found in the list.");
        return false;
    }

    // Display the list from head to tail
    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        DNode temp = head;
        System.out.print("Forward: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Display the list from tail to head
    public void displayBackward() {
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }
        DNode temp = tail;
        System.out.print("Backward: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }
}

// Main class to test the Doubly Linked List
public class DoublyLinkedListDemo {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtBeginning(5);

        list.displayForward();
        list.displayBackward();

        list.search(20);
        list.deleteByValue(10);

        list.displayForward();
    }
}
