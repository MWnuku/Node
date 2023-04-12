import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class NodeTest {

    @Test
    void checkEqualsTrue(){
        Node root = new Node(5);

        root.setLeft(new Node(3));
        root.setRight(new Node(7));

        root.getLeft().setLeft(new Node(2));
        root.getLeft().setRight(new Node(5));

        root.getRight().setRight(new Node(0));
        root.getRight().setLeft(new Node(1));

        root.getRight().getRight().setLeft(new Node(2));
        root.getRight().getRight().setRight(new Node(8));

        root.getRight().getRight().getRight().setRight(new Node(5));

        Node root2 = new Node(5);

        root2.setLeft(new Node(3));
        root2.setRight(new Node(7));

        root2.getLeft().setLeft(new Node(2));
        root2.getLeft().setRight(new Node(5));

        root2.getRight().setRight(new Node(0));
        root2.getRight().setLeft(new Node(1));

        root2.getRight().getRight().setLeft(new Node(2));
        root2.getRight().getRight().setRight(new Node(8));

        root2.getRight().getRight().getRight().setRight(new Node(5));

        assertTrue(root.check(root2));
    }
    @Test
    void checkEqualsFalseLastNode(){
        Node root = new Node(5);

        root.setLeft(new Node(3));
        root.setRight(new Node(7));

        root.getRight().setLeft(new Node(2));
        root.getRight().setRight(new Node(5));

        root.getRight().setRight(new Node(0));
        root.getRight().setLeft(new Node(1));

        root.getRight().getRight().setLeft(new Node(2));
        root.getRight().getRight().setRight(new Node(8));

        root.getRight().getRight().getRight().setRight(new Node(5));

        Node root2 = new Node(5);

        root2.setLeft(new Node(3));
        root2.setRight(new Node(7));

        root2.getLeft().setLeft(new Node(2));
        root2.getLeft().setRight(new Node(5));

        root2.getRight().setRight(new Node(0));
        root2.getRight().setLeft(new Node(1));

        root2.getRight().getRight().setLeft(new Node(2));
        root2.getRight().getRight().setRight(new Node(8));

        root2.getRight().getRight().getRight().setRight(new Node(4));

        assertFalse(root.check(root2));
    }
    @Test
    void checkEqualsFalseMiddleNode(){
        Node root = new Node(5);

        root.setLeft(new Node(3));
        root.setRight(new Node(7));

        root.getLeft().setLeft(new Node(2));
        root.getLeft().setRight(new Node(5));

        root.getRight().setRight(new Node(1));
        root.getRight().setLeft(new Node(1));

        root.getRight().getRight().setLeft(new Node(2));
        root.getRight().getRight().setRight(new Node(8));

        root.getRight().getRight().getRight().setRight(new Node(5));

        Node root2 = new Node(5);

        root2.setLeft(new Node(3));
        root2.setRight(new Node(7));

        root2.getLeft().setLeft(new Node(2));
        root2.getLeft().setRight(new Node(5));

        root2.getRight().setRight(new Node(0));
        root2.getRight().setLeft(new Node(1));

        root2.getRight().getRight().setLeft(new Node(2));
        root2.getRight().getRight().setRight(new Node(8));

        root2.getRight().getRight().getRight().setRight(new Node(5));

        assertFalse(root.check(root2));
    }
    @Test
    void checkEqualsFalseSingleBranch(){
        Node root = new Node(5);

        root.setLeft(new Node(3));
        root.setRight(new Node(7));

        root.getLeft().setLeft(new Node(2));
        root.getLeft().setRight(new Node(5));

        root.getRight().setRight(new Node(1));
        root.getRight().setLeft(new Node(1));

        root.getRight().getRight().setLeft(new Node(2));
        root.getRight().getRight().setRight(new Node(8));

        root.getRight().getRight().getRight().setRight(new Node(5));

        Node root2 = new Node(5);

        root2.setLeft(new Node(3));
        root2.getLeft().setLeft(new Node(2));

        assertFalse(root.check(root2));
    }
    @Test
    void checkEqualsFalseSingleNode(){
        Node root = new Node(5);

        root.setLeft(new Node(3));
        root.setRight(new Node(7));

        root.getLeft().setLeft(new Node(2));
        root.getLeft().setRight(new Node(5));

        root.getRight().setRight(new Node(1));
        root.getRight().setLeft(new Node(1));

        root.getRight().getRight().setLeft(new Node(2));
        root.getRight().getRight().setRight(new Node(8));

        root.getRight().getRight().getRight().setRight(new Node(5));

        Node root2 = new Node(5);

        assertFalse(root.check(root2));
    }
    @Test
    void checkEqualsTrueSingleNodes(){
        Node root = new Node(5);
        Node root2 = new Node(5);
        assertTrue(root.check(root2));
    }
    @Test
    void checkEqualsFalseSingleNodes(){
        Node root = new Node(5);
        Node root2 = new Node(4);
        assertFalse(root.check(root2));
    }

    @Test
    void maxLevel5(){
        Node root = new Node(5);

        root.setLeft(new Node(3));
        root.setRight(new Node(7));

        root.getLeft().setLeft(new Node(2));
        root.getLeft().setRight(new Node(5));

        root.getRight().setRight(new Node(1));
        root.getRight().setLeft(new Node(1));

        root.getRight().getRight().setLeft(new Node(2));
        root.getRight().getRight().setRight(new Node(8));

        root.getRight().getRight().getRight().setRight(new Node(5));

        assertEquals(5, root.findMaxLevel());
    }
    @Test
    void maxLevel1(){
        Node root = new Node(5);
        assertEquals(1, root.findMaxLevel());
    }
    @Test
    void checkPath5(){
        Node root = new Node(5);

        root.setLeft(new Node(3));
        root.setRight(new Node(7));

        root.getLeft().setLeft(new Node(2));
        root.getLeft().setRight(new Node(5));

        root.getRight().setRight(new Node(1));
        root.getRight().setLeft(new Node(1));

        root.getRight().getRight().setLeft(new Node(2));
        root.getRight().getRight().setRight(new Node(8));

        root.getRight().getRight().getRight().setRight(new Node(5));

        assertEquals("5 -> 7 -> 1 -> 8 -> 5", root.printMaxPath().toString());
    }

    @Test
    void maxLevel6(){
        Node root = new Node(5);

        root.setLeft(new Node(3));
        root.setRight(new Node(7));

        root.getLeft().setLeft(new Node(2));
        root.getLeft().setRight(new Node(5));

        root.getRight().setRight(new Node(1));
        root.getRight().setLeft(new Node(1));

        root.getRight().getRight().setLeft(new Node(2));
        root.getRight().getRight().setRight(new Node(8));
        root.getRight().getRight().getRight().setRight(new Node(5));

        root.getRight().getRight().getRight().getRight().setRight(new Node(7));

        assertEquals(6, root.findMaxLevel());
    }
    @Test
    void checkPath6(){
        Node root = new Node(5);

        root.setLeft(new Node(3));
        root.setRight(new Node(7));

        root.getLeft().setLeft(new Node(2));
        root.getLeft().setRight(new Node(5));

        root.getRight().setRight(new Node(1));
        root.getRight().setLeft(new Node(1));

        root.getRight().getRight().setLeft(new Node(2));
        root.getRight().getRight().setRight(new Node(8));

        root.getRight().getRight().getRight().setRight(new Node(5));
        root.getRight().getRight().getRight().getRight().setRight(new Node(7));

        assertEquals("5 -> 7 -> 1 -> 8 -> 5 -> 7", root.printMaxPath().toString());
    }

    @Test
    void leafsWithoutChildren5(){
        Node root2 = new Node(5);

        root2.setLeft(new Node(3));
        root2.setRight(new Node(7));

        root2.getLeft().setLeft(new Node(2));
        root2.getLeft().setRight(new Node(5));

        root2.getRight().setRight(new Node(0));
        root2.getRight().setLeft(new Node(1));

        root2.getRight().getRight().setLeft(new Node(2));
        root2.getRight().getRight().setRight(new Node(8));

        root2.getRight().getRight().getRight().setRight(new Node(5));

        assertEquals(5, root2.numberOfLastLeafs());
    }
    @Test
    void leafsWithoutChildren4(){
        Node root = new Node(5);
        root.setLeft(new Node(3));
        root.setRight(new Node(7));
        root.getRight().setRight(new Node(1));
        root.getRight().setLeft(new Node(1));
        root.getRight().getRight().setLeft(new Node(2));
        root.getRight().getRight().setRight(new Node(8));
        root.getRight().getRight().getRight().setRight(new Node(5));
        assertEquals(4, root.numberOfLastLeafs());
    }

}