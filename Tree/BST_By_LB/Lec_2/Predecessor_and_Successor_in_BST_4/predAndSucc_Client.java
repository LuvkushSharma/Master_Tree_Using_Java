package Lec_2.Predecessor_and_Successor_in_BST_4;

// ------- Approach - 1 -------


// TC : O(n)
// SC : O(n)

// ------- Approach - 2 -------

// Input :
// 50 30 70 20 40 60 80 -1
// key = 65

public class predAndSucc_Client {

    public static void main(String[] args) {

        predAndSucc tree = new predAndSucc();

        System.out.println("Enter the key : ");
        int key = tree.sc.nextInt();

        tree.findPredSuc(key);
    }
}
