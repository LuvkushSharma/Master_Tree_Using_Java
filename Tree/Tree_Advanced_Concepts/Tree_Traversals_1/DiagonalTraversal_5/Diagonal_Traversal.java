package Tree_Traversals_1.DiagonalTraversal_5;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*

Given a Binary Tree, print the diagonal traversal of the binary tree.

Consider lines of slope -1 passing between nodes. Given a Binary Tree, print all diagonal elements
in a binary tree belonging to same line.
If the diagonal element are present in two different subtrees then left subtree diagonal element
should be taken first and then right subtree.

Example 1:

Input :
            8
         /     \
        3      10
      /   \      \
     1     6     14
         /   \   /
        4     7 13
Output : 8 10 14 3 6 7 13 1 4
Explanation:

----- Img -----

Diagonal Traversal of binary tree :
8 10 14 3 6 7 13 1 4

Your Task:
You don't need to read input or print anything. The task is to complete the function diagonal() that takes the root node as input argumets and returns the diagonal traversal of the given tree.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).
Here N is number of nodes.

Constraints:
1 <= Number of nodes<= 105
1 <= Data of a node<= 105




 */

public class Diagonal_Traversal {

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
    public  Diagonal_Traversal () {

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

    public ArrayList<Integer> traverseDiagonally () {

        return traverseDiagonally (root);
    }

    private ArrayList<Integer> traverseDiagonally (TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();

        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null)
            return ans;

        q.add(root);

        while (!q.isEmpty()) {

            TreeNode frontNode = q.peek();
            q.remove();

            // right main jaate raho jab tak null naa mil jaaye
            while (frontNode != null) {

                // and if left exists karta hain toh usse Queue main daal do because
                // ye next diagonal ko start karega.
                if (frontNode.left != null) {

                    q.add(frontNode.left);
                }

                ans.add(frontNode.val);
                frontNode = frontNode.right; // move to right
            }
        }

        return ans;
    }
}
