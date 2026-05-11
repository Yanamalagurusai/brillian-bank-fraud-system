package wip;

class A {

    void show() {
        System.out.println("From A class");
    }
}

class B extends A {

    @Override
    void show() {

        super.show();

        System.out.println("From B class");
    }
}

public class OverrideEx {

    public static void main(String[] args) {

        B b = new B();

        b.show();
    }
}