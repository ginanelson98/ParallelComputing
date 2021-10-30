/*
Georgina Nelson
16332886
CT5105 Tools and Techniques
Assignment 1
 */
import java.util.Comparator;
import java.util.Random;

public class q2main {
    // Q2: Modify the provided sorting code so that it is able to sort arrays of objects of arbitrary classes
    // Using Comparators
    public static void main(String[] args) {
        Random rd = new Random(); // creating Random object

        //Create and print new array to be sorted
        System.out.println("Double Array to Sort: \n");
        Double doublearr[] = new Double[16]; // array len 16 - must be power of 2
        for (int i = 0; i < doublearr.length; i++) {
            doublearr[i] = rd.nextDouble(); // storing random integers in range 0-40 in an array
            System.out.print(doublearr[i]+", "); // printing each array element
        }

        // Init double comparator
        Comparator doublecomp = new DoubleComparator();

        //Call altered sorting algorithm
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

        // Init String Comparator
        Comparator strcomp = new StringComparator();

        //Call altered sorting algorithm
        //alteredSortingAlg alg = new alteredSortingAlg();
        alg.sort(stringarr, strcomp);
        Object[] stringsorted = alg.array;

        //Print sorted array
        System.out.println("\n\nString array Sorted: \n");
        for (int i = 0; i < stringsorted.length; i++) {
            System.out.print(stringsorted[i]+", "); // printing each array element
        }
    }

    // COMPARATORS
    public static class StringComparator implements Comparator<String> {
        public int compare(String obj1, String obj2) {
            if (obj1 == obj2) {
                return 0;
            }
            if (obj1 == null) {
                return -1;
            }
            if (obj2 == null) {
                return 1;
            }
            return obj2.compareTo(obj1);
        }
    }

    public static class DoubleComparator  implements Comparator<Double> {
        public int compare(Double obj1, Double obj2) {
            if (obj1 == obj2) {
                return 0;
            }
            if (obj1 == null) {
                return -1;
            }
            if (obj2 == null) {
                return 1;
            }
            return obj2.compareTo(obj1);
        }
    }
}
