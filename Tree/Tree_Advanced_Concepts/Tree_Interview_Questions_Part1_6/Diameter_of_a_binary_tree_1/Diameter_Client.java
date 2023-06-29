package Tree_Interview_Questions_Part1_6.Diameter_of_a_binary_tree_1;

// Input :
// 10 true 20 true 40 false false true 60 false false true 30 false false

public class Diameter_Client {

    public static void main(String[] args) {

        Diameter tree = new Diameter();

        int ans = tree.getDiameter();
        System.out.println(ans);
    }
}

/*

--------------------- Note ----------------------

But Time Complexity of the code is o(n^2).

As, We are traversing each node twice. One for calculating the diameter and another one for calculating the height.

Hence , we have to optimise the Code.


 */
