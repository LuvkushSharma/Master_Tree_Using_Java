package Lec_3.Flatten_BST_to_a_Sorted_List_2;

/*

You have been given a Binary Search Tree (BST). Your task is to flatten the given
BST to a sorted list. More formally, you have to make a right-skewed BST from the
given BST, i.e., the left child of all the nodes must be NULL, and the value at the
right child must be greater than the current node.

A binary search tree (BST), also called an ordered or sorted binary tree, is a
rooted binary tree whose internal nodes each store a value greater than all the
values in the node's left subtree and less than those in its right subtree.

Sample Input 1
2
10 6 12 2 8 11 15 -1 -1 -1 -1 -1 -1 -1 -1
5 -5 8 -1 -1 -1 -1

Sample Output 1
2 -1 6 -1 8 -1 10 -1 11 -1 12 -1 15 -1 -1
-5 -1 5 -1 8 -1 -1

Explanation For Sample Input 1
For the first test case, the given BST is depicted below.

Ex_1_tree

Ex_1_LinkedLists

Sample Input 2
2
5 3 7 -1 -1 6 8 -1 -1 -1 -1
2 1 -1 -1 -1

Sample Output 2
3 -1 5 -1 6 -1 7 -1 8 -1 -1
1 -1 2 -1 -1

Ex_2_tree
Ex_2_LinkedLists

 */


/*

----------------- Approach - 1 ------------------

                              4
                           /    \
                          2      6
                        /   \  /   \
                       1     3 5    7

          1--->2--->3--->4--->5--->6--->7

  As we know that Inorder of BST is sorted.
  So, we'll store the inorder in an array.

  -------------------------------------------
  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |
  -------------------------------------------
     |
     V
     i = 0

  i = 0 : 1 par aa gaye toh uska left pointer null kardo and right pointer aagye waale par laga do.
  i = 1 : 2 par aa gaye toh uska left pointer null kardo and right pointer aagye waale par laga do.
    .
    .
    .
  i = 6 :  7 par aa gaye toh uska left pointer null kardo and saath hee right nhi null kar do.





 */

public class flattenBST_Client {

    public static void main(String[] args) {

        flattenBST tree = new flattenBST();

        tree.flattenBSTintoSorList();
    }
}
