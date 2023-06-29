package Lec_1.Min_Max_value_in_BST_3;

// Input :
// 50 20 70 10 30 90 110 -1

public class minMax_Client {

    public static void main(String[] args) {

        Min_Max_in_BST tree = new Min_Max_in_BST();

        int maxi = tree.Max();
        int mini = tree.Min();

        System.out.println("Max value in BST is : " + maxi);
        System.out.println("Min value in BST is : " + mini);

    }
}
