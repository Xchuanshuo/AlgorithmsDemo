package acwing;

import java.util.Scanner;

/**
 * @author Legend
 * @data by on 21-8-5.
 * @description
 */
public class Test787 {

    private static int[] temp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            temp = new int[n];
            mergeSort(arr, 0, n - 1);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    private static void mergeSort(int[] arr, int l, int r) {
        if (l >= r) return;
        int mid = l + (r - l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, r);
    }

    private static void merge(int[] arr, int l, int r) {
        int mid = l + (r - l) / 2;
        int i = l, j = mid + 1, k = l;
        while (i <= mid && j <= r) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= r) temp[k++] = arr[j++];
        while (l <= r) arr[l] = temp[l++];
    }
}
