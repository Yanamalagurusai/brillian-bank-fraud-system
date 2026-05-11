package Exceptionprogs;

public class FInallyEx {

    public static void main(String[] args) {

        System.out.println(putNumber(20));
    }

    static String putNumber(int num1) {

        try {

            if(num1 > 0) {

                return "Positive";
            }
            else {

                return "Negative";
            }
        }

        catch (Exception e) {

            System.out.println(e.getMessage());
        }

        finally {

            System.out.println("Method Closed.....");
        }

        return "End";
    }
}