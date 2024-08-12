package eu.witherxse.dsa.heap;

public class MaxHeap<T extends Comparable<T>> extends AbstractHeap<T> implements Heap<T> {

    @Override
    protected void heapifyDown(int currentIdx, T currentVal, int leftIdx, T leftVal, int rightIdx, T rightVal) {
        if (leftVal.compareTo(rightVal) > 0 && -currentVal.compareTo(leftVal) > 0) {
            swapValues(leftIdx, leftVal, currentIdx, currentVal);
            heapifyDown(leftIdx);
        } else if (rightVal.compareTo(leftVal) > 0 && -currentVal.compareTo(rightVal) > 0) {
            swapValues(rightIdx, rightVal, currentIdx, currentVal);
            heapifyDown(rightIdx);
        }
    }

    @Override
    protected void heapifyUp(int currentIdx, T currentVal, int parentIdx, T parentVal) {
        if (currentVal.compareTo(parentVal) > 0) {
            swapValues(currentIdx, currentVal, parentIdx, parentVal);
            heapifyUp(parentIdx);
        }
    }
}
