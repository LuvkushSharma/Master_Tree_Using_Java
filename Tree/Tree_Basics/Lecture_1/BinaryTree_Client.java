package Lecture_1;

public class BinaryTree_Client {

    public static void main(String[] args) {

        /*

        Input :
        10 true 20 true 40 false false true 50 false false true 30 false true 60 true 70 false false false

         */

        BinaryTree bt = new BinaryTree();

        // Client ko yaha se root bhejna padega. But root is private which is not accessible by the client.
        // i.e we had made the public display method. And from public display we are calling private display
        // Passing root node.
        bt.Display();

        System.out.println(bt.max());

        System.out.println(bt.find(32));
        System.out.println(bt.find(101));


        System.out.println(bt.height());

    }
}
