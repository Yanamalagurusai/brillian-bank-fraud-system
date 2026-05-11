package Ds;

class StackEx {

    int arr[] = new int[5];

    int top = -1;

    // Push operation
    void push(int data) {

        if(top == arr.length - 1) {

            System.out.println("Stack Overflow");
        }
        else {

            top++;

            arr[top] = data;

            System.out.println(data + " pushed");
        }
    }

    // Pop operation
    void pop() {

        if(top == -1) {

            System.out.println("Stack Underflow");
        }
        else {

            System.out.println(arr[top] + " popped");

            top--;
        }
    }

    // Peek operation
    void peek() {

        if(top == -1) {

            System.out.println("Stack is Empty");
        }
        else {

            System.out.println("Top Element : " + arr[top]);
        }
    }

    // Display operation
    void display() {

        if(top == -1) {

            System.out.println("Stack is Empty");
        }
        else {

            for(int i = top; i >= 0; i--) {

                System.out.println(arr[i]);
            }
        }
    }

    // Search operation
    void search(int value) {

        boolean found = false;

        for(int i = 0; i <= top; i++) {

            if(arr[i] == value) {

                found = true;
                break;
            }
        }

        if(found) {

            System.out.println("Element Found");
        }
        else {

            System.out.println("Element Not Found");
        }
    }

    // isEmpty operation
    void isEmpty() {

        if(top == -1) {

            System.out.println("Stack is Empty");
        }
        else {

            System.out.println("Stack is Not Empty");
        }
    }

    public static void main(String[] args) {

        StackEx s = new StackEx();

        s.push(10);
        s.push(20);
        s.push(30);

        System.out.println();

        s.display();

        System.out.println();

        s.peek();

        System.out.println();

        s.search(20);

        System.out.println();

        s.pop();

        System.out.println();

        s.display();

        System.out.println();

        s.isEmpty();
    }
}