package Lec_5;

/*

Given a binary tree. Find the size of its largest subtree that is a Binary Search Tree.
Note: Here Size is equal to the number of nodes in the subtree.

If the complete Binary Tree is BST, then return the size of the whole tree.

Example :

Input:
      5
    /  \
   2    4
 /  \
1    3

Output: 3
The following subtree is the
maximum size BST subtree
   2
 /  \
1    3


Input:
       50
     /    \
  30       60
 /  \     /  \
5   20   45    70
              /  \
            65    80
Output: 5
The following subtree is the
maximum size BST subtree
      60
     /  \
   45    70
        /  \
      65    80


 */


/*

           Example - 1:

                                  1
                               /     \
                              2       3
                            /       /   \
                           4       5     6
                             \
                               7

            BST's :

            1.  7

            2.   4
                   \
                     7

           3.   5

           4.   6

           so, ans = 2



           Example - 2

                                  5
                               /     \
                              2       4
                            /   \
                           1     3

             BST's :

             1.    1

             2.    3

             3.    4

             4.    2
                 /   \
                1     3


                ans = 3


 */

/*

-------------------- Approach - 1 ------------------------

---> Reach each node and check whether it makes a valid BST or not. If yes then store
     it's size.

     We had already written the code of checking a valid BST. And it's TC : O(n)

     so, for n nodes it's TC : O(n^2)


---------------- Approach - 2 -----------------------

                                  5
                               /     \
                              2       6
                            /   \
                           1     3

 Rather than going and checking whether above tree is BST or not. We will check :

 1. Whether it's left subtree is BST or not which we had checked already. O(1)

 2. Whether it's right subtree is BST or not which we had checked already. O(1)

 3. root.data should be greater than the max of left. Similarly root.data should be less than the min of right part.


 i.e Hamaare pass har ek subtree kaa max and min patah hona chaiye , ek isValid hona chaiye.

 And size bhi hona chaiye.


 ------------------ Dry Run of Approach - 2 -------------

                                  5
                               /     \
                              2       4
                            /   \
                           1     3

              Step - 1 : left-left jaate jaate ham 1 par pahoch gaye hongye.

                         then ek info banega.

                         {1 , 1 , true , 1}

                         and return this.


              Step - 2 : 2 apne right main call lagaayega.

                         Max value in the subtree 3 is 3 itself and min value is also 3 itself.

                         return {3 , 3 , true , 1}

              Step - 3 : Now check 3 conditions :

                        1. Left subtree BST hain kya. -> Yes
                        2. Right subtree BST hain kya. -> Yes

                        3. root.data = 2 > left.max  and root.data < right.min

                           2 > 1 && 2 < 3 ---> True

                        So,    2
                             /   \
                            1     3

                            is also a valid BST

                            so, it will return 4 things.

                            // Max and Min in the whole subtree
                            max = Math.max (2 , 3) ==> 3
                            min = Math.min (2 , 1) ==> 1

                            isBST = true (already checked by 3 conditions)

                            size = left.size + right.size + 1
                            i.e. size = 1 + 1 + 1 ==> 3

                      return {3 , 1 , true , 3}

               Step - 4 : Go to the right of 5   i.e 4

                       Since it is a leaf node so, it is a BST , max = 4 and min = 4 , size = 1

                       return {4 , 4 , true , 1}

               Step - 5 : Now check 3 conditions for valid BST :

                        1. Left subtree BST hain kya. -> Yes
                        2. Right subtree BST hain kya. -> Yes

                        3. root.data  > left.max  and root.data < right.min

                           5 > 3 && 5 < 4 ------> false

                           Hence this is not a valid BST


              So, return Math.max (left.size , right.size) i.e 3

              ans = 3.


 */

import java.util.Scanner;

public class Largest_BST_in_a_Binary_Tree {

    Scanner sc = new Scanner(System.in);

    public class TreeNode{

        int data;

        TreeNode left;
        TreeNode right;

        // Non-parameterised Constructor
        public TreeNode () {

        }

        public TreeNode (int val) {

            this.data = val;
        }

    }

    private TreeNode root;

    // Constructor of binary tree
    public Largest_BST_in_a_Binary_Tree (){

        this.root = CreateTree();
    }


    private TreeNode CreateTree(){

        System.out.println("Enter the data : ");
        int item = sc.nextInt();

        TreeNode nn = new TreeNode();

        nn.data = item;

        boolean has_left_child = sc.nextBoolean();

        if(has_left_child) {

            nn.left = CreateTree();
        }


        boolean has_right_child = sc.nextBoolean();

        if(has_right_child) {

            nn.right = CreateTree();
        }

        return nn;
    }

    public int largestBST () {

        return largestBST (this.root);
    }

    private int maxSize = 0;

    private int largestBST (TreeNode root) {

        info temp = solve (root);

        return maxSize;
    }

    private info solve (TreeNode nn) {

        // Base Case or inplace of this we can take a base case for leaf node.
        if (nn == null) {

            info pair = new info();
            pair.maxi = Integer.MIN_VALUE;
            pair.mini = Integer.MAX_VALUE;
            pair.isBST = true;
            pair.size = 0;

            return pair;
        }

        info Left = solve (nn.left);
        info Right = solve (nn.right);

        // Abb main apni current node par khada huu e.g 2 in the above exmaple
        info curr_node = new info();

        curr_node.size = Left.size + Right.size + 1;
        curr_node.maxi = Math.max (nn.data , Right.maxi); // Maximum value subtree main right part main hee milega.
        curr_node.mini = Math.min (nn.data , Left.mini); // Minimum value subtree ke left part main hee milega.

        // Checking 3 conditions
        boolean conditon_3 = (nn.data) > Left.maxi && (nn.data) < Right.mini;
        if (Left.isBST && Right.isBST && conditon_3) {

            curr_node.isBST = true;

        } else {

            curr_node.isBST = false;
        }

        // Updating the ans
        if (curr_node.isBST) {

            maxSize = Math.max (maxSize , curr_node.size);
        }

        return curr_node;
    }

    // Stores 4 fields
    class info {

        int maxi;
        int mini;
        boolean isBST;
        int size;
    }


}
