package Lec_1.Deletion_in_BST_4;

// Input :
// 50 20 70 10 30 90 110 -1


// TC : O(n)


public class DeleteNode_Client {

    public static void main(String[] args) {

        DeleteNode tree = new DeleteNode();

        System.out.println("Enter the value to be deleted in BST : ");
        int val = tree.sc.nextInt();

        tree.deleteFromBST (val);
    }
}
