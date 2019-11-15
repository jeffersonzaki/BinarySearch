package OnlyArrays;

import javax.swing.*;

public class BinarySearch {

    public static String output = "";

    public static void readArray(long[] a, int index) {
        if(index < a.length) {
            a[index] = (int)(Math.random() * 100);
            readArray(a, index+1);
        }
    }

    public static void printArray(long[] a, int index) {
        if(index < a.length) {
            output += " " + a[index];
            printArray(a, index+1);
        }
    }

    //sort the array
    public static void bubbleSort(long[] a) {
        for(int row = 0; row < a.length - 1; row++) {
            for (int clm = 0; clm < (a.length -1) - row; clm++) {
                if(a[clm] > a[clm+1]) {
                    long temp = a[clm];
                    a[clm] = a[clm+1];
                    a[clm+1] = temp;
                }
            }
        }
        return;
    }

    //Binary Search
    /*public static boolean binSearch(long[] a, int item) {
        int low = 0;
        int high = a.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(a[mid] == item) {
                return true;
            }
            else if(item > a[mid]) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return false;
    }*/

    //Binary Search in Recursion
    public static boolean binSearch(long[] a, int item, int low, int high) {
        int mid = (low + high) / 2;
        if(a[mid] == item) {
            return true;
        }
        else if(item > a[mid]) {
            return binSearch(a, item, mid+1, high) ;
        }
        else {
            return binSearch(a, item, low, mid-1);
        }
    }


    // * Main Method * //
    public static void main(String[] args) {
        final int SIZE = 15;
        long[] w = new long[SIZE];

        //read array values
        readArray(w, 0);

        //unsorted the array
        output += "\nThe unsorted array is: ";
        printArray(w, 0);

        //sort the array using bubble sort
        output += "\nThe sorted array, using the bubble sort is: ";
        bubbleSort(w);
        printArray(w, 0);
        JOptionPane.showMessageDialog(null, output);


        //use binary search. Ask the user to search for a number
        int num = Integer.parseInt(JOptionPane.showInputDialog("\nEnter an integer number e.g. 27"));
       // boolean found = binSearch(w, num);
        //recursion
        boolean found = binSearch(w, num, 1,SIZE-1);


        output += "\n";
        if(found == true) {
            output += "\nThe Number " + num + " is found in the list.";
        }
        else {
            output += "\nThe Number " + num + " has not been found in the list";
        }

        JOptionPane.showMessageDialog(null, output);
    }
}
