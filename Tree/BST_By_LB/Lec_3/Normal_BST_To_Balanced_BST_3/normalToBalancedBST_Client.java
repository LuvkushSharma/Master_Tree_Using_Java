package Lec_3.Normal_BST_To_Balanced_BST_3;

/*

You have been given a binary search tree of integers with ‘N’ nodes.
Your task is to convert it into a balanced BST with the minimum height possible.

A Balanced BST is defined as a BST, in which the height of two subtrees of every
node differs no more than 1.

Input:
       30
      /
     20
    /
   10
Output:
     20
   /   \
 10     30


Input:
         4
        /
       3
      /
     2
    /
   1
Output:
      3            3           2
    /  \         /  \        /  \
   1    4   OR  2    4  OR  1    3   OR ..
    \          /                   \
     2        1                     4


Input:
          4
        /   \
       3     5
      /       \
     2         6
    /           \
   1             7
Output:
       4
    /    \
   2      6
 /  \    /  \
1    3  5    7


 */

/*

--------------------------- Approach ------------------------

For every node :

condtion = Math.abs (height[left] - height[right]) <= 1


                         50
                      /      \
                     30       60
                  /     \       \
                 20     40       70
                                  \
                                   80

Go to left till 20 as usual.

Step-1 : 20.left will give 0 , similarly 20.right will return 0. And condition = true.
         So, return a pair of height and isBalanced
         {1 , T}

Step-2 : 30 will call to right. and 40 will also return {1 , true}

Step-3:
                       30
                     /    \
       {1 , true}  20      40 {1 , true}

       For 30 also condition is true i.e Math.abs (height[left] - height[right]) <= 1
       So, return {2 , true}
       Where 2 is the height of subtree having root as 30.


Step-4: 50 will call to it's right i.e. 60
        then 60 call to left and that returns {0 , true}
        Now 60 calls to it's right.

Step-5: 70 will call to it's left and that returns {0 , true}
        Now 70 calls to it's right.

Step-6: 80 will call to it's left and that returns {0 , true}
        and 80 will call to it's right which also returns {0 , true}

        i.e 80 returns {1 , true} ---> true because for 80 condition is true.
        Similarly , for 70
        condition = Math.abs (0 - 1) <= 1 ---> true
        So, 70 will return {2 , true}

        Now , for   60
                  /    \
               {0,true} {2,true}

               so, condition = | 0 - 2 | <= 1 -----> false

               so, it will return {3 , false}

         and
                     50
                  /      \
              {2,true}   {3,false}

              i.e return {4,false}

  ------------------------ Intuition --------------------

  As we all know that Inorder Traversal of BST is sorted.

Step-1 :  -----> Save the Inorder of the above BST :

     0     1     2     3      4      5      6
  ----------------------------------------------
  |  2  |  4  |  8  |  10  |  12  |  16  |  20 |
  ----------------------------------------------

Step-2 :   mid = 3

  at mid we have 10. Store 10 in a node.

Step-3 :   And make 2,4,8 as the left of 10 amd 12,16,20 as the right portion of 10

  i.e.               10
                 /        \
           {2,4,8}        {12,16,20}

 */

// TC : O(n)

public class normalToBalancedBST_Client {

    public static void main(String[] args) {

        normalToBalanced tree = new normalToBalanced();
    }
}
