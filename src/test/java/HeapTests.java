import eu.witherxse.dsa.heap.Heap;
import eu.witherxse.dsa.heap.MaxHeap;
import eu.witherxse.dsa.heap.MinHeap;
import org.junit.jupiter.api.Test;

public class HeapTests {

    @Test
    public void testMinHeap() {
        Heap<Integer> heap = new MinHeap<>();
        heap.insert(1);
        heap.insert(6);
        heap.insert(3);
        heap.insert(5);
        heap.insert(4);
        heap.insert(2);

        assert heap.pop() == 1;
        assert heap.pop() == 2;
        assert heap.pop() == 3;
        assert heap.pop() == 4;
        assert heap.pop() == 5;
        assert heap.pop() == 6;
        assert heap.pop() == null;
    }

    @Test
    public void testMaxHeap() {
        Heap<Integer> heap = new MaxHeap<>();
        heap.insert(1);
        heap.insert(6);
        heap.insert(3);
        heap.insert(5);
        heap.insert(4);
        heap.insert(2);

        assert heap.pop() == 6;
        assert heap.pop() == 5;
        assert heap.pop() == 4;
        assert heap.pop() == 3;
        assert heap.pop() == 2;
        assert heap.pop() == 1;
        assert heap.pop() == null;
    }
}
