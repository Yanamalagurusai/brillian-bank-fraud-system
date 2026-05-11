package wip;

@FunctionalInterface
public interface Inter2 {

    int sub(int a, int b);

    default void show() {

        System.out.println("Calling from Inter2");
    }
}