package Tree_View_Problems_2.RightView_4;

import java.util.ArrayList;

// Input :
// 1 true 2 true 3 false false true 4 false true 7 false false true 5 false true 6 false true 8 false true 9 false false

public class Right_View_Client {

    public static void main(String[] args) {

        Right_View tree = new Right_View();

        ArrayList<Integer> ans = tree.ViewFromRight ();

        // Displaying ans
        for (int i : ans)
            System.out.print (i + " ");
    }
}
