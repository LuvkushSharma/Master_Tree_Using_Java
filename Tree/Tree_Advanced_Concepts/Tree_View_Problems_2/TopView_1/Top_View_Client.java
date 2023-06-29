package Tree_View_Problems_2.TopView_1;

import java.util.ArrayList;

// Input :
// 1 true 2 true 4 false false true 5 false false true 3 true 6 false false true 7 false false


public class Top_View_Client {

    public static void main(String[] args) {

        Top_View tree = new Top_View();

        ArrayList<Integer> ans = tree.ViewFromTop();

        // Printing the view
        for (int i : ans)
            System.out.print (i + " ");
    }
}
