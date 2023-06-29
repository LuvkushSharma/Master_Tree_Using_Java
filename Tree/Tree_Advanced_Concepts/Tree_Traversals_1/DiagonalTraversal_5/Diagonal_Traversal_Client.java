package Tree_Traversals_1.DiagonalTraversal_5;

import java.util.ArrayList;

// Input :
// 8 true 3 true 1 false false true 6 true 4 false false true 7 false false true 10 false true 14 true 13 false false false

public class Diagonal_Traversal_Client {

    public static void main(String[] args) {

        Diagonal_Traversal tree = new Diagonal_Traversal();

        ArrayList<Integer> ans = tree.traverseDiagonally ();

        // Displaying ans
        for (int i : ans)
            System.out.print (i + " ");
    }
}
