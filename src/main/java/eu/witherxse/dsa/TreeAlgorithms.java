package eu.witherxse.dsa;

import eu.witherxse.dsa.list.SimpleDoublyLinkedList;
import eu.witherxse.dsa.queue.SimpleQueue;
import eu.witherxse.dsa.tree.BinaryNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class TreeAlgorithms {

    /**
     * Algorithm that first visits current node, then recurses left and right.
     * @param root
     * @return
     * @param <T>
     */
    public static <T> List<T> preVisitTraverse(BinaryNode<T> root) {
        List<T> traverseList = new LinkedList<>();
        preVisitWalk(root, traverseList);
        return traverseList;
    }

    /**
     * Algorithm that first recurses left, then visits current node and then recurses right.
     * @param root
     * @return
     * @param <T>
     */
    public static <T> List<T> inVisitTraverse(BinaryNode<T> root) {
        List<T> traverseList = new LinkedList<>();
        inVisitWalk(root, traverseList);
        return traverseList;
    }

    /**
     * Algorithm that first recurses left and right, then visits current node.
     * @param root
     * @return
     * @param <T>
     */
    public static <T> List<T> postVisitTraverse(BinaryNode<T> root) {
        List<T> traverseList = new LinkedList<>();
        postVisitWalk(root, traverseList);
        return traverseList;
    }

    /**
     * Breadth-first search algorithm for binary tree.
     * @param root
     * @param searchValue
     * @return
     * @param <T>
     */
    public static <T> boolean breadthFirstSearch(BinaryNode<T> root, T searchValue) {
        SimpleQueue<BinaryNode<T>> bfsQueue = new SimpleDoublyLinkedList<>();
        bfsQueue.enqueue(root);
        boolean result = false;
        while (!bfsQueue.isEmpty() && !result) {
            BinaryNode<T> node = bfsQueue.dequeue();
            if (Objects.nonNull(node) && Objects.equals(node.getValue(), searchValue)) {
                result = true;
            } else if (Objects.nonNull(node) && !node.isLeaf()) {
                bfsQueue.enqueue(node.getLeft());
                bfsQueue.enqueue(node.getRight());
            }
        }
        return result;
    }

    /**
     * Compares two binary trees for equality.
     * @param root1
     * @param root2
     * @return
     * @param <T>
     */
    public static <T> boolean compareTrees(BinaryNode<T> root1, BinaryNode<T> root2) {
        boolean result = Objects.isNull(root1) && Objects.isNull(root2);
        if (!result) {
            result = Objects.nonNull(root1) && Objects.nonNull(root2) && Objects.equals(root1.getValue(), root2.getValue());
            if (result) {
                result = compareTrees(root1.getLeft(), root2.getLeft());
            }
            if (result) {
                result = compareTrees(root1.getRight(), root2.getRight());
            }
        }
        return result;
    }

    private static <T> void preVisitWalk(BinaryNode<T> node, List<T> traverseList) {
        if (Objects.nonNull(node)) {
            traverseList.add(node.getValue());
            preVisitWalk(node.getLeft(), traverseList);
            preVisitWalk(node.getRight(), traverseList);
        }
    }

    private static <T> void inVisitWalk(BinaryNode<T> node, List<T> traverseList) {
        if (Objects.nonNull(node)) {
            inVisitWalk(node.getLeft(), traverseList);
            traverseList.add(node.getValue());
            inVisitWalk(node.getRight(), traverseList);
        }
    }

    private static <T> void postVisitWalk(BinaryNode<T> node, List<T> traverseList) {
        if (Objects.nonNull(node)) {
            postVisitWalk(node.getLeft(), traverseList);
            postVisitWalk(node.getRight(), traverseList);
            traverseList.add(node.getValue());
        }
    }
}
