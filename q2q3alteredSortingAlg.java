/*
Georgina Nelson
16332886
CT5105 Tools and Techniques
Assignment 1
 */
import java.util.Comparator;

// Q2, Q3: Takes in comparator for sorting Objects instead of int on Q1
public class q2q3alteredSortingAlg {
    Object[] array;
    Comparator comp;

    public void sort(Object[] array, Comparator comp) { // array length must be a power of 2
        this.array = array;
        this.comp = comp;
        sort(0, array.length);
    }
    private void sort(int low, int n) {

        if (n > 1) {
            int mid = n >> 1;

            sort(low, mid);
            sort(low + mid, mid);

            combine(low, n, 1);
        }
    }
    private void combine(int low, int n, int st) {

        int m = st << 1;

        if (m < n) {
            combine(low, n, m);
            combine(low + st, n, m);

            for (int i = low + st; i + st < low + n; i += m)
                compareAndSwap(i, i + st);

        } else
            compareAndSwap(low, low + st);
    }
    private void compareAndSwap(int i, int j) {
        if (comp.compare(array[i], array[j]) < 0)
            swap(i, j);
    }
    private void swap(int i, int j) {
        Object h = array[i];
        array[i] = array[j];
        array[j] = h;
    }
}
