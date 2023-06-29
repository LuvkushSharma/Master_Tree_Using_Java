package Tree_View_Problems_2.BottomView_2;

/*


                                      1
                                   /     \
                                  2       4
                                /  \     /  \
                               3    \   /    7
                                     5 /
                                      6


                   __________________V____________________
                                    Eye

    Output :
    3 2 6 4 7

    Logic :

    Update the value of the key when Ever key comes again i.e <0> is updated to 5 and at the end it is updated to 6

    <0> ---> 1
    <-1> ---> 2
    <1> ---> 4
    <-2> ---> 3
    <0> ---> 5
    <2> ---> 7
    <0> ---> 6

    <-2> <-1> <0> <1> <2>
      3   2    6   4   7


    i.e. 1 and 5 will be hide by 6.

*/

/*

Given a binary tree, print the bottom view from left to right.
A node is included in bottom view if it can be seen when we look at the tree from bottom.

                      20
                    /    \
                  8       22
                /   \        \
              5      3       25
                    /   \
                  10    14

For the above tree, the bottom view is 5 10 3 14 25.
If there are multiple bottom-most nodes for a horizontal distance from root, then print the later one in level traversal. For example, in the below diagram, 3 and 4 are both the bottommost nodes at horizontal distance 0, we need to print 4.

                      20
                    /    \
                  8       22
                /   \     /   \
              5      3 4     25
                     /    \
                 10       14

For the above tree the output should be 5 10 4 14 25.

Note: The Input/Output format and Example given are used for the system's internal purpose, and should be used by a user for Expected Output only. As it is a function problem, hence a user should not read any input from the stdin/console. The task is to complete the function specified, and not to write the full code.


Example 1:

Input:
       1
     /   \
    3     2
Output: 3 1 2
Explanation:
First case represents a tree with 3 nodes
and 2 edges where root is 1, left child of
1 is 3 and right child of 1 is 2.

------- Img --------

Thus nodes of the binary tree will be
printed as such 3 1 2.

Example 2:

Input:
         10
       /    \
      20    30
     /  \
    40   60
Output: 40 20 60 30
Your Task:
This is a functional problem, you don't need to care about input, just complete the function bottomView() which takes the root node of the tree as input and returns an array containing the bottom view of the given tree.

Expected Time Complexity: O(N*logN).
Expected Auxiliary Space: O(N).

Constraints:
1 <= Number of nodes <= 105
1 <= Data of a node <= 105



 */

/*

----------------- Approach ----------------

Simple traverse karo :

     corresponding
<0> --------------> 1

     corresponding
<-1> --------------> 2

     corresponding
<1> --------------> 4

     corresponding
<-2> --------------> 3

     corresponding
<0> --------------> 5

     corresponding
<2> --------------> 7

     corresponding
<0> --------------> 6

i.e 1:1 Mapping rahegyi but agar Same HD par ek aur value aa rahi hain toh simply
usse puuraani waali se replace kardo. Because it will hide the previous value at that particular hd.

 */

import java.util.*;

public class Bottom_View {

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
    public  Bottom_View () {

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

    public ArrayList<Integer> ViewFromBottom () {

        return ViewFromBottom (root);
    }

    private ArrayList ViewFromBottom (TreeNode root) {

        ArrayList<Integer> ans = new ArrayList<>();

        // Base Case
        if (root == null)
            return ans;

        // Mapping of HD (Horizontal Distance) and Node Value.
        Map<Integer , Integer> bottomNode = new TreeMap<>();

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

            // Koi Condition mat lagaao simply uss particular hd ke correspond value update karte raho
            // It simply Overwrite the value corresponding to hd.
            bottomNode.put(hd , frontNode.val);


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

        // Values in the map represents Node values that are visible from the top.
        for (int i : bottomNode.values()) {

            ans.add(i);
        }

        return ans;
    }

    class Pair {

        TreeNode node;
        int hd;
    }
}
