package Lec_1.BST_Creation_1;

import Lec_1.BST_Creation_1.BST;

public class BST_Client {

    // Insertion TC for BST : O(logn)
    public static void main(String[] args) {

        // Constructor will call insert method.
        BST tree = new BST();

        tree.LevelOrderTraversal();
    }

}
