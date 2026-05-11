package wip;

import java.util.Arrays;

public class SliceEx {

    public static void main(String[] args) {

        // Original array
        int arr[] = {1,2,3,4,5,6,7,8,9,10};

        // Copy elements from index 1 to 4
        // Start index is included
        // End index is excluded
        int res[] = Arrays.copyOfRange(arr, 1, 5);

        // Print new array
        System.out.println(Arrays.toString(res));
    }
}