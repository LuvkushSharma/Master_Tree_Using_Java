package Lec_2.Kth_Largest_Element_in_BST_3;

// Input - 1 :
// 3 1 4 2 -1
// k = 1

// Input - 2 :
// 5 3 6 2 4 1 -1
// k = 3

// Input - 3 :
// 2 3 4 5 6 7 8 10 -1
// k = 3

// -------------- Imp Note -----------
// If we want to find the ans in O(1) space then we have to use the Morris Traversal.

public class kthLargestinBST_Client {

    public static void main(String[] args) {

        kthLargestinBST tree = new kthLargestinBST();

        System.out.println("Enter the value of k : ");
        int k = tree.sc.nextInt();

        int ans = tree.kthLargest (k);

        System.out.println(ans);
    }
}
