package eu.witherxse.dsa;

import java.util.Collection;
import java.util.List;

public class SortAlgorithms {

    /**
     * Bubble sort algorithm, simple effective o(n squared).
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
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

    public static Collection<SortAlgorithm> allAlgorithms() {
        return List.of(SortAlgorithms::bubbleSort);
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
