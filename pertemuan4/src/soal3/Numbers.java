package soal3;

// ******************************************************
// Numbers.java
//
// Demonstrates insertionSort on an array of integers (descending).
// Fixed: uses Integer[] instead of int[] to work with Comparable.
// ******************************************************
import java.util.Scanner;

public class Numbers
{
    // --------------------------------------------
    // Reads in an array of integers, sorts them,
    // then prints them in sorted order.
    // --------------------------------------------
    public static void main (String[] args)
    {
        Integer[] intList;  // FIXED: changed int[] to Integer[]
        int size;

        Scanner scan = new Scanner(System.in);

        System.out.print ("\nHow many integers do you want to sort? ");
        size = scan.nextInt();

        intList = new Integer[size];  // FIXED: changed int[] to Integer[]

        System.out.println ("\nEnter the numbers...");
        for (int i = 0; i < size; i++)
            intList[i] = scan.nextInt();  // autoboxing handles int -> Integer

        Sorting.insertionSort(intList);  // changed to insertionSort (descending)

        System.out.println ("\nYour numbers in sorted order (descending)...");
        for (int i = 0; i < size; i++)
            System.out.print(intList[i] + " ");
        System.out.println ();
    }
}
