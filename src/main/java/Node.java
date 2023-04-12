import java.io.PrintStream;
import java.util.ArrayList;

public class Node {
    private int value;
    private Node left;
    private Node right;
    private static int maxLvl;
    private static ArrayList<Node> result;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }


    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public int findMaxLevel(){
        maxLvl = 0;
        return this.DFS(0).size();
    }
    private ArrayList<Node> findMaxPath(){
        maxLvl = 0;
        return this.DFS(0);
    }
    public StringBuilder printMaxPath(){
        ArrayList<Node> maxPath = this.findMaxPath();
        int n = maxPath.size();
        StringBuilder sb = new StringBuilder();
        sb.append(maxPath.get(n - 1).getValue());
        for(int i = n - 2; i >= 0; i--)
        {
            sb.append(" -> ").append(maxPath.get(i).getValue());
        }
        return sb;
    }

    private ArrayList<Node> DFS(Integer level){
        level++;
        ArrayList<Node> right = new ArrayList<>();
        ArrayList<Node> left = new ArrayList<>();
        if(level > maxLvl) {
            maxLvl = level;
        }
        if(this.left != null)
            left = this.left.DFS(level);
        if(this.right != null)
            right = this.right.DFS(level);
        level--;
        if(right.size() < left.size())
            left.add(this);
        else
            right.add(this);
        return (left.size() > right.size()) ? left : right;
    }

    public int numberOfLastLeafs(){
        result = new ArrayList<>();
        return this.leafsWoCh().size();
    }
    private ArrayList<Node> leafsWoCh(){
        if(this.right != null)
            this.right.leafsWoCh();
        if(this.left != null)
            this.left.leafsWoCh();
        if(this.left == null && this.right == null)
            result.add(this);
        return result;
    }
    public StringBuilder printLeafs(){
        result = new ArrayList<>();
        ArrayList<Node> lWC = this.leafsWoCh();
        int m = lWC.size();
        StringBuilder l = new StringBuilder();
        l.append("There is ").append(m).append(" leafs without children (");
        l.append(lWC.get(0).getValue());
        for(int i = 1; i < m; i++){
            l.append(", ").append(lWC.get(i).getValue()) ;
        }
        l.append(")");
        return l;
    }
    public Boolean check(Node bst){
        return checker(this, bst);
    }

    private Boolean checker(Node bst, Node bst1){
        if(bst == null && bst1 == null) return true;
        else if(bst != null && bst1 != null){
            if(bst.value == bst1.value)
                return checker(bst.right, bst1.right) && checker(bst.left, bst1.left);
        }
        return false;

    }
    private void traversePreOrder(StringBuilder sb, String padding, String pointer, Node node) {
        if (node != null) {
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.getValue());
            sb.append("\n");

            String paddingForBoth = padding + "│  ";
            String pointerForRight = "└──";
            String pointerForLeft = (node.getRight() != null) ? "├──" : "└──";

            traversePreOrder(sb, paddingForBoth, pointerForLeft, node.getRight());
            traversePreOrder(sb, paddingForBoth, pointerForRight, node.getLeft());
        }
    }
    public void print(PrintStream os) {
        StringBuilder sb = new StringBuilder();
        traversePreOrder(sb, "", "", this);
        os.print(sb);
    }
}
