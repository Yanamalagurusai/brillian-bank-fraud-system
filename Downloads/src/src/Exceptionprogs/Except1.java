package Exceptionprogs;

public class Except1 {

    public static void main(String[] args) {

        int a = 10;
        int b = 0;

        try {

            System.out.println(a / b);

            System.out.println("Inside Try");
        }

        catch (ArithmeticException e) {

            System.out.println("Caught : " + e);
        }

        System.out.println("Execution completed....");
    }
}