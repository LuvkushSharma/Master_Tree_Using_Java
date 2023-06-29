package Lec_5;

// Input - 1:
// 5 true 2 true 1 false false true 3 false false true 4 false false

// 5 true 2 true 1 false false true 3 false false true 6 false false

// TC : O(n) ------> using Approach-2

public class largestBST_Client {

    public static void main(String[] args) {

        Largest_BST_in_a_Binary_Tree tree = new Largest_BST_in_a_Binary_Tree();

        int ans = tree.largestBST();
        System.out.println(ans);
    }
}
