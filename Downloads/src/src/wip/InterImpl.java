package wip;

public class InterImpl implements Inter1, Inter2 {

    @Override
    public int add(int x, int y) {

        return x + y;
    }

    void display() {

        System.out.println("Class method");
    }

    @Override
    public int sub(int a, int b) {

        return a - b;
    }

    public static void main(String[] args) {

        InterImpl i = new InterImpl();

        System.out.println(i.add(3, 5));

        System.out.println(i.sub(3, 5));

        i.display();

        i.show();
    }
}