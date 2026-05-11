package Exceptionprogs;

class Banking {

    double balance = 5000;

    void withdrawal(double amount) throws InsufficientFundException {

        if(amount > balance) {

            throw new InsufficientFundException("Fund is too low");
        }
        else {

            balance -= amount;

            System.out.println("Successfully done!!! Balance is : " + balance);
        }

        System.out.println("Current Balance : " + balance);
    }
}

public class Except2 {

    public static void main(String[] args) {

        Banking b = new Banking();

        try {

            b.withdrawal(6000);
        }

        catch (InsufficientFundException e) {

            System.out.println("Exception Caught : " + e.getMessage());
        }
    }
}