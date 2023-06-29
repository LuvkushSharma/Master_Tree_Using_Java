package Tree_View_Problems_2.BottomView_2;

import java.util.ArrayList;

// Input :
// 10 true 20 true 40 false false true 60 false false true 30 false false

public class Bottom_View_Client {

    public static void main(String[] args) {

        Bottom_View tree = new Bottom_View();

        ArrayList<Integer> ans = tree.ViewFromBottom();

        // Printing the view
        for (int i : ans)
            System.out.print (i + " ");
    }
}
