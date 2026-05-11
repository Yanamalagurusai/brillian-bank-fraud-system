package Ds;

class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SingleLinkedListEx {

    Node head;

    // Insert at end
    void insert(int data) {

        Node newNode = new Node(data);

        if(head == null) {
            head = newNode;
        }
        else {

            Node temp = head;

            while(temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }
    }

    // Delete node
    void delete(int value) {

        if(head == null)
            return;

        if(head.data == value) {
            head = head.next;
            return;
        }

        Node temp = head;

        while(temp.next != null && temp.next.data != value) {
            temp = temp.next;
        }

        if(temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    // Search element
    void search(int value) {

        Node temp = head;

        while(temp != null) {

            if(temp.data == value) {
                System.out.println("Element Found");
                return;
            }

            temp = temp.next;
        }

        System.out.println("Element Not Found");
    }

    // Display list
    void display() {

        Node temp = head;

        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        SingleLinkedListEx s = new SingleLinkedListEx();

        s.insert(10);
        s.insert(20);
        s.insert(30);

        s.display();

        s.delete(20);

        s.display();

        s.search(30);
    }
}