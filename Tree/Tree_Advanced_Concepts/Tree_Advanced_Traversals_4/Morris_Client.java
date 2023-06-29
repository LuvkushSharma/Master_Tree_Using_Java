package Tree_Advanced_Traversals_4;

import java.util.ArrayList;

// Input :
// 1 true 2 true 4 false true 7 false false true 5 false false true 3 false true 6 false false
// Output : 4 7 2 5 1 3 6

public class Morris_Client {

    public static void main(String[] args) {

        MorrisTraversal tree = new MorrisTraversal();

        ArrayList<Integer> ans = tree.traversal ();

        // Displaying ans
        for (int val : ans) {
            System.out.print (val + " ");
        }

    }
}
