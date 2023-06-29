package Tree_Traversals_1.VerticalOrderTraversal_4;

import java.util.ArrayList;

// Input :
// 1 true 2 true 4 false false true 5 false false true 3 true 6 false true 8 false false true 7 false true 9 false false

public class Vertical_Client {

    public static void main(String[] args) {

        Vertical_Order_Traversal tree = new Vertical_Order_Traversal();

        ArrayList<Integer> ans = tree.VerticalOrderTraversal();

        for (int i : ans)
            System.out.print (i + " ");
    }
}
