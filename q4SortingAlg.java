/*
Georgina Nelson
16332886
CT5105 Tools and Techniques
Assignment 1
 */

// Q4: Make sensible use of parallel computing (using multithreading) in the body of
// method sort(int low, int n)

public class q4SortingAlg {
    int[] array;

    public void sort(int[] array) { // array length must be a power of 2
        this.array = array;
        sort(0, array.length);
    }
    private void sort(int low, int n) {

        if (n > 1) {
            int mid = n >> 1;

            // Create a new thread for each recursive call of this sort method
            Thread t1 = new Thread(){
                public void run() {
                    sort(low, mid);
                }
            };
            t1.start();

            Thread t2 = new Thread(){
                public void run() {
                    sort(low+mid, mid);
                }
            };
            t2.start();

            // Finish sort threads together
            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

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
        if (array[i] > array[j])
            swap(i, j);
    }
    private void swap(int i, int j) {
        int h = array[i];
        array[i] = array[j];
        array[j] = h;
    }
}
