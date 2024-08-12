import eu.witherxse.dsa.tree.BinaryNode;
import eu.witherxse.dsa.tree.BinaryTree;
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
        List<Integer> shouldContain = List.of(1, 2, 4, 5, 3, 6, 7);
        assert traverseList.size() == 7;
        //not the best method but for now it will do
        assert shouldContain.equals(traverseList)
                : "Expected " + shouldContain + " but got "
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
        List<Integer> shouldContain = List.of(4, 2, 5, 1, 6, 3, 7);
        assert traverseList.size() == 7;
        //not the best method but for now it will do
        assert shouldContain.equals(traverseList)
                : "Expected " + shouldContain + " but got "
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
        List<Integer> shouldContain = List.of(4, 5, 2, 6, 7, 3, 1);
        assert traverseList.size() == 7;
        //not the best method but for now it will do
        assert shouldContain.equals(traverseList)
                : "Expected " + shouldContain + " but got "
                + traverseList;
    }

    @Test
    public void testInTraverseEmpty() {
        BinaryNode<Integer> root = null;
        List<Integer> traverseList = TreeAlgorithms.inVisitTraverse(root);
        assert traverseList.isEmpty();
    }

    @Test
    public void testBreadthFirstSearch() {
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

        assert TreeAlgorithms.breadthFirstSearch(root, 5);
        assert !TreeAlgorithms.breadthFirstSearch(root, 8);
    }

    @Test
    public void testCompareTreesEqual() {
        BinaryNode<Integer> root1 = new BinaryNode<>(1);
        BinaryNode<Integer> left1 = new BinaryNode<>(2);
        BinaryNode<Integer> right1 = new BinaryNode<>(3);
        BinaryNode<Integer> leftLeft1 = new BinaryNode<>(4);
        BinaryNode<Integer> leftRight1 = new BinaryNode<>(5);
        BinaryNode<Integer> rightLeft1 = new BinaryNode<>(6);
        BinaryNode<Integer> rightRight1 = new BinaryNode<>(7);

        root1.setLeft(left1);
        root1.setRight(right1);
        left1.setLeft(leftLeft1);
        left1.setRight(leftRight1);
        right1.setLeft(rightLeft1);
        right1.setRight(rightRight1);

        BinaryNode<Integer> root2 = new BinaryNode<>(1);
        BinaryNode<Integer> left2 = new BinaryNode<>(2);
        BinaryNode<Integer> right2 = new BinaryNode<>(3);
        BinaryNode<Integer> leftLeft2 = new BinaryNode<>(4);
        BinaryNode<Integer> leftRight2 = new BinaryNode<>(5);
        BinaryNode<Integer> rightLeft2 = new BinaryNode<>(6);
        BinaryNode<Integer> rightRight2 = new BinaryNode<>(7);

        root2.setLeft(left2);
        root2.setRight(right2);
        left2.setLeft(leftLeft2);
        left2.setRight(leftRight2);
        right2.setLeft(rightLeft2);
        right2.setRight(rightRight2);

        assert TreeAlgorithms.compareTrees(root1, root2);
    }

    @Test
    public void testCompareTreesNotEqual() {
        BinaryNode<Integer> root1 = new BinaryNode<>(1);
        BinaryNode<Integer> left1 = new BinaryNode<>(2);
        BinaryNode<Integer> right1 = new BinaryNode<>(3);
        BinaryNode<Integer> leftLeft1 = new BinaryNode<>(4);
        BinaryNode<Integer> leftRight1 = new BinaryNode<>(5);
        BinaryNode<Integer> rightLeft1 = new BinaryNode<>(6);
        BinaryNode<Integer> rightRight1 = new BinaryNode<>(7);

        root1.setLeft(left1);
        root1.setRight(right1);
        left1.setLeft(leftLeft1);
        left1.setRight(leftRight1);
        right1.setLeft(rightLeft1);
        right1.setRight(rightRight1);

        BinaryNode<Integer> root2 = new BinaryNode<>(1);
        BinaryNode<Integer> left2 = new BinaryNode<>(2);
        BinaryNode<Integer> right2 = new BinaryNode<>(3);
        BinaryNode<Integer> leftLeft2 = new BinaryNode<>(4);
        BinaryNode<Integer> leftRight2 = new BinaryNode<>(5);
        BinaryNode<Integer> rightLeft2 = new BinaryNode<>(6);
        BinaryNode<Integer> rightRight2 = new BinaryNode<>(8);

        root2.setLeft(left2);
        root2.setRight(right2);
        left2.setLeft(leftLeft2);
        left2.setRight(leftRight2);
        right2.setLeft(rightLeft2);
        right2.setRight(rightRight2);

        assert !TreeAlgorithms.compareTrees(root1, root2);
    }

    @Test
    public void testBinaryTreeInsert() {
        BinaryTree<Integer> tree = new BinaryTree<>();

        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(1);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);

        BinaryNode<Integer> root = tree.getRoot();
        List<Integer> traverseList = TreeAlgorithms.inVisitTraverse(root);
        List<Integer> shouldContain = List.of(1, 3, 4, 5, 6, 7, 8);
        assert traverseList.size() == 7;
        assert shouldContain.equals(traverseList)
                : "Expected " + shouldContain + " but got "
                + traverseList;
    }

    @Test
    public void testBinaryTreeDelete() {
        BinaryTree<Integer> tree = new BinaryTree<>();

        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(1);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);

        tree.delete(3);

        BinaryNode<Integer> root = tree.getRoot();
        List<Integer> traverseList = TreeAlgorithms.inVisitTraverse(root);
        List<Integer> shouldContain = List.of(1, 4, 5, 6, 7, 8);
        assert traverseList.size() == 6;
        //not the best method but for now it will do
        assert shouldContain.equals(traverseList)
                : "Expected " + shouldContain + " but got "
                + traverseList;
    }
}
