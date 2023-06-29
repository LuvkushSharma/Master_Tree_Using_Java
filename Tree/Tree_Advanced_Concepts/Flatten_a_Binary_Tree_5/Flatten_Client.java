package Flatten_a_Binary_Tree_5;


// Input :
// 1 true 2 true 3 false false true 4 false false true 5 false true 6 false false

public class Flatten_Client {

    public static void main(String[] args) {

        Flatten_a_Binary_Tree tree = new Flatten_a_Binary_Tree();

        tree.flatten();

        tree.displayFlattenedTree();
    }
}
