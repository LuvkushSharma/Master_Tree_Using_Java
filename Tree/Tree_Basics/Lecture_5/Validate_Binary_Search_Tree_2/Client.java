package Lecture_5.Validate_Binary_Search_Tree_2;

// Input :
// 5 true 1 false false true 4 true 3 false false true 6 false false

public class Client {

    public static void main(String[] args) {

       Validate_BST tree = new Validate_BST();

        System.out.println(tree.isValidBST());
    }
}
