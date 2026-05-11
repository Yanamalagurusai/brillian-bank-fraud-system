package UtilProgs;

import java.util.*;

public class SetEx {

    public static void main(String[] args) {

        Set s = new HashSet();

        s.add("java");

        System.out.println(s.hashCode());

        s.add(70);
        s.add(10);
        s.add(40);

        s.add(null);
        s.add(null);

        System.out.println(s);
    }
}