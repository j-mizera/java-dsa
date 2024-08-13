package eu.witherxse.dsa.tree;

import java.util.Objects;

/**
 * Binary tree data structure.
 *
 * @param <T>
 */
public class BinaryTree<T extends Comparable<T>> {

    private BinaryNode<T> root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(T value) {
        Objects.requireNonNull(value);
        if (Objects.isNull(this.root)) {
            this.root = new BinaryNode<>(value);
        } else {
            insert(this.root, value);
        }
    }

    public void delete(T value) {
        if (Objects.nonNull(value) && Objects.nonNull(this.root)) {
            int comparison = this.root.getValue().compareTo(value);
            if (comparison == 0) {
                if (Objects.isNull(this.root.getLeft())) {
                    this.root = this.root.getRight();
                } else if (Objects.isNull(this.root.getRight())) {
                    this.root = this.root.getLeft();
                } else {
                    BinaryNode<T> successor = findSuccessor(this.root);
                    this.root.setValue(successor.getValue());
                    this.root.setRight(delete(this.root.getRight(), successor.getValue()));
                }
            } else {
                if (comparison > 0) {
                    if (Objects.nonNull(this.root.getLeft())) {
                        this.root.setLeft(delete(this.root.getLeft(), value));
                    }
                } else {
                    if (Objects.nonNull(this.root.getRight())) {
                        this.root.setRight(delete(this.root.getRight(), value));
                    }
                }
            }
        }
    }

    private void insert(BinaryNode<T> insertionPoint, T value) {
        if (insertionPoint.getValue().compareTo(value) >= 0) {
            if (Objects.nonNull(insertionPoint.getLeft())) {
                insert(insertionPoint.getLeft(), value);
            } else {
                BinaryNode<T> newNode = new BinaryNode<>(value);
                insertionPoint.setLeft(newNode);
            }
        } else {
            if (Objects.nonNull(insertionPoint.getRight())) {
                insert(insertionPoint.getRight(), value);
            } else {
                BinaryNode<T> newNode = new BinaryNode<>(value);
                insertionPoint.setRight(newNode);
            }
        }
    }

    private BinaryNode<T> delete(BinaryNode<T> deletionPoint, T value) {
        BinaryNode<T> result = deletionPoint;
        int comparison = result.getValue().compareTo(value);
        if (comparison == 0) {
            if (Objects.isNull(result.getLeft())) {
                result = deletionPoint.getRight();
            } else if (Objects.isNull(deletionPoint.getRight())) {
                result = deletionPoint.getLeft();
            } else {
                BinaryNode<T> successor = findSuccessor(deletionPoint);
                deletionPoint.setValue(successor.getValue());
                deletionPoint.setRight(delete(deletionPoint.getRight(), successor.getValue()));
            }
        } else if (comparison > 0) {
            if (Objects.nonNull(deletionPoint.getLeft())) {
                result.setLeft(delete(deletionPoint.getLeft(), value));
            }
        } else {
            if (Objects.nonNull(deletionPoint.getRight())) {
               result.setRight(delete(deletionPoint.getRight(), value));
            }
        }
        return result;
    }

    public boolean search(T value) {
        boolean result = false;
        if (Objects.nonNull(value) && Objects.nonNull(this.root)) {
            result = search(this.root, value);
        }
        return result;
    }

    private boolean search(BinaryNode<T> searchPoint, T value) {
        boolean result = false;
        if (Objects.nonNull(searchPoint)) {
            int comparison = searchPoint.getValue().compareTo(value);
            if (comparison == 0) {
                result = true;
            } else if (comparison > 0) {
                result = search(searchPoint.getLeft(), value);
            } else {
                result = search(searchPoint.getRight(), value);
            }
        }
        return result;
    }

    private BinaryNode<T> findSuccessor(BinaryNode<T> node) {
        BinaryNode<T> current = node.getRight();
        while (current != null && Objects.nonNull(current.getLeft())) {
            current = current.getLeft();
        }
        return current;
    }

    public BinaryNode<T> getRoot() {
        return root;
    }
}
