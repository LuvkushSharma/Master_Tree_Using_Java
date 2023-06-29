package Lec_1.Search_in_a_BST_2;

import java.util.Scanner;

// Input :
// 5 1 2 3 6 7 -1
// x = 3

public class Search_Node_Client {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Search_Node_in_BST bst = new Search_Node_in_BST();

        System.out.println("Enter the value to be search : ");
        int x = sc.nextInt();
        boolean ans = bst.Search(x);

        System.out.println(ans);
    }
}
