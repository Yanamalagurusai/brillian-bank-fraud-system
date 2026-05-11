package wip;

public class OverloadingEx {

    int add(int n1, int n2) {

        int res = n1 + n2;

        return res;
    }

    int add(int n1, int n2, int n3) {

        int res = n1 + n2 + n3;

        return res;
    }

    public static void main(String[] args) {

        OverloadingEx ol = new OverloadingEx();

        System.out.println(ol.add(10, 20));

        System.out.println(ol.add(10, 20, 30));
    }
}