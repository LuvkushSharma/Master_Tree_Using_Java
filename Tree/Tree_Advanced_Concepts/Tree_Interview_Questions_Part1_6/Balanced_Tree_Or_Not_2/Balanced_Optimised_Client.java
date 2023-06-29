package Tree_Interview_Questions_Part1_6.Balanced_Tree_Or_Not_2;

// Input :
// 1 true 10 true 5 false false false true 39 false false

public class Balanced_Optimised_Client {

    public static void main(String[] args) {

        Balanced_Optimised tree = new Balanced_Optimised();

        boolean ans = tree.isBalanced();

        if (ans) {

            System.out.println("Balanced");
        } else {

            System.out.println("Not Balanced");
        }
    }
}
