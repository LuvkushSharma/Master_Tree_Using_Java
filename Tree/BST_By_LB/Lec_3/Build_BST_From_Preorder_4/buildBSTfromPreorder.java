package Lec_3.Build_BST_From_Preorder_4;

import java.util.ArrayList;
import java.util.Scanner;

public class buildBSTfromPreorder {

    Scanner sc = new Scanner(System.in);

    class TreeNode {

        int data;
        TreeNode left;
        TreeNode right;

        // Constructors
        public TreeNode () {

        }

        public TreeNode (int val) {

            this.data = val;

        }
    }

    private TreeNode root;

    // Constructor
    public buildBSTfromPreorder () {

        takePreorder ();
    }

    // ---------------- Taking Preorder from User ------------------

    private ArrayList<Integer> preorder = new ArrayList<>();

    private void takePreorder () {

        System.out.println("Enter the elements of preorder : ");

        int val = sc.nextInt();

        while (val != -1) {

            preorder.add (val);
            val = sc.nextInt();
        }
    }

    // ---------------- Making BST from Preorder -------------------

    public void buildBST (){

          this.root = buildBST (preorder);
    }

    // Index pointing to the Preorder ArrayLists
    private int idx = 0;

    private TreeNode solve (ArrayList<Integer> preorder , int mini , int maxi) {

        // Array se bahaar nikal gaye return kardo
        if (idx >= preorder.size()) {
            return null;
        }

        // Range se bahaar nikal gaye
        if (preorder.get(idx) < mini || preorder.get(idx) > maxi) {

            return null;
        }

        // Range main lie karte hain
        TreeNode root = new TreeNode(preorder.get(idx)); // ---> 20

        idx += 1;

        //      20
        //    /
        //  (-inf , 20)
        root.left = solve (preorder , mini , root.data);

        //      20
        //         \
        //        (20 , inf)
        root.right = solve (preorder , root.data , maxi);

        return root;
    }

    private TreeNode buildBST (ArrayList<Integer> preorder) {

        int mini = Integer.MIN_VALUE;
        int maxi = Integer.MAX_VALUE;

        return solve (preorder , mini , maxi);
    }
}
