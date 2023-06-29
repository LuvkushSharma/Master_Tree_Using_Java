package Lec_3.Build_BST_From_Preorder_4;

/*

Given an array of integers preorder, which represents the preorder traversal of a
BST (i.e., binary search tree), construct the tree and return its root.

It is guaranteed that there is always possible to find a binary search tree with
the given requirements for the given test cases.

A binary search tree is a binary tree where for every node, any descendant of Node.
left has a value strictly less than Node.val, and any descendant of Node.right has a value strictly greater than Node.val.

A preorder traversal of a binary tree displays the value of the node first, then
traverses Node.left, then traverses Node.right.

Example 1:


Input: preorder = [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]

Example 2:

Input: preorder = [1,3]
Output: [1,null,3]


Constraints:

1 <= preorder.length <= 100
1 <= preorder[i] <= 1000
All the values of preorder are unique.


 */

/*

------------------------ Approach - 1 ------------------------

Ex : [ 20 , 10 , 5 , 15 , 13 , 35 , 30 , 42]

                       20
                    /     \
                   10      35
                /     \  /    \
               5      15 30    42
                    /
                   13

     Initially root == null thaa usme 20 insert kar diya.

     Fir hamne 10 , 20 se puucha kaha bheju 10 ko toh usne bola left

     Fir 5 aya toh 20 ne bola left fir 10 ne bhi bola left.

     Har ek node ke liye ham puuchte chalengye

     i.e TC : O(n^2)


--------------------- Approach - 2 --------------------

Preorder given hain and we can also find Inorder.

Since , inorder of BST is the sorted form of PreOrder.

[ 20 , 10 , 5 , 15 , 13 , 35 , 30 , 42] --------> PreOrder

[5 , 10 , 13 , 15 , 20 , 30 , 35 , 42] ------> Inorder

And we know that how to make a tree from Inorder and PreOrder

TC : O(nlogn)

------------------- Approach - 3 ------------------------

PreOrder :   N        L       R
             |        |       |
            root     Left    Right

   0    1   2    3   4    5    6    7
[ 20 , 10 , 5 , 15 , 13 , 35 , 30 , 42]


We will use the intuition that we had used while approaching isBST problem.

Initially range is (-infinity , infinity) i.e [Integer.MIN_VALUE , Integer.MAX_VALUE]

Step-1 : Is 20 lies in the range (-infinity , infinity)

                          20 (-inf , inf)
                        /
                  (-inf , 20)

Step-2 : Kya 10  (-inf , 20) main lie karta hain -------> Yes

                        20 (-inf , inf)
                        /
                      10  (-inf , 20)
                     /
                    (-inf , 10)

Step-3 : Kya 5  (-inf , 10) main lie karta hain -------> Yes

                        20 (-inf , inf)
                        /
                      10  (-inf , 20)
                     /
                    5  (-inf , 10)
                   /
                 (-inf , 5)

Step-4 : Kya 15  (-inf , 5) main lie karta hain -------> No

                        20 (-inf , inf)
                        /
                      10  (-inf , 20)
                     /
                    5  (-inf , 10)
                   /
                 (-inf , 5)

             Simply return null

                         20 (-inf , inf)
                        /
                      10  (-inf , 20)
                     /
                    5  (-inf , 10)
                   /  \
        (-inf , 5)    (5 , 10)

        Kya 15 (5,10) main lie karta hain --------> No

        return null

                         20 (-inf , inf)
                        /
                      10  (-inf , 20)
                     /  \
                    5    (10 , 20)
                   /  \
        (-inf , 5)    (5 , 10)

        Kya 15 (10,20) main lie karta hain --------> Yes

                         20 (-inf , inf)
                        /
                      10  (-inf , 20)
                     /  \
                    5    15
                   /  \  /
              null null (10,15)


Step-5 : Kya 13 (10,15) range main lie karta hain -------> Yes

                         20 (-inf , inf)
                        /   \
                      10    (20 , inf)
                     /  \
                    5    15
                   /  \  /
              null null  13
                        /
                       (10,13)

Step-6 : Kya 35 (10,13) range main lie karta hain --------> No
         So, return null

         Kya 35 (20 , inf) range main lie karta hain --------> Yes

                       20 (-inf , inf)
                        /   \
                      10    35
                     /  \   /
                    5    15 (20 , 35)
                   /  \  /
              null null  13



Step-7 : Kya 30 (20,35) ke beeh main atta hain ------> Yes


                          20 (-inf , inf)
                        /   \
                      10    35
                     /  \   /  \
                    5    15 30  (35 , inf)
                   /  \  /  /  \---------> (30 , 35)
              null null  13 (20 , 30)


Step-8 : Kya 42 (20,30) ke beeh main atta hain ------> No
         Kya 42 (30,35) ke beeh main atta hain ------> No

         Kya 42 (35 , inf) ke beeh main atta hain ------> Yes


                          20
                      /       \
                   10          35
                 /   \       /    \
                5    15     30     42
                    /
                  13

 We had visited each thrice i.e O(3n) ~ O(n)

 */

// Note : We can optimise the above approach by not taking mini. i.e only with the help of maxi we can solve the problem.


public class buildBST_Client {

    public static void main(String[] args) {

        buildBSTfromPreorder tree = new buildBSTfromPreorder();

        tree.buildBST ();
    }
}
