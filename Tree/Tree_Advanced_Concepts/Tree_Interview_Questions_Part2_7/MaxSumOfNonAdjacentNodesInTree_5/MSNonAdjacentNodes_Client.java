package Tree_Interview_Questions_Part2_7.MaxSumOfNonAdjacentNodesInTree_5;

// Input - 1:
// 1 true 2 true 1 false false false true 3 true 4 false false true 5 false false

// Input - 2:
// 1 true 2 true 4 false false false true 3 true 5 false false true 6 false false

public class MSNonAdjacentNodes_Client {

    public static void main(String[] args) {

        Max_Sum_of_non_adjacent_nodes tree = new Max_Sum_of_non_adjacent_nodes();

        int ans = tree.MaxSumNonAdjacent ();

        System.out.println(ans);
    }
}
