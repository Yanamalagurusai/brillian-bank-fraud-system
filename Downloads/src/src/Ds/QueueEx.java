package Ds;

class QueueEx {

    int arr[] = new int[5];

    int front = -1;
    int rear = -1;

    // Enqueue operation
    void enqueue(int data) {

        if(rear == arr.length - 1) {

            System.out.println("Queue Overflow");
        }
        else {

            if(front == -1) {
                front = 0;
            }

            rear++;

            arr[rear] = data;

            System.out.println(data + " inserted");
        }
    }

    // Dequeue operation
    void dequeue() {

        if(front == -1 || front > rear) {

            System.out.println("Queue Underflow");
        }
        else {

            System.out.println(arr[front] + " removed");

            front++;
        }
    }

    // Display queue
    void display() {

        if(front == -1 || front > rear) {

            System.out.println("Queue is Empty");
        }
        else {

            for(int i = front; i <= rear; i++) {

                System.out.print(arr[i] + " ");
            }

            System.out.println();
        }
    }

    // Peek operation
    void peek() {

        if(front == -1 || front > rear) {

            System.out.println("Queue is Empty");
        }
        else {

            System.out.println("Front Element : " + arr[front]);
        }
    }

    public static void main(String[] args) {

        QueueEx q = new QueueEx();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        q.display();

        q.dequeue();

        q.display();

        q.peek();
    }
}