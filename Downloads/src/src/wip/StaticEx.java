package wip;

public class StaticEx {

    static int a = 10; // shared by all objects

    // Constructor
    public StaticEx() {

        System.out.println("constructor");

        a++;
    }

    // Static method
    static void meth() {

        System.out.println(a);
    }

    // Static block
    static {

        System.out.println("Static block");
    }

    // Non-static block / instance block
    {

        System.out.println("Non-static block");
    }

    public static void main(String[] args) {

        StaticEx st = new StaticEx();

        System.out.println("Main");

        meth();
    }
}