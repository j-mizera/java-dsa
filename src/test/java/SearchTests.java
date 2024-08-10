import eu.witherxse.dsa.SearchAlgorithms;
import org.junit.jupiter.api.Test;

public class SearchTests {

    @Test
    public void testBinarySearch() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int searchInt = 8;
        int expected = 7;
        int actual = SearchAlgorithms.binarySearch(array, searchInt);
        assert expected == actual;
    }

    @Test
    public void testBinarySearchNotFound() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int searchInt = 10;
        int expected = -1;
        int actual = SearchAlgorithms.binarySearch(array, searchInt);
        assert expected == actual;
    }

    @Test
    public void testNSquareRootSearch() {
        boolean[] isTrueArray = {false, false, false, false, false, false, false, true, true, true};
        int expected = 6;
        int actual = SearchAlgorithms.nSquareRootSearch(isTrueArray);
        assert expected == actual;
    }

    @Test
    public void testNSquareRootSearchNotFound() {
        boolean[] isTrueArray = {false, false, false, false, false, false, false, false, false, false};
        int expected = -1;
        int actual = SearchAlgorithms.nSquareRootSearch(isTrueArray);
        assert expected == actual;
    }
}
