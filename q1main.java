/*
Georgina Nelson
16332886
CT5105 Tools and Techniques
Assignment 1
 */
import java.util.Random;

public class q1main {
    // Q1: main-method which uses the given sorting algorithm to sort some array of int numbers (with at
    // least 16 elements) and prints both the original array and the resulting sorted array.
    public static void main(String[] args) {
        Random rd = new Random(); // creating Random object

        //Create and print new array to be sorted
        System.out.println("To sort: \n");
        int arr[] = new int[16]; // array len 16 - must be power of 2
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(40); // storing random integers in range 0-40 in an array
            System.out.print(arr[i]+", "); // printing each array element
        }

        //Call sorting algorithm
        q1givenSortingAlg alg = new q1givenSortingAlg();
        alg.sort(arr);
        int[] sorted = alg.array;

        //Print sorted array
        System.out.println("\n\nSorted: \n");
        for (int i = 0; i < sorted.length; i++) {
            System.out.print(sorted[i]+", "); // printing each array element
        }
    }
}
