package Burn_a_Binary_Tree_3;

/*

Given a binary tree and a node data called target. Find the minimum time required to burn the complete binary tree if the target is set on fire. It is known that in 1 second all nodes connected to a given node get burned. That is its left child, right child, and parent.
Note: The tree contains unique values.


Example 1:

Input:
          1
        /   \
      2      3
    /  \      \
   4    5      6
       / \      \
      7   8      9
                   \
                   10
Target Node = 8
Output: 7
Explanation: If leaf with the value
8 is set on fire.
After 1 sec: 5 is set on fire.
After 2 sec: 2, 7 are set to fire.
After 3 sec: 4, 1 are set to fire.
After 4 sec: 3 is set to fire.
After 5 sec: 6 is set to fire.
After 6 sec: 9 is set to fire.
After 7 sec: 10 is set to fire.
It takes 7s to burn the complete tree.
Example 2:

Input:
          1
        /   \
      2      3
    /  \      \
   4    5      7
  /    /
 8    10
Target Node = 10
Output: 5


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(height of tree)


Constraints:
1 ≤ N ≤ 104


 */

import com.sun.source.tree.Tree;

import java.util.*;

public class burnBinaryTree {

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
    public burnBinaryTree () {

        this.root = Create_Binary_Tree ();
    }

    private TreeNode Create_Binary_Tree () {

        System.out.println("Enter the data : ");
        int data = sc.nextInt();
        TreeNode root = new TreeNode(data);

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

    // Create mapping.
    // and returns target.
   private TreeNode CreateParentMapping(TreeNode root , int target , Map <TreeNode, TreeNode> nodeToParent ){

            // Traget node
            TreeNode res = null;

            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);

            // Since root node has no parent i.e root node is mapped with NULL
            nodeToParent.put(root , null);

            while(! q.isEmpty()){
                TreeNode frontNode = q.peek();
                q.remove();

                if(frontNode.val == target){

                    // Lage haat target node bhi search ho gayi.
                    // res will store the target node.
                    res = frontNode;
                }

                if(frontNode.left != null){

                    //Mapping frontNode -> left with it's parent
                    nodeToParent.put(frontNode.left , frontNode);
                    q.add(frontNode.left);
                }

                if(frontNode.right != null){

                    //Mapping frontNode -> right with it's parent
                    nodeToParent.put(frontNode.right , frontNode);
                    q.add(frontNode.right);
                }

            }
            return res;
        }

    private int burnTree(TreeNode TargetNode , Map <TreeNode, TreeNode> nodeToParent ) {

        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(TargetNode);

        // Initially TargetNode is visited i.e store true means visited.
        visited.put(TargetNode, true);

        // Time to burn the tree
        int ans = 0;

        while (!q.isEmpty()) {

            boolean flag = false; // If flag changes to true it means node is burnt then increament the time.
            // Even, if a single node goes to the queue then it means that node is burnt and we do flag = true for that
            int Size = q.size();

            // We will run the loop till Size
            // We will burn all the neighbours of a node using for loop

            for (int i = 0; i < Size; i++) {

                TreeNode frontNode = q.peek();
                q.remove();

                // Burning frontNode -> left
                // If key is not found in the map then returns null here.
                // i.e if visited.get(frontNode) is not visited it means it is not putted in map and then it will return null instead of false here.

                /*
                   Returns: the value to which the specified key is mapped, or null if this map contains no mapping for the key

                 */
                if (frontNode.left != null && visited.get(frontNode.left) == null) {
                    flag = true;
                    q.add(frontNode.left);
                    visited.put(frontNode.left, true); // Marking frontNode -> left as true.

                }

                // Burning frontNode -> right
                if (frontNode.right != null && visited.get(frontNode.right) == null) {
                    flag = true;
                    q.add(frontNode.right);
                    visited.put(frontNode.right, true); // Marking frontNode -> right as true.

                }

                // Burning frontNode's parent also
                if (nodeToParent.get(frontNode) != null && visited.get(nodeToParent.get(frontNode)) == null) {

                    // nodeToParent.get(frontNode) ---> Gives us Parent of frontNode
                    flag = true;
                    q.add(nodeToParent.get(frontNode));
                    visited.put(nodeToParent.get(frontNode), true); // Marking frontNode's parent as visited
                }

            }

            if (flag == true) {
                ans++;
            }

        }

        return ans;
    }

    public int minTime () {

        System.out.println("Enter the Target node : ");
        int target = sc.nextInt();

        return minTime(root , target);
    }

    private int minTime(TreeNode root, int target) {

        // algo:
        // Step 1 : Create nodeToParent mapping
        // Step 2: Find Target node
        // Step 3: Burn the tree in min time.

        Map<TreeNode, TreeNode> nodeToParent = new HashMap<TreeNode, TreeNode>();

        // T.C --> for this is O(n)

        // This will create the mapping between node and it's parent node
        TreeNode TargetNode = CreateParentMapping(root, target, nodeToParent);

        // T.C --> for this is O(n)
        int ans = burnTree(TargetNode, nodeToParent);

        // Total time complexity is O(n)
        // Space complexity is O(n)
        return ans;
    }

}

// Input :

// 1 true 2 true 4 false false true 5 true 7 false false true 8 false false true 3 false true 6 false true 9 false true 10 false false
// Target : 8

class Solution {

    public static void main(String[] args) {

        burnBinaryTree tree = new burnBinaryTree();

        int ans = tree.minTime();

        System.out.println(ans);

    }
}
