package Ds;

class DNode {

    int data;
    DNode prev;
    DNode next;

    DNode(int data) {
        this.data = data;
    }
}

public class DoublyLinkedListEx {

    DNode head;

    // Insert at end
    void insert(int data) {

        DNode newNode = new DNode(data);

        if(head == null) {
            head = newNode;
            return;
        }

        DNode temp = head;

        while(temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;
    }

    // Delete node
    void delete(int value) {

        DNode temp = head;

        while(temp != null && temp.data != value) {
            temp = temp.next;
        }

        if(temp == null)
            return;

        if(temp == head) {
            head = head.next;

            if(head != null)
                head.prev = null;

            return;
        }

        if(temp.next != null) {
            temp.next.prev = temp.prev;
        }

        if(temp.prev != null) {
            temp.prev.next = temp.next;
        }
    }

    // Display forward
    void display() {

        DNode temp = head;

        while(temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        DoublyLinkedListEx d = new DoublyLinkedListEx();

        d.insert(10);
        d.insert(20);
        d.insert(30);

        d.display();

        d.delete(20);

        d.display();
    }
}