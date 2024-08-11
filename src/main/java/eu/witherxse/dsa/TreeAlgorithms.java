package eu.witherxse.dsa;

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
