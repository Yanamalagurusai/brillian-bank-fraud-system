package wip;

public class StringEx {

    public static void main(String[] args) {

        String s1 = new String("World");
        String s2 = new String("World");

        // checks reference
        System.out.println(s1 == s2);

        // checks values
        System.out.println(s1.equals(s2));

        System.out.println(s1);

        System.out.println(s1.concat("Trade"));

        System.out.println(s1);

        System.out.println();

        StringBuffer sb = new StringBuffer("Welcome");

        System.out.println(sb);

        System.out.println(sb.capacity());

        System.out.println(sb.append("buddy"));

        System.out.println(sb);
    }
}