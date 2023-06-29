package Tree_View_Problems_2.RightView_4;

/*

                                                                     |
                                       1                             |
                                    /    \                           |
                                   2       5                         |
                                 /  \       \                        > Eye
                                3    4        6                      |
                                      \        \                     |
                                       7        8                    |
                                                  \                  |
                                                   9                 |
                                                                     |

    Output :
    1 5 6 8 9

    Logic :

    Har ek level par jo last node aa rahi hain bas usse print karaana hain
    level - 0 : Par last node 1 hain
    level - 1 : Par last node 5 hain
    level - 2 : Par last node 6 hain
    level - 3 : Par last node 8 hain
    level - 4 : Par last node 9 hain


 */


import java.util.ArrayList;
import java.util.Scanner;

public class Right_View {

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
    public Right_View () {

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

    public ArrayList<Integer> ViewFromRight () {

        return ViewFromRight (root);
    }

    private void solve (TreeNode root , ArrayList<Integer> ans , int level) {

        // Base Case
        if (root == null) {
            return;
        }

        // We entered a new level
        if (level == ans.size())
            ans.add (root.val);

        // Call the right call before left call
        solve (root.right , ans , level + 1);
        solve (root.left , ans , level + 1);

    }

    private ArrayList<Integer> ViewFromRight (TreeNode root) {

        ArrayList<Integer> ans = new ArrayList<>();

        solve (root , ans , 0);
        return ans;
    }
}
