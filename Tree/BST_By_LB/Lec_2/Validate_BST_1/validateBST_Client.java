package Lec_2.Validate_BST_1;

// Input - 1
// 2 true 1 false false true 3 false false

// Input - 2
// 5 true 1 false false true 4 true 3 false false true 6 false false

// TC : O(n)
// SC : O(H)

public class validateBST_Client {

    public static void main(String[] args) {

        validateBST tree = new validateBST();

        System.out.println(tree.isValidBST());
    }
}
