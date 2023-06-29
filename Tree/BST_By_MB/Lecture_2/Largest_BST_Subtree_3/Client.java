package Lecture_5.Largest_BST_Subtree_3;

// Input - 1:
// 10 true 5 true 1 false false true 8 false false true 15 false true 7 false false


// Input - 2:
// 1 true 3 true 2 false false true 4 false false true 3 true 2 false false true 5 true 4 false false true 6 false false

public class Client {

    public static void main(String[] args) {

        Largest_BST tree = new Largest_BST();

        long ans = tree.largestBSTSize();

        System.out.println(ans);
    }
}
