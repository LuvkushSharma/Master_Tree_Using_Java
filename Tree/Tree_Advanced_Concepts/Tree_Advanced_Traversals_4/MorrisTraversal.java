package Tree_Advanced_Traversals_4;

import com.sun.source.tree.Tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class MorrisTraversal {

    Scanner sc = new Scanner(System.in);

    // Node class for the tree
    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode (int val) {
            this.val = val;
        }
    }

    private TreeNode root;

    // Constructor for tree
    public MorrisTraversal () {

        this.root = BuildTree ();
    }

    private TreeNode BuildTree () {

        System.out.println("Enter the data : ");
        int data = sc.nextInt();

        TreeNode root = new TreeNode (data);

        boolean hasLeftChild = sc.nextBoolean();

        if (hasLeftChild == true) {

            root.left = BuildTree ();
        }

        boolean hasRightChild = sc.nextBoolean();
        if (hasRightChild == true) {

            root.right = BuildTree ();
        }

        return root;
    }

    public ArrayList<Integer> traversal () {

        return traversal(root);
    }

    private ArrayList<Integer> traversal (TreeNode root) {

        ArrayList<Integer> ans = new ArrayList<>();

        // Initially : currrent = root;
        TreeNode current = root;

        while (current != null) {

            // if left not exists
            if (current.left == null) {

                ans.add (current.val);
                current = current.right;

            } else {

                TreeNode pred = Predecessor(current);

                // Temporary Link Creation
                if (pred.right == null) {

                    pred.right = current;
                    current = current.left;

                } else { // Remove temporary Links

                    pred.right = null;
                    ans.add(current.val);
                    current = current.right;
                }
            }
        }


        return ans;
    }

    private TreeNode Predecessor (TreeNode current) {

        // For finding Predecessor
        //  1. Go to the left of the given node.
        //  2. Go to the right till we donot get null.

        TreeNode temp = current.left;

        // When root.right == null then return that and
        // if root.right == current then return that for ex. in the example 5.right becomes 1 i.e curr
        // and in this case this while loop will run for infinite times i.e mentioned this condition also.
        while (temp.right != null && temp.right != current) {

            temp = temp.right;
        }

        return temp;
    }

}
