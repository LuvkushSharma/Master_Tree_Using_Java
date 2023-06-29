package Lecture_5.Construct_Binary_Tree_From_Preorder_and_Inorder_Traversal_1;

public class Client {

    public static void main(String[] args) {

        Binary_Tree_From_Preorder_and_Inorder tree = new Binary_Tree_From_Preorder_and_Inorder();

        int preorder[] = {10 , 12 , 3 , 4 , 6 , 7 , 5 , 11 , 2 , 8};
        int inorder[] = {3, 12 , 6 , 4 , 7 , 10 , 11 , 5 , 2 , 8};

        tree.buildTree(preorder , inorder);

        tree.display ();
    }
}
