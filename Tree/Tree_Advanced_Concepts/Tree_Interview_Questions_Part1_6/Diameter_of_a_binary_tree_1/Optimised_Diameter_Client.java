package Tree_Interview_Questions_Part1_6.Diameter_of_a_binary_tree_1;

// Input :
// 10 true 20 true 40 false false true 60 false false true 30 false false

public class Optimised_Diameter_Client {

    public static void main(String[] args) {

        Optimised_Diameter tree = new Optimised_Diameter();

        int ans = tree.getDiameter();

        System.out.println(ans);
    }
}
