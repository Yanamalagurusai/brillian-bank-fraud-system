package UtilProgs;

import java.util.*;

public class ListEx {

    public static void main(String[] args) {

        List ls = new ArrayList();

        ls.add(10);
        ls.add(50);
        ls.add(30);
        ls.add(80);

        System.out.println(ls.get(2));

        // Normal for loop
        /*
        for(int i = 0; i < ls.size(); i++)
        {
            System.out.println(ls.get(i));
        }
        */

        // Enhanced for loop
        for(Object obj : ls)
        {
            System.out.println(obj);
        }
    }
}