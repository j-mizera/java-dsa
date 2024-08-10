package eu.witherxse.dsa;

import java.util.Objects;

public class SearchAlgorithms {

    /**
     * Search that levrages the fact that input array is sorted.
     * @param array
     * @param searchInt
     * @return index
     */
    public static int binarySearch(int[] array, int searchInt) {
        Objects.requireNonNull(array);
        int low = 0;
        int high = array.length;
        int idx = -1;
        do {
            final int middle = (int) Math.floor(low + (high - low) / 2);
            final int val = array[middle];
            if (val == searchInt) {
                idx = middle;
                break;
            } else if (val > searchInt) {
                high = middle;
            } else {
                low = middle + 1;
            }
        } while (low < high);
        return idx;
    }

    /**
     * Search that levrages the fact that input array is sorted
     * + that at some point in that array some condition will be true for the rest of array.
     * @param isTrueArray
     * @return idx
     */
    public static int nSquareRootSearch(boolean[] isTrueArray) {
        Objects.requireNonNull(isTrueArray);
        final int jump = (int) Math.floor(Math.sqrt(isTrueArray.length));
        int idx = -1;

        int i = jump;
        for (;i < isTrueArray.length; i += jump) {
            if (isTrueArray[i]) {
                break;
            }
        }
        if (i >= isTrueArray.length) {
            i = isTrueArray.length - 1;
        }
        if (isTrueArray[i]) {
            idx = i;
            final int start = i - jump;
            while (idx > start) {
                idx--;
            }
        }
        return idx;
    }
}
