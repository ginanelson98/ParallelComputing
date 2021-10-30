/*
Georgina Nelson
16332886
CT5105 Tools and Techniques
Assignment 1
 */

import java.util.Comparator;
import java.util.Random;

public class q3main {
    // Q3: Lambda expression implementation of comparators
    public static void main(String[] args) {
        Random rd = new Random(); // creating Random object

        //Create and print new array to be sorted
        System.out.println("Double Array to Sort: \n");
        Double doublearr[] = new Double[16]; // array len 16 - must be power of 2
        for (int i = 0; i < doublearr.length; i++) {
            doublearr[i] = rd.nextDouble(); // storing random integers in range 0-40 in an array
            System.out.print(doublearr[i]+", "); // printing each array element
        }

        // LAMDA EXPRESSION - init double comparator
        Comparator<Double> doublecomp = (Double o1, Double o2)->o2.compareTo(o1);

        //Call sorting algorithm
        q2q3alteredSortingAlg alg = new q2q3alteredSortingAlg();
        alg.sort(doublearr, doublecomp);
        Object[] doublesorted = alg.array;

        //Print sorted array
        System.out.println("\n\nDouble Array Sorted: \n");
        for (int i = 0; i < doublesorted.length; i++) {
            System.out.print(doublesorted[i]+", "); // printing each array element
        }

        //*************************************************
        //Create and print new array to be sorted
        System.out.println("\n\n\nString Array to Sort: \n");
        String stringarr[] = new String[16]; // array len 16 - must be power of 2

        for (int i = 0; i < stringarr.length; i++) {
            stringarr[i] = Character.toString((char)(rd.nextInt(26) + 'a'))+Character.toString((char)(rd.nextInt(26) + 'a'));
            System.out.print(stringarr[i]+", "); // printing each array element
        }

        // LAMDA EXPRESSION - init string comparator
        Comparator<String> strcomp = (String o1, String o2)->o2.compareTo(o1);

        //Call sorting algorithm
        //alteredSortingAlg alg = new alteredSortingAlg();
        alg.sort(stringarr, strcomp);
        Object[] stringsorted = alg.array;

        //Print sorted array
        System.out.println("\n\nString array Sorted: \n");
        for (int i = 0; i < stringsorted.length; i++) {
            System.out.print(stringsorted[i]+", "); // printing each array element
        }
    }
}
