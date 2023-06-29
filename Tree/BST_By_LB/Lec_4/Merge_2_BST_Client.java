package Lec_4;

/*

------------------ Approach - 1 ----------------------

Let's say we have two BST's : BST1 , BST2 having sizes m and n respectively.

Step-1 : Find the inorder of BST1 and BST2 having size m and n respectively.

Step-2 : Now merge two sorted arrays (inorders array). arr3.size = (m + n)

Step-3 : Apply the inorderTOBST function to convert the step-2 Inorder to BST.

TC : O (m + n)
SC : O (m + n)


-------------- Approach - 2 ---------------------------

follow up : SC : O (h1 + h2)

Ye jo ham Inorder calculate karne ke baad unhe ArrayList main store kar rahe kyo naa unhe hata de. But how ?

We can convert the BST's to sorted LinkedLists. Ismain extra space bhi nhi laga because Hamne trees main hee changes karein hain.
And sorted LinkedLists is same as Inorder.

Step-1 : ----------- Convert BST into sorted LinkedLists -------------

         Flatten the BST into sorted LinkedLists :
         TC : O(m) and SC : O(h1) , TC : O(n) and SC : O(h2)

Step-2 : Merge 2 Sorted LinkedLists : TC : O(m + n) and SC : O(1)

Step-3 : Convert Sorted LinkedLists into BST.
         SC : O(h1 + h2)

 ------> Their are 3 different questions in a single question.

                                      50
                                   /      \
                                 40         60
                              /     \    /     \
                             30     45  55      70
                                                  \
                                                  80

                       Algo :

                   1. Convert right subtree into Linkedlists i.e. Subtree having 60 as the root.

                   2. Now head will be at 60. 50.right = head and head.left = 50 i.e root
                      And by this we got a doubly linkedlists.
                      and head = root

                   3. Convert Left subtree (root as 40) into linkedlists.
                      50.left = head2 and head2.left = head.

         For approach-2 go the next java file i.e optimisedMergeTwoBST

 */

public class Merge_2_BST_Client {

    public static void main(String[] args) {

        // BST-1
        Merge_2_BST tree1 = new Merge_2_BST();

        System.out.println("------------------------------------");

        // BST-2
        Merge_2_BST tree2 = new Merge_2_BST();

        tree1.MergeBST (tree2);
    }
}
