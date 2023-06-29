package Tree_Interview_Questions_Part2_7.KSumPaths_3;

import java.util.Scanner;

// Input :
// 1 true 3 true 2 false false true 1 true 1 false false false true -1 true 4 true 1 false false true 2 false false true 5 false true 6 false false
// k = 5

public class K_Sum_Path_Client {

    public static void main(String[] args) {

        K_Sum_Path tree = new K_Sum_Path();

        System.out.println("Enter the value of k : ");
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int ans = tree.KSumPath(k);

        System.out.println(ans);
    }
}
