package eu.witherxse.dsa.heap;

import java.util.ArrayList;

/**
 * Abstract class for heap data structure.
 * Contains common methods for max heap and min heap.
 * The only difference between max heap and min heap is the way they compare elements so the heapify methods are abstract.
 *
 * @param <T>
 */
public abstract class AbstractHeap<T extends Comparable<T>> implements Heap<T> {

    protected int length;
    protected ArrayList<T> data; //just for the sake of simplicity, normally there would be an array and methods
    // for adding and removing elements that copy array

    protected AbstractHeap() {
        this.length = 0;
        this.data = new ArrayList<>();
    }

    @Override
    public void insert(T element) {
        this.data.add(element);
        this.heapifyUp(this.length++);
    }

    @Override
    public T pop() {
        T result;
        if (this.length == 0) {
            result = null;
        } else {
            this.length--;
            result = data.get(0);
            if (this.length == 0) {
                result = data.remove(0);
            } else {
                this.data.set(0, this.data.get(this.length));
                this.heapifyDown(0);
            }
        }
        return result;
    }

    protected void heapifyDown(int idx) {
        final int leftIdx = leftChild(idx);
        if (idx >= this.length || leftIdx >= this.length) {
            return;
        }
        final int rightIdx = rightChild(idx);
        final T leftVal = data.get(leftIdx);
        final T rightVal = data.get(rightIdx);
        final T currentVal = data.get(idx);
        heapifyDown(idx, currentVal, leftIdx, leftVal, rightIdx, rightVal);
    }

    protected void heapifyUp(int idx) {
        if (idx == 0) {
            return;
        }
        final int parentIdx = getParentIdx(idx);
        final T parentData = data.get(parentIdx);
        final T currentData = data.get(idx);
        heapifyUp(idx, currentData, parentIdx, parentData);
    }

    protected abstract void heapifyDown(int currentIdx, T currentVal, int leftIdx, T leftVal, int rightIdx, T rightVal);

    protected abstract void heapifyUp(int currentIdx, T currentVal, int parentIdx, T parentVal);

    protected void swapValues(int idx1, T data1, int idx2, T data2) {
        data.set(idx2, data1);
        data.set(idx1, data2);
    }

    protected int getParentIdx(int idx) {
        return ((idx - 1) / 2);
    }

    protected int leftChild(int idx) {
        return (idx * 2 + 1);
    }

    protected int rightChild(int idx) {
        return (idx * 2 + 2);
    }

}
