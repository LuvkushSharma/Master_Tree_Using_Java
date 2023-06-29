package Tree_View_Problems_2.Left_View_3;

/*

                |
                |                      1
                |                   /    \
            Eye <                  2       5
                |                /  \       \
                |               3    4        6
                |                     \        \
                |                      7        8
                |                                 \
                |                                  9


    Output :
    1 2 3 7 9

    Logic :

    Har ek level par jo pehli node aa rahi hain bas usse print karaana hain
    level - 0 : Par pehli node 1 hain
    level - 1 : Par pehli node 2 hain
    level - 2 : Par pehli node 3 hain
    level - 3 : Par pehli node 7 hain
    level - 4 : Par pehli node 9 hain

    So, we will track the level also.

    if (level == ans.size()) ------> Means we had entered to a new level


 */


import java.util.ArrayList;
import java.util.Scanner;

public class Left_View {

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
    public  Left_View () {

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

    public ArrayList<Integer> ViewFromLeft () {

        return ViewFromLeft (root);
    }

    private void solve (TreeNode root , ArrayList<Integer> ans , int level) {

        // Base Case
        if (root == null) {
            return;
        }

        // We entered a new level
        if (level == ans.size())
            ans.add (root.val);

        solve (root.left , ans , level + 1);
        solve (root.right , ans , level + 1);
    }

    // So, we will solve this problem using Recursion.
    // This problem can be solved by Level Order Traversal but to write concise code we'll use Recursion this time.
    private ArrayList<Integer> ViewFromLeft (TreeNode root) {

         ArrayList<Integer> ans = new ArrayList<>();

         solve (root , ans , 0);
         return ans;
    }
}
