package Tree_Interview_Questions_Part1_6.Balanced_Tree_Or_Not_2;

import com.sun.source.tree.Tree;

import java.util.Scanner;

public class Balanced_Optimised {

    Scanner sc = new Scanner(System.in);

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private TreeNode root;

    // Constructor of the Binary Tree
    public Balanced_Optimised () {

        this.root = Create_Binary_Tree ();
    }

    private TreeNode Create_Binary_Tree () {

        System.out.println("Enter the data : ");
        int data = sc.nextInt();
        TreeNode root = new TreeNode (data);

        System.out.println("Left of " + data + " ");
        boolean hasLeftNode = sc.nextBoolean();
        if (hasLeftNode == true) {

            root.left = Create_Binary_Tree();
        }

        System.out.println("Right of " + data + " ");
        boolean hasRightNode = sc.nextBoolean();
        if (hasRightNode == true) {

            root.right = Create_Binary_Tree();
        }

        return root;
    }

    public boolean isBalanced () {

        return isBalanced(root);
    }

    // TC : O(n)
    private Pair check (TreeNode root) {

        // Base Case
        if (root == null) {

            return new Pair();
        }

        Pair left = check (root.left);
        Pair right = check (root.right);

        boolean leftans = left.isbalance;
        boolean rightans = right.isbalance;

        int leftHeight = left.height;
        int rightHeight = right.height;

        boolean diff = Math.abs (leftHeight - rightHeight) <= 1;

        Pair ans = new Pair();

        if (leftans == true && rightans == true && diff == true) {

            ans.isbalance = true;
        } else {

            ans.isbalance = false;
        }

        int high = Math.max (leftHeight , rightHeight) + 1;
        ans.height = high;

        // Returning a pair of isBalanced and Height
        return ans;

    }

    private boolean isBalanced (TreeNode root) {

        Pair ans = check (root);

        return ans.isbalance;
    }

    class Pair {

        // When root == null
        boolean isbalance = true;
        int height = 0;

    }

}
