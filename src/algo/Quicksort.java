package algo;

import java.util.Random;

public class Quicksort {
    private int M = 50;

    public void sort(int[] arr, int from, int to) {
        sort(from, to-1, arr);
    }
    private void sort(int lo, int hi, int[] arr) {
        // Här kontrollerar jag om skillnaden mellan hi och lo är mindre än M, och i så fall kör insertionSort.
        if (hi - lo <= M) {
            MyInsertionTest.insertionSort(arr, lo, hi);
            return;
        } else {
            // Här beräknar jag random pivot.
            Random random = new Random();
            int pIndex = lo + random.nextInt(hi - lo +1);
            swap(pIndex, hi, arr);

            int j = partition(lo, hi, arr);
            sort(lo, j - 1, arr);
            sort(j + 1, hi, arr);
        }
    }
    private int partition(int lo, int hi, int[] arr) {
        int p = arr[hi], i = lo-1, j = hi;
        while (true) {
            do {
                i++;
            } while (i != hi && arr[i] < p);
            do {
                j--;
            } while (arr[j] > p);
            if (i >= j) break;
            swap(i, j, arr);
        }
        swap(i, hi, arr);
        return i;
    }

    private void swap(int a, int b, int[] arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        Quicksort q = new Quicksort();
        int[] nbr = new int[]{4, 3, 5, 56, 6, 3, 2, 2, 5, 88, 7, 6, 6, 5, 5, 4, 8, 9, 8, 8, 8, 3, 13, 3};
        q.sort(nbr, 0, nbr.length-1);
        for (int i = 0; i < nbr.length; i++) {
            System.out.print(nbr[i] + " ");
        }
    }
}
