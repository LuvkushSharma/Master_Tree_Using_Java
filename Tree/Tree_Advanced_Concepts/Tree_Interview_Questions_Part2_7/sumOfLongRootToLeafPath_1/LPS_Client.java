package Tree_Interview_Questions_Part2_7.sumOfLongRootToLeafPath_1;

// Input :
// 4 true 2 true 7 false false true 1 true 6 false false false true 5 true 2 false false true 3 false false

public class LPS_Client {

    public static void main(String[] args) {

        sumOfTheLongestBloodlineOfTree tree = new sumOfTheLongestBloodlineOfTree();

        int ans = tree.LongestPathSum();

        System.out.println(ans);
    }
}
