import eu.witherxse.dsa.queue.LIFOQueue;
import eu.witherxse.dsa.list.SimpleDoublyLinkedList;
import eu.witherxse.dsa.queue.SimpleQueue;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class QueueAndListTest {

    @Test
    public void testFIFOQueue() {
        SimpleQueue<Integer> queue = new SimpleDoublyLinkedList<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assert queue.dequeue() == 1;
        assert queue.dequeue() == 2;
        assert queue.dequeue() == 3;
        assert Objects.isNull(queue.peek());
        assert queue.isEmpty();
    }

    @Test
    public void testLIFOQueue() {
        SimpleQueue<Integer> queue = new LIFOQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assert queue.dequeue() == 3;
        assert queue.dequeue() == 2;
        assert queue.dequeue() == 1;
        assert Objects.isNull(queue.peek());
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
