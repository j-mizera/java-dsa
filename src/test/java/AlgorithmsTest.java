import eu.witherxse.dsa.SortAlgorithms;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class AlgorithmsTest {

    @Test
    void testAll() {
        int[] unsorted = {5, 3, 1, 2, 4};
        int[] sorted = {1, 2, 3, 4, 5};
        for (SortAlgorithms.SortAlgorithm sortAlgorithm : SortAlgorithms.allAlgorithms()) {
            sortAlgorithm.sort(unsorted);
            for (int i = 0; i < unsorted.length; i++) {
                assert Objects.deepEquals(sorted[i], unsorted[i]);
            }
            unsorted = new int[]{5, 3, 1, 2, 4};
        }
    }
}
