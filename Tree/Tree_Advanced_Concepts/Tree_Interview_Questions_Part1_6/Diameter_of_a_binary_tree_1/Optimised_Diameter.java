package Tree_Interview_Questions_Part1_6.Diameter_of_a_binary_tree_1;

import java.util.Scanner;

public class Optimised_Diameter {

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
    public Optimised_Diameter () {

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

    public int getDiameter () {

        return getDiameter(root);
    }

    private Pair solve (TreeNode root) {

        // Base Case
        if (root == null) {

            // <0 , 0>
            return new Pair();
        }

       Pair left  = solve (root.left);
       Pair right  = solve (root.right);

       int opt1 = left.diameter;
       int opt2 = right.diameter;

       int opt3 = left.height + 1 + right.height;

       int dia = Math.max (opt1 , Math.max (opt2 , opt3));
       int high = Math.max (left.height , right.height) + 1;

       Pair ans = new Pair();
       ans.diameter = dia;
       ans.height = high;

       // returning the pair
       return ans;
    }

    private int getDiameter (TreeNode root) {

        Pair ans = solve (root);

        return ans.diameter;
    }

    class Pair {

        int diameter = 0;
        int height = 0;
    }

}
