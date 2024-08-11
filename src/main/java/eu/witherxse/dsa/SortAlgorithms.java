package eu.witherxse.dsa;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class SortAlgorithms {

    /**
     * Bubble sort algorithm, simple effective o(n squared).
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        Objects.requireNonNull(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    final int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    public static void quickSort(int[] arr) {
        Objects.requireNonNull(arr);
        quickSortInternal(arr, 0, arr.length - 1);
    }

    private static void quickSortInternal(int[] arr, int low, int high) {
        if (low < high) {
            final int pivotIdx = quickSortPartition(arr, low, high);
            quickSortInternal(arr, low, pivotIdx - 1);
            quickSortInternal(arr, pivotIdx + 1, high);
        }
    }

    private static int quickSortPartition(int[] arr, int low, int high) {
        final int pivot = arr[high];
        int idx = low - 1;

        for (int i = low; i < high; i++) {
            if (arr[i] <= pivot) {
                idx++;
                final int tmp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = tmp;
            }
        }

        idx++;
        arr[high] = arr[idx];
        arr[idx] = pivot;
        return idx;
    }

    public static Collection<SortAlgorithm> allAlgorithms() {
        return List.of(SortAlgorithms::bubbleSort, SortAlgorithms::quickSort);
    }

    @FunctionalInterface
    public interface SortAlgorithm {

        /**
         * Sorts input array ascending order.
         * @param arr
         */
        void sort(int[] arr);
    }
}
