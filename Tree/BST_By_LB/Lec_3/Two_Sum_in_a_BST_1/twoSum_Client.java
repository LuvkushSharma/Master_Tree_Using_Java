package Lec_3.Two_Sum_in_a_BST_1;

/*

You have been given a Binary Search Tree and a target value.
You need to find out whether there exists a pair of node values in the BST,
such that their sum is equal to the target value.

A binary search tree (BST), also called an ordered or sorted binary tree,
is a rooted binary tree whose internal nodes each store a value greater than all
the values keys in the node's left subtree and less than those in its right subtree.

Sample Input 1:
1
10 6 12 2 8 11 15 -1 -1 -1 -1 -1 -1 -1 -1
14

Ex_1.png

Output
true

Explanation for testcase-1
For the first test case, the sum of the nodes with values 2 and 12 equals the
target value.

Sample Input 2:
1
5 3 7 -1 -1 6 8 -1 -1 -1 -1
20

Ex_2.png

Sample Output 2:
False

Explanation For Sample 2:
For the first test case, there is no such pair of nodes, the sum of which equals the target value.


 */

/*

                              10
                            /    \                     Target = 20
                          6        12
                       /     \   /     \
                      2       8 11     15

                      so, {8 , 12} is the pair which sum to 20.
                      i.e. ans = true

       ----------------- Approach - 1 ------------- (Brute Force)

       Pehle maine 10 pakad liya fir (Target - 10) ko search kiya.
       Similarly if we take 6 then we'll find (Traget - 6).

       TC : O(n^2) ----> in case of skew tree


       -------------- Approach - 2 ----------------

       As we know that Inorder of BST is sorted

       ---> First Traversal
       And doing so will take TC : O(n) and SC : O(n)
       i.e   2 ,  6  , 8  , 10  , 12  , 11  , 15

       ---> Next Traversal
       ek pointer i place kar dia 2 par and ek pointer 15 par laga diya.
       and apply two pointer theorem.


 */

public class twoSum_Client {

    public static void main(String[] args) {

        twoSum tree = new twoSum();

        System.out.println("Enter the target : ");
        int target = tree.sc.nextInt();

        boolean ans = tree.isTwoSum (target);

        System.out.println(ans);
    }
}
