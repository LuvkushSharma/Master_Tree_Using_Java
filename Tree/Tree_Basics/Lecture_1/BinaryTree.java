package Lecture_1;

// Binary tree has atmax 2 children
// Here each node contains data , address of left child and address of right child.


/*


 10 T 20 T 40 F F F T 30 F T 60 T 70 F F T 80 F F

 10 insert as root node val.
 T : means 10 kaa left exists karta hain.
 20 : 10's left child value.
 T : 20's left child exists
 40 : 20's left child value.
 F : 40's left child not exists
 F : 40'S right child also not exists.
 F : 20's right child also not exists.
 .
 .
 .



                        10
                      /    \
                    20     30
                   /          \
                  40           60
                              /   \
                             70    80


 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {

    Scanner sc = new Scanner(System.in);

    // Creating nodes for the tree using this class
    public class Node{

        int data;

        // These will be initialised as null
        Node left;
        Node right;

    }

    // Root node of the binary tree
    // Isko hamne private kardiyaa becoz bahaar se agar koi isse null kardia toh puura data gayab ho jaayega.
    private Node root;

    // Constructor of binary tree
    public BinaryTree(){

        this.root = CreateTree();
    }

    // Iska kaam sirf ek tree built karna hain.
    // User direct isse call nhi kar sakta
    private Node CreateTree(){

        // System.out.println("Enter the data : ");
        int item = sc.nextInt();

        // Creating a node whose data is 0 initially and null in left and right
        Node nn = new Node();

        // Now enter item in the node
        nn.data = item;

        // Agar true enter kiya user ne toh Left child hain else no
        boolean has_left_child = sc.nextBoolean();

        if(has_left_child == true) {

              // Creating left subtree
              /*
                  Initially , root node ke left main null hee rahega jab 40 se return hoga 20 par and 20 se return karega 10 par
                  tab 10 ke left address main address store hoga null kii jagye.

               */
              nn.left = CreateTree();
        }

        // Agar true enter kiya user ne toh right child hain else no
        boolean has_right_child = sc.nextBoolean();

        if(has_right_child == true) {

            // Creating right subtree
            nn.right = CreateTree();
        }

        // Returning the node address
        return nn;
    }

    // root ko hamne private kar rakkha hain isliye bahaar se ham i.e client Display func
    // main root node nhi de paa rahe the. So, hamne same display func banaaya
    // par usse private kar diya.
    public void Display() {

        // internally neeche waala Display chal jaayega.
        Display(this.root);
    }

    private void Display(Node nn){

        // Base case
        if(nn == null){

            return;
        }

        String str = "";
        str = str + nn.data;

        // String str parent node ke data ko store karegyi
        str = " <---" + str + "---> "; // String kaa left aur right bataane ke liye.

        // Agar node kaa left null nhi hain toh uske data ko string str se pehle daal do
        if(nn.left != null) {

            str = nn.left.data + str;

        } else { // "." this denotes that left part is not there

            str = "." + str;
        }

        // Agar node kaa right null nhi hain toh uske data ko string str ke baad daal do
        if(nn.right != null) {

            str = str + nn.right.data;

        } else { // "." this denotes that right part is not there

            str = str + ".";
        }

        System.out.println(str);

        // Abb left aur right subtree ko display karengye
        Display(nn.left); // left subtree visit
        Display(nn.right); // right subtree visit

    }

    /*


        Tree Display

             10
           /     \
         20       30
          \       /
           50    60


           20 <---10---> 30

           . <---20---> 50

           . <---50---> .

           60 <---30---> .

           . <---60---> .

     */

    // Finding maximum value in a tree
    // root node directly access nhi kar sakte isliye ham
    // do do function bana rahe hain.
    public int max() {

        return max(this.root);
    }

    private int max(Node nn) {

        // Base case
        if(nn == null) {

            /*

                       10
                      /   \
                    null   null

                    left se min_value jaayegyi aur right se min_value jaayegyi
                    fir root ke data se compare karengye. Since 10 will be maximum in that case.

                        30
                      /   \
                    null   10

                    left se min_value jaayegyi aur right se 10
                    fir root ke data se compare karengye. Since 30 will be maximum in that case.


             */
            return Integer.MIN_VALUE;
        }


        int parent_data = nn.data;

        int left_max = max(nn.left); // left subtree se maximum value lao
        int right_max = max(nn.right); // right subtree se maximum value lao

        return Math.max(left_max , Math.max(right_max , parent_data));

    }

    // find method call karte samay client ko root node bhejna hoga i.e not possible
    // So, Client sirf data bhejega to find.
    // And we had made a method i.e private which we will call from public find.
    public boolean find(int item) {

        return find(this.root , item);
    }

    private boolean find(Node nn , int item) {

        // Base Case
        if(nn == null){
            return false;
        }

        // Pehle khud kaa data check karo agar match nhi kiya toh left aur right kaa call laga do.

        if(nn.data == item) {
            return true;
        }

        boolean left = find(nn.left , item);
        boolean right = find(nn.right , item);

        // Pehle left main check arengye agar left main mil gaya toh right
        // main nhi jaa rahe.
        return left || right;

    }

    // Maximum distance between root to leaf is the height of the tree.
    // Single node kaa height --> 0 maan lo or we can let it's height 1 also.
    // Function called by the Client
    public int height() {

        return height(this.root);
    }

    private int height(Node nn) {

        if(nn == null) {

            return -1; // Single node kaa height agar 0 maanogye toh -1 return karogye. aur single node kaa height 1 maanogye toh 0 return karogye.
        }

        int left_height = height(nn.left);
        int right_height = height(nn.right);

        // +1 is for the root node height.
        return Math.max(left_height , right_height) + 1;
    }

    public void PreOrder () {

        PreOrder(this.root);
        System.out.println();
    }

    private void PreOrder (Node node) {

        if (node == null) {

            return;
        }

        System.out.print(node.data + " ");

        PreOrder(node.left);
        PreOrder(node.right);
    }

    // Jab tak left aur right print nhi hongye tab tak value print mat karo.
    public void PostOrder () {

        PostOrder(this.root);
        System.out.println();
    }

    private void PostOrder (Node node) {

        if (node == null) {

            return;
        }

        PostOrder(node.left);
        PostOrder(node.right);
        System.out.print (node.data + " ");
    }

    // Pehle Bottom par jao fir Left kaa data then root kaa data then right kaa data.
    public void InOrder () {

        InOrder(this.root);
        System.out.println();
    }

    private void InOrder (Node node) {

        if (node == null) {

            return;
        }

        InOrder(node.left);
        System.out.print (node.data + " ");
        InOrder(node.right);

    }

    public void LevelOrder () {

        // LinkedList<Node> q = new LinkedList<>() // Use addlast and remove first
        Queue<Node> q = new LinkedList<>(); // Queue is the parent of LinkedLists.

        q.add(root);

        while (!q.isEmpty()) {

            Node rv = q.poll(); // poll is same as remove first.
            System.out.println(rv + " ");

            if (rv.left != null) {

                q.add(rv.left);

            }

            if (rv.right != null) {

                q.add(rv.right);

            }
        }

        System.out.println();
    }

}
