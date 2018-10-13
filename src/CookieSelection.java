import java.util.ArrayList;
import java.util.Scanner;

public class CookieSelection {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        //TreeMap
        while(input.hasNextLine()) {
            String line = input.nextLine();
            if(line.equals("#")) {
                int diameter = CookieSelection.getMedian(list);
                System.out.println(diameter);
            }
            else {
                int diameter = Integer.parseInt(line);
                CookieSelection.insertSorted(list, diameter);
            }
        }
    }


    static void insertSorted(ArrayList<Integer> list, int diameter) {
        for(int i = 0; i < list.size(); i++)
        {
            if( list.get(i) > diameter)   {
                list.add(i, diameter);
                return;
            }
        }
        list.add(diameter);
    }

    static int getMedian(ArrayList<Integer> list) {
        boolean isEven = list.size() % 2 == 0;
        int index;
        if(isEven)
            index = (list.size() / 2) + 1;
        else
            index = (list.size() + 1) / 2;
        index--;
        return list.remove(index);
    }
}
//(c+1)/2 odd
// (c/2)+1  even
class TreeNode {
    private TreeNode left = new NullTreeNode();
    private TreeNode right = new NullTreeNode();
    private TreeNode parent = new NullTreeNode();

    public int value;

    public TreeNode(int value) {
        this.value = value;
    }
    public TreeNode() {}

    public int length() {
        int leftLength =  this.left.length();
        int rightLength = this.right.length();
        return leftLength + rightLength + 1;
    }
    public int leftLength() {
        return this.left.length();
    }
    public int rightLength() {
        return this.right.length();
    }
    public int getHeight() {
        return Math.max(this.left.getHeight(), this.right.getHeight()) + 1;
    }
    public void add(int value) {
        int rightLength = this.right.length();
        int leftLength = this.left.length();
        if(value > this.value) { // right
            if(this.left instanceof NullTreeNode) {
                this.left = new TreeNode(value);
            }
            else {
                if(this.right.getHeight() < this.left.getHeight()) { // left left case
                    TreeNode newNode = new TreeNode(value);
                    newNode.right = this;
                    newNode.left = this.left;
                    this.left = new NullTreeNode();

                }
                else {
                    this.left.add(value);
                }
            }
        }
        else { // left

        }

    }

    private void addLeft(int number) {
        if(this.left instanceof NullTreeNode) {

        }
    }

    private void addRight(int number) {

    }
}

class NullTreeNode extends TreeNode {
    public int length() {
        return 0;
    }
    public int leftLength() {
        return 0;
    }
    public int rightLength() {
        return 0;
    }
}
