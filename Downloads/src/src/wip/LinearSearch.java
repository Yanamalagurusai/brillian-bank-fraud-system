package wip;

import java.util.Scanner;

public class LinearSearch {

    public static void main(String[] args) {

        int[] arr = {7, 3, 5, 1, 9};

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter element to search:");

        int val = sc.nextInt();

        boolean result = false;

        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] == val)
            {
                result = true;
                break;
            }
        }

        if(result)
        {
            System.out.println("Element found");
        }
        else
        {
            System.out.println("Element not found");
        }

        sc.close();
    }
}