package Lec_1.Deletion_in_BST_4;

import Lec_1.Min_Max_value_in_BST_3.Min_Max_in_BST;

import java.util.Scanner;

/*
                                   100
                                 /     \
                               50       110
                             /   \        \
                            25    70       120
                                 /        /
                                60       115


                            Node to delete = 120


             --------------------------  Algo ----------------


              3 Cases arises in case of deleting a node :

              1. Node that we are going to delete has 0 child or Subtree.
                 ---> Simply return null.

                      Let's say we have to delete 115 so, put null in the left of 120.

              2. Node that we are going to delete has 1 child or 1 subtree.
                 Child can be on the left part or may in the right part.

                 NodeToDelete       NodeToDelete
                 /          Or               \
                child                       child

                Simply place child inplace of NodeToDelete

                Let's say we have to delete 120. Simply save 115 and delete 120.
                And put 115 in the right of 110.

                i.e save 115 in temp

                temp = root.left
                delete root;

                return temp;

                Similarly, we can deal the next version of this.



             3. Node that we are going to delete has 2 child or 2 subtrees.

                Let's say we want to delete 50.

                Option - 1 : Left subtree main se maximum value uthaa laao.

                           Step-1 : In place 50 we have to place the Max value from the left subtree.
                                    And it is nothing but 25 in case of above example.

                                    i.e we are replacing 50 by the value which is just lesser than 50

                                   100
                                 /     \
                               25       110
                             /   \        \
                            25    70       120
                                 /        /
                                60       115

                          Step-2 : And delete the left part of 25. i.e. now this is become a case of deleting a node having 0 child.

                                   100
                                 /     \
                               25       110
                                 \        \
                                 70       120
                                 /        /
                                60       115


                Option - 2 : Right subtree main se minimum value uthaa laao.

                      Step-1 : Min value in the right subtree of 50 is 60. So, replace 50 by 60

                                   100
                                 /     \
                               60       110
                             /   \        \
                            25    70       120
                                 /        /
                                60       115

                      Step-2 : Delete 60. i.e. deleting a node having 0 child case

                                   100
                                 /     \
                               60       110
                             /   \        \
                            25    70       120
                                          /
                                        115

 */

public class DeleteNode {

    Scanner sc = new Scanner(System.in);

    // Class for the node of the tree
    class TreeNode {

        int data;
        TreeNode left;
        TreeNode right;

        // Constructor
        public TreeNode (int val) {
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }

    private TreeNode root;

    // Constructor for BST
    public  DeleteNode () {

        Create_BST ();
    }

    // -------------------- BST Creation Code -----------------------

    private void Create_BST () {

        System.out.println("Enter the data for BST : ");
        int val = sc.nextInt();

        // Taking User input till we donot get -1
        while (val != -1) {

            this.root = insertIntoBST(root , val);
            val = sc.nextInt();
        }
    }

    private TreeNode insertIntoBST (TreeNode root , int val) {

        if (root == null) {

            TreeNode nn = new TreeNode(val);
            return nn;
        }

        // right part main insert karna hain
        if (val > root.data) {

            root.right = insertIntoBST (root.right , val);

        } else { // left part main insert karna hain

            root.left = insertIntoBST (root.left , val);
        }

        return root;
    }

    // -------------- Finding min value in BST -------------

    private int minValue (TreeNode root) {

        TreeNode temp = root;

        // Go to the left most node in the BST
        while (temp.left != null) {

            temp = temp.left;
        }

        return temp.data;
    }

    // -------------- Deleting a node in BST ----------------

    public void deleteFromBST (int val) {

        TreeNode temp = deleteFromBST (this.root , val);
        return;
    }

    private TreeNode deleteFromBST (TreeNode root , int val) {

        // Base Case
        if (root == null) {

            return root;
        }

        // Iske andarr puura delete kaa logic likhna hain
        if (root.data == val) {

            //--------- 0 child case -----------
              if (root.left == null && root.right == null) {

                  return null;
              }


            //--------- 1 child case -----------

            /*

                                    60
                                 /     \
             root ----->       50       65
                             /         /  \
                            40       64    69
                          /   \
                         30    45

                         Node to delete is 50.

                         Since 50 has only 1 left subtree or we can say 1 child.

                         Simply , Store the address of 40.
                                  then remove 50 and return 40 address.

                                  So, that it goes to the function frame of 60 then
                                  it will put 60.left = returned value i.e. 40


             */

            // left child
            if (root.left != null && root.right == null) {

                TreeNode temp = root.left;
                root.left = null;
                return temp;
            }

            // right child
            if (root.left == null && root.right != null) {

                TreeNode temp = root.right;
                root.right = null;
                return temp;
            }

            //--------- 2 child case -----------
            /*

                                    70
                                 /     \
             root ----->       60       90
                             /    \
                            50    65
                                 /   \
                                64    69


                         Node to delete is 60.

                         Since 60 has 2 subtrees.

                         Option - 2 :

                         1. 60 ke right subtree main se minimum value nikaal laao.
                            mini = 64

                         2. Replace 60 by 64.

                         3. delete 64 having 0 child. So, 60 ke right main call maar do and value = 64 bhej do.

                         4. return root i.e 64 now.


             */

            if (root.left != null && root.right != null) {

                //-------- Option-2 -------

                // find mini from the right part.
                int mini = minValue (root.right); // 60 that we got in the above example.

                // root kaa data kii jagye mini daal do
                root.data = mini; // Replace 50 with 60

                // Deleting the mini that we had copied from the right part of 50
                root.right = deleteFromBST (root.right , mini);
                return root;
            }

        } else if (root.data > val) {

            // Going to the left part
            root.left = deleteFromBST (root.left , val);
            return root;

        }

        // Going to the right part
        root.right = deleteFromBST (root.right , val);
        return root;

    }
}
