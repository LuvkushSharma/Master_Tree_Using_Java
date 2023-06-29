package Tree_Traversals_1.Level_Order_Traverse_1;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Binary_Tree {

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
        public Binary_Tree () {

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

        public void LevelOrderTraversal () {

            LevelOrderTraversal(root);
        }

        private void LevelOrderTraversal (TreeNode root){

            // We do this using BFS (Breadth first search) where we use queue data structure.
            Queue<TreeNode> q = new LinkedList<>();

            q.add(root); // Inserting root node in the queue

            // For printing different level data on different line we will push NULL which shows that
            // now, we want the new line.
            q.add(null); // As a separator for levels

            while (!q.isEmpty()) {

                TreeNode temp = q.peek();
                q.remove();

                // This if used for printing each level on the separate line
                // Matlab puuraana level completely traversed ho chuuka hain.
                if (temp == null) { // old level completely traversed

                    System.out.println();

                    if (!q.isEmpty()) { // queue still have some child nodes
                        q.add(null);
                    }

                } else {

                    // This the code for the level Order Traversal.
                    System.out.print (temp.val + " ");

                    if (temp.left != null)
                    { // If left child is not NULL
                        q.add(temp.left);
                    }

                    if (temp.right != null)
                    {
                        q.add(temp.right);
                    }
                }
            }
        }
}

// Input :
// 1 true 3 true 7 false false true 11 false false true 5 true 17 false false false





