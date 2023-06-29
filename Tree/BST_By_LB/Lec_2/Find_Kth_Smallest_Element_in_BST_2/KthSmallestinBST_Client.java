package Lec_2.Find_Kth_Smallest_Element_in_BST_2;

// Input - 1 :
// 3 1 4 2 -1
// k = 1

// Input - 2 :
// 5 3 6 2 4 1 -1
// k = 3

// TC : O(n)
// SC : O(H) and in case of skew tree SC : O(n)

// ---------------- Note --------------
// So, we can use the Morris Traversal to get the SC : O(1)
// as Morris traversal gives same result as of Inorder Traversal.

public class KthSmallestinBST_Client {

    public static void main(String[] args) {

        KthSmallestinBST tree = new KthSmallestinBST();

        System.out.println("Enter the value of k : ");
        int k = tree.sc.nextInt();

        int ans = tree.kthSmallest (k);

        System.out.println(ans);
    }
}
