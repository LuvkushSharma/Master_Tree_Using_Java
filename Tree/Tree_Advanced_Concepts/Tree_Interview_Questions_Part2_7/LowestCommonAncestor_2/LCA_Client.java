package Tree_Interview_Questions_Part2_7.LowestCommonAncestor_2;

import java.util.Scanner;

// Input :
// 1 true 2 true 6 false true 8 false false false true 3 true 4 false false true 5 true 21 false false false

public class LCA_Client {

    public static void main(String[] args) {

        LCA tree = new LCA();

        System.out.println("Enter the values of n1 and n2 : ");
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int ans = tree.Lowest_Common_Ancestor(n1 , n2);

        System.out.println(ans);
    }
}
