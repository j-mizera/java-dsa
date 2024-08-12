package eu.witherxse.dsa.tree;

import java.util.Objects;

/**
 * Node of binary tree data structure.
 *
 * @param <T> Type of value stored in node.
 */
public class BinaryNode<T> {
    private T value;
    private BinaryNode<T> left;
    private BinaryNode<T> right;

    public BinaryNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public BinaryNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryNode<T> left) {
        this.left = left;
    }

    public BinaryNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryNode<T> right) {
        this.right = right;
    }

    public boolean isLeaf() {
        return Objects.isNull(this.left) && Objects.isNull(this.right);
    }

    void setValue(T value) {
        this.value = value;
    }
}
