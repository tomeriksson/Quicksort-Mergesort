package algo;

public class Mergesort {

    private int M = 50;

    public void sort(int[] arr, int from, int to) {
        int[] temp = new int[to];
        sort(from, to - 1, arr, temp);
    }

    private void sort(int lo, int hi, int[] arr, int[] temp) {
        // Här kontrollerar jag om skillnaden mellan hi och lo är mindre än M, och i så fall kör insertionSort.
        if (hi - lo <= M) {
            MyInsertionTest.insertionSort(arr, lo, hi);
            return;
        } else {
            int mid = lo + (hi - lo) / 2;
            sort(lo, mid, arr, temp);
            sort(mid + 1, hi, arr, temp);
            merge(lo, mid, hi, arr, temp);
        }
    }

    private void merge(int lo, int mid, int hi, int[] arr, int[] temp) {
        for (int i = lo; i <= hi; i++) {
            temp[i] = arr[i];
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                arr[k] = temp[j];
                j++;
            } else if (j > hi) {
                arr[k] = temp[i];
                i++;
            } else {
                if (temp[i] < temp[j]) {
                    arr[k] = temp[i];
                    i++;
                } else {
                    arr[k] = temp[j];
                    j++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Mergesort m = new Mergesort();
        int[] nbr = new int[]{4, 3, 5, 56, 6, 3, 2, 2, 5, 88, 7, 6, 6, 5, 5, 4, 8, 9, 8, 8, 8, 3, 13, 3};
        m.sort(nbr, 0, nbr.length);

        for (int i = 0; i < nbr.length; i++) {
            System.out.print(nbr[i] + " ");
        }
    }

}
