package Tree_Traversals_1.BoundaryTraversal_3;

import java.util.ArrayList;


// Input :
// 1 true 2 true 3 false false true 5 true 6 false false true 8 false false true 4 false true 7 false true 9 true 10 false false true 11 false false

public class  Boundary_Traverse_Client{

public static void main(String[] args) {

    Boundary_Traversal tree = new Boundary_Traversal();

    ArrayList<Integer> ans = tree.BoundaryTraverse();

    // Displaying the ans
    for (int val : ans) {

        System.out.print (val + " ");
    }

   }
}