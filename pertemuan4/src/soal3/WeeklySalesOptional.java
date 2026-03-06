package soal3;

// *************************************************************
// WeeklySalesOptional.java
//
// Sorts the sales staff in descending order by sales.
// Salespeople are read from user input (not hardcoded).
// ************************************************************
import java.util.Scanner;

public class WeeklySalesOptional
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        System.out.print("How many salespeople do you want to enter? ");
        int size = scan.nextInt();

        Salesperson[] salesStaff = new Salesperson[size];

        for (int i = 0; i < size; i++)
        {
            System.out.println("\nSalesperson #" + (i + 1) + ":");
            System.out.print("  First name : ");
            String first = scan.next();
            System.out.print("  Last name  : ");
            String last = scan.next();
            System.out.print("  Total sales: ");
            int sales = scan.nextInt();

            salesStaff[i] = new Salesperson(first, last, sales);
        }

        Sorting.insertionSort(salesStaff);

        System.out.println("\nRanking of Sales for the Week\n");
        for (Salesperson s : salesStaff)
            System.out.println(s);
    }
}