package Tree_Interview_Questions_Part2_7.KthAncestorOfNode_4;

import java.util.Scanner;

// Input - 1:
// 1 true 2 true 4 false false true 5 false false true 3 false false
// k = 2
// node = 4

// Input - 2:
// 1 true 2 false false true 3 false false
// k = 5
// node = 1


public class Kth_Ancestor_OfNode_Client {

    public static void main(String[] args) {

        Kth_Ancestor_Of_Node tree = new Kth_Ancestor_Of_Node();

        System.out.println("Enter the value of k : ");
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        System.out.println("Enter the value of node : ");
        int node = sc.nextInt();

        int ans = tree.kthAncestor (k , node);
        System.out.println(ans);
    }
}
