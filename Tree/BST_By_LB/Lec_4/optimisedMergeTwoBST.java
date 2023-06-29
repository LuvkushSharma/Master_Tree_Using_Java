package Lec_4;

import java.util.Scanner;

public class optimisedMergeTwoBST {

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
    public optimisedMergeTwoBST () {

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

    public void optimisedMerging (optimisedMergeTwoBST tree2) {

        TreeNode root1 = this.root;

        TreeNode root2 = tree2.root;

        TreeNode newRoot = optimisedMerging (root1 , root2);
    }

    // Step-1
    private void convertIntoSortedDoublyLinkedLists (TreeNode root1 , TreeNode head) {

        // Base Case
        if (root1 == null)
            return;
         // Pehle right part convert kardo fir usse root se attach kardena aur fir tum left part attch kardena
        // Right portion ko DLL main convert kar diya
        convertIntoSortedDoublyLinkedLists (root1.right ,head);

        root1.right = head;

        // Maan lo right part null hua toh head null aa jaeyga. Isliye pehle check kar lo
        if (head != null) {

            head.left = root1;
        }

        head = root1;

        // Left portion ko DLL main convert kar diya
        convertIntoSortedDoublyLinkedLists (root1.left , head);
    }

    // Step-2
    TreeNode mergeSortedLinkedLists (TreeNode head1 , TreeNode head2) {

        TreeNode head = null;
        TreeNode tail = null;

        while (head1 != null && head2 != null) {

            if (head1.data < head2.data) {

                if (head == null) {

                    head = head1;
                    tail = head1;
                    head1 = head1.right;

                } else{

                    // Insert at end
                    tail.right = head1;
                    head1.left = tail;
                    tail = head1;
                    head1 = head1.right;

                }
            } else {

                if (head == null) {

                    head = head2;
                    tail = head2;
                    head2 = head2.right;

                } else{

                    // Insert at end
                    tail.right = head2;
                    head2.left = tail;
                    tail = head2;
                    head2 = head2.right;

                }
            }
        }

        while (head1 != null) {

            // Insert at end
            tail.right = head1;
            head1.left = tail;
            tail = head1;
            head1 = head1.right;
        }

        while (head2 != null) {

            // Insert at end
            tail.right = head2;
            head2.left = tail;
            tail = head2;
            head2 = head2.right;
        }

       return head;
    }

    // Step-3

    /*

     Ex :

     LikedLists
     --------------------------------
     |  3  |  5  |  7  |  9  |  11  | ---> null
     --------------------------------

     Let's say we have n nodes so, starting ke n/2 nodes se left subtree bana do.

     3 , 5 ----------> Left part

     7 ----> Root node

     9 , 11 ------> Right part

     Step-1 :  n/2 --> Left tree
     Step-2 :  Jis node par main stand kar raha huun usse root bana diyaa and root.left main left subtree daal diya.

     Step-4 : head = head.next and make right subtree.
              Right subtree will have (n - n/2 - 1) nodes.

     */

    private int CountNodes (TreeNode head) {

        int cnt = 0;
        TreeNode temp = head;

        while (temp !=  null) {

            cnt += 1;
            temp = temp.right;
        }

        return cnt;
    }

    private TreeNode sortedLinkedListsToBST (TreeNode head , int n) {

          // Base Case
        if (n <= 0 || head == null)
            return null;

        // Create Left Subtree
        TreeNode Left = sortedLinkedListsToBST (head , n/2);

        TreeNode newRoot = head;

        newRoot.left = Left;
        head = head.right;

        newRoot.right = sortedLinkedListsToBST (head , n - n/2 - 1);

        return newRoot;
    }

    // ---------------------- Main Function -------------------
    private TreeNode optimisedMerging (TreeNode root1 , TreeNode root2) {

        // Step-1 : Convert BST into sorted Doubly LinkedLists
        TreeNode head1 = null;
        convertIntoSortedDoublyLinkedLists (root1 , head1);

        head1.left = null;

        TreeNode head2 = null;
        convertIntoSortedDoublyLinkedLists (root2 , head2);

        head2.left = null;

        // Step-2 : Merge Sorted LinkedLists
        TreeNode head = mergeSortedLinkedLists(head1 , head2);

        // Step-3 : Convert Sorted LinkedLists into BST
        TreeNode newRoot = sortedLinkedListsToBST (head , CountNodes(head));

        return newRoot;
    }

}
