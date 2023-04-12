public class Main {
    public static void main(String[] args) {
        //Example instance of node class
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
        //Example instance of node class to compare
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

        root.print(System.out);
        root2.print(System.out);
        System.out.println(root.check(root2) ? "They are the same" : "They are different");
        System.out.println("The maximum depth is: " + root.findMaxLevel());
        System.out.println("The path to deepest node is: " + root.printMaxPath());
        System.out.println("The number of leafs without children is: " + root.numberOfLastLeafs());
    }
}