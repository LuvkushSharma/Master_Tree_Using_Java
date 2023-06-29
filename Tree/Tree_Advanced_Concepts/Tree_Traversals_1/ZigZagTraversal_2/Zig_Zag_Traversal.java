package Tree_Traversals_1.ZigZagTraversal_2;

/*

Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
(i.e., from left to right, then right to left for the next level and alternate between).

Example 1:

Zig_Zag.img

Example 1:

Input:
        1
      /   \
     2     3
    / \   /  \
   4   5 6    7
Output:
1 3 2 4 5 6 7

Example 2:

Input:
           7
        /     \
       9       7
     /  \     /
    8    8   6
   /  \
  10   9
Output:
7 7 9 8 8 6 9 10


Constraints:
1 <= N <= 10^4

 */

/*

-----------------------  Approach ----------------------------


            Spiral Traversal or Zig-Zag traversal

            L-R
            R-L
            L-R...

                            1
                         /     \
                        2       4
                      /   \       \
                     3     5       6
                                 /   \
                                7     8

                Output : 1 4 2 3 5 6 8 7

We use the flag : first We traverse left-right so flag = true for this and when left to right traversal is finished then change the direction of the flag
Now for level-2 we traverse right-left as flag = false and after traversal change the flag to true again.



 */



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Zig_Zag_Traversal {

    Scanner sc = new Scanner(System.in);

    // Node of a tree
    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        // Constructor for a Node
        public TreeNode (int val) {

            this.val = val;
        }

    }

    private TreeNode root;

    // Constructor for tree
    public Zig_Zag_Traversal () {

        this.root = Build_Binary_Tree ();
    }

    private TreeNode Build_Binary_Tree () {

        System.out.println("Enter the data : ");
        int data = sc.nextInt();

        TreeNode root = new TreeNode(data);

        boolean hasLeftNode = sc.nextBoolean();
        if (hasLeftNode == true) {

            root.left = Build_Binary_Tree();
        }
        boolean hasRightNode = sc.nextBoolean();
        if (hasRightNode == true) {

            root.right = Build_Binary_Tree();
        }

        return root;
    }

    public ArrayList<Integer> zigZagTraversal () {

        return zigZagTraversal(root);
    }

    //Function to store the zig zag order traversal of tree in a list.
    private ArrayList<Integer> zigZagTraversal(TreeNode root)
    {
        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null) {

            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        boolean leftToRight = true;

        while (!q.isEmpty()) {

            int size = q.size();
            int temp[] = new int[size];

            // Process each level
            for (int i = 0 ; i < size ; i++) {

                // Getting the front node
                TreeNode FrontNode = q.peek();
                q.remove();

                // Normal insert or reverse insert
                int index = leftToRight ? i : size - i - 1; // if leftToRight is false then go
                //in reverse order i.e size - i - 1; else go in linear form i.e i

                temp[index] = FrontNode.val; // Storing value in the temp array.

                if(FrontNode.left != null){
                    q.add(FrontNode.left);
                }

                if(FrontNode.right != null){
                    q.add(FrontNode.right);
                }

            }

            // Direction change
            leftToRight = ! leftToRight; // If LeftToRight was true then negate this and make false else make true.

            for(int value : temp){

                ans.add(value);
            }

        }

        return ans;
    }
}



