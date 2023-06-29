package Tree_Traversals_1.ZigZagTraversal_2;

// Input :
// 1 true 3 true 7 false false true 11 false false true 5 true 17 false false false

import java.util.ArrayList;

class  Zig_Zag_Traverse_Client{

public static void main(String[] args) {

    Zig_Zag_Traversal tree = new Zig_Zag_Traversal();

    // Calling zigZagTraversal function which will return the ArrayList Containing
    // ans
    ArrayList<Integer> ans = tree.zigZagTraversal();


    // Printing the ArrayList
    for (int i = 0 ; i < ans.size() ; i++) {

        System.out.print (ans.get(i) + " ");
    }
  }
}

