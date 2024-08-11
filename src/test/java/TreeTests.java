import eu.witherxse.dsa.BinaryNode;
import eu.witherxse.dsa.TreeAlgorithms;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TreeTests {

    @Test
    public void testPreTraverse() {
        BinaryNode<Integer> root = new BinaryNode<>(1);
        BinaryNode<Integer> left = new BinaryNode<>(2);
        BinaryNode<Integer> right = new BinaryNode<>(3);
        BinaryNode<Integer> leftLeft = new BinaryNode<>(4);
        BinaryNode<Integer> leftRight = new BinaryNode<>(5);
        BinaryNode<Integer> rightLeft = new BinaryNode<>(6);
        BinaryNode<Integer> rightRight = new BinaryNode<>(7);

        root.setLeft(left);
        root.setRight(right);
        left.setLeft(leftLeft);
        left.setRight(leftRight);
        right.setLeft(rightLeft);
        right.setRight(rightRight);

        List<Integer> traverseList = TreeAlgorithms.preVisitTraverse(root);
        assert traverseList.size() == 7;
        assert "[1, 2, 4, 5, 3, 6, 7]".equals(traverseList.toString())
                : "Expected [1, 2, 4, 5, 3, 6, 7] but got "
                + traverseList;
    }

    @Test
    public void testInTraverse() {
        BinaryNode<Integer> root = new BinaryNode<>(1);
        BinaryNode<Integer> left = new BinaryNode<>(2);
        BinaryNode<Integer> right = new BinaryNode<>(3);
        BinaryNode<Integer> leftLeft = new BinaryNode<>(4);
        BinaryNode<Integer> leftRight = new BinaryNode<>(5);
        BinaryNode<Integer> rightLeft = new BinaryNode<>(6);
        BinaryNode<Integer> rightRight = new BinaryNode<>(7);

        root.setLeft(left);
        root.setRight(right);
        left.setLeft(leftLeft);
        left.setRight(leftRight);
        right.setLeft(rightLeft);
        right.setRight(rightRight);

        List<Integer> traverseList = TreeAlgorithms.inVisitTraverse(root);
        assert traverseList.size() == 7;
        assert "[4, 2, 5, 1, 6, 3, 7]".equals(traverseList.toString())
                : "Expected [4, 2, 5, 1, 6, 3, 7] but got "
                + traverseList;
    }

    @Test
    public void testPostTraverse() {
        BinaryNode<Integer> root = new BinaryNode<>(1);
        BinaryNode<Integer> left = new BinaryNode<>(2);
        BinaryNode<Integer> right = new BinaryNode<>(3);
        BinaryNode<Integer> leftLeft = new BinaryNode<>(4);
        BinaryNode<Integer> leftRight = new BinaryNode<>(5);
        BinaryNode<Integer> rightLeft = new BinaryNode<>(6);
        BinaryNode<Integer> rightRight = new BinaryNode<>(7);

        root.setLeft(left);
        root.setRight(right);
        left.setLeft(leftLeft);
        left.setRight(leftRight);
        right.setLeft(rightLeft);
        right.setRight(rightRight);

        List<Integer> traverseList = TreeAlgorithms.postVisitTraverse(root);
        assert traverseList.size() == 7;
        assert "[4, 5, 2, 6, 7, 3, 1]".equals(traverseList.toString())
                : "Expected [2, 4, 5, 6, 7, 3, 1] but got "
                + traverseList;
    }
}
