package Tree_View_Problems_2.Left_View_3;

import java.util.ArrayList;

// Input :
// 1 true 2 true 4 false true 8 false false true 5 false false true 3 true 6 false false true 7 false false

public class Left_View_Client {

    public static void main(String[] args) {

        Left_View tree = new Left_View();

        ArrayList<Integer> ans = tree.ViewFromLeft ();

        // Displaying ans
        for (int i : ans)
            System.out.print (i + " ");
    }
}
