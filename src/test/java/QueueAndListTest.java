import eu.witherxse.dsa.LIFOQueue;
import eu.witherxse.dsa.SimpleDoublyLinkedList;
import eu.witherxse.dsa.SimpleQueue;
import org.junit.jupiter.api.Test;

public class QueueAndListTest {

    @Test
    public void testFIFOQueue() {
        SimpleQueue<Integer> queue = new SimpleDoublyLinkedList<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assert queue.dequeue().get() == 1;
        assert queue.dequeue().get() == 2;
        assert queue.dequeue().get() == 3;
        assert queue.peek().isEmpty();
        assert queue.isEmpty();
    }

    @Test
    public void testLIFOQueue() {
        SimpleQueue<Integer> queue = new LIFOQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assert queue.dequeue().get() == 3;
        assert queue.dequeue().get() == 2;
        assert queue.dequeue().get() == 1;
        assert queue.peek().isEmpty();
        assert queue.isEmpty();
    }

    @Test
    public void testList() {
        SimpleDoublyLinkedList<Integer> list = new SimpleDoublyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assert list.get(0) == 1;
        assert list.get(1) == 2;
        assert list.get(2) == 3;
        assert list.contains(1);
        assert !list.remove((Integer) 4);
    }
}
