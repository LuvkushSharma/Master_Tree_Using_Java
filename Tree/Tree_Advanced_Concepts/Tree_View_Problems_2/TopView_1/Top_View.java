package Tree_View_Problems_2.TopView_1;

/*

                                    Eye
                   __________________V____________________

                                     1
                                   /   \
                                  2     3
                                /  \   /  \
                               4    5 6    7


    Output :
                                     1
                                   /   \
                                  2     3
                                /        \
                               4          7




                                 4 2 1 3 7

*/

/*

Given below is a binary tree. The task is to print the top view of binary tree. Top view of a binary tree is the set of nodes visible when the tree is viewed from the top. For the given below tree

       1
    /     \
   2       3
  /  \    /   \
4    5  6   7

Top view will be: 4 2 1 3 7
Note: Return nodes from leftmost node to rightmost node. Also if 2 nodes are outside the shadow of the tree and are at same position then consider the extreme ones only(i.e. leftmost and rightmost).
For ex - 1 2 3 N 4 5 N 6 N 7 N 8 N 9 N N N N N will give 8 2 1 3 as answer. Here 8 and 9 are on the same position but 9 will get shadowed.

Example 1:

Input:
      1
   /    \
  2      3
Output: 2 1 3

Example 2:

Input:
       10
    /      \
  20        30
 /   \    /    \
40   60  90    100
Output: 40 20 10 30 100
Your Task:
Since this is a function problem. You don't have to take input. Just complete the function topView() that takes root node as parameter and returns a list of nodes visible from the top view from left to right.

Expected Time Complexity: O(NlogN)
Expected Auxiliary Space: O(N).

Constraints:
1 ≤ N ≤ 105
1 ≤ Node Data ≤ 105


 */

/*

------------------------- Approach -------------------------

First see the image.

---> So, if i have stored data of a node for any horizontal distance , already.
Like for <0> i.e. horizontal distance 0 i had stored 1. So, 5 and 6 will not be stored.

0 HD par 1 ne already mapping kar lii hain isliye 5 aur 6 ko ham map nhi karengye.
As woh 1 ke neeche hide ho jaayengye.

-----> Logic : Level Order Traversal
--------------> and One to One mapping ---> Map <Integer , Integer>

Agar koi node particular HD se map ho gayi hain toh bachi node uss HD se map nhi ho sakte.
i.e One to One mapping.


 */


import java.util.*;

public class Top_View {

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
    public Top_View() {

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

    public ArrayList ViewFromTop () {

        return ViewFromTop (root);
    }

    private ArrayList ViewFromTop (TreeNode root) {

        ArrayList<Integer> ans = new ArrayList<>();

        // Base Case
        if (root == null)
            return ans;

        // Mapping of HD (Horizontal Distance) and Node Value.
        // Taking treemap so that key-values will be stored in the sorted manner.
        // Since , -2 (hd) will be seen before as compare to -1 , 0 , 1 , 2.
        Map<Integer , Integer> topNode = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();

        Pair p = new Pair();

        // Pair will store the root node and it's hd
        p.node = root;
        p.hd = 0;
        q.add (p);

        while (!q.isEmpty()) {

            Pair temp = q.peek();
            q.remove();

            TreeNode frontNode = temp.node;
            int hd = temp.hd;

            // if one value is present for HD , then do nothing
            if (topNode.get(hd) == null) {

                topNode.put(hd , frontNode.val);
            }

            if (frontNode.left != null) {

                Pair pLeft = new Pair();
                pLeft.node = frontNode.left;
                pLeft.hd = hd - 1; // On going left hd decreases.

                q.add(pLeft);

            }

            if (frontNode.right != null) {

                Pair pRight = new Pair();
                pRight.node = frontNode.right;
                pRight.hd = hd + 1; // On going right hd increases

                q.add(pRight);
            }
        }

        System.out.println(topNode);

        // Values in the map represents Node values that are visible from the top.
        for (int i : topNode.values()) {

            ans.add(i);
        }

        return ans;
    }

    class Pair {

        TreeNode node;
        int hd;
    }
}
