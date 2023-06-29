package Lecture_4;

public class Binary_Search_Tree__Using_Inorder_Client {

    public static void main(String[] args) {

        int inorder[] = {10 , 20 , 30 , 40 , 50 , 60 , 70 , 80 , 90};

        Binary_Search_Tree_Using_Inorder_1 bst = new Binary_Search_Tree_Using_Inorder_1(inorder);

        System.out.println(bst.max());

        System.out.println(bst.min());

        System.out.println(bst.find(40));
    }
}
