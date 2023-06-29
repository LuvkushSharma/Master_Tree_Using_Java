package Lecture_3;

/*

10 20 30 40 -1 -1 50 -1 -1 60 -1 -1 -1

item = 10
root  at  10

and Queue main 10 daal do.

while () ---> True

c1 = 20
c2 = 30

remove 10 from the queue.
rv = 10

rv.left = 20 and add 20 in the queue.
rv.right = 30 and add 30 in the queue.

 */


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Construct_Binary_Tree_From_Level_Order_Traversal_5 {

         public class TreeNode {

             int val;
             TreeNode left;
             TreeNode right;

         }

         TreeNode root;
         Scanner sc = new Scanner(System.in);


         public Construct_Binary_Tree_From_Level_Order_Traversal_5 () {

             root = buildTree ();
         }

         private TreeNode buildTree () {

             int item = sc.nextInt();
             TreeNode node = new TreeNode ();
             node.val = item;

             root = node;
             Queue<TreeNode> q = new LinkedList<>();
             q.add(node);

             while (!q.isEmpty()) {

                 TreeNode rv = q.poll();
                 int c1 = sc.nextInt();
                 int c2 = sc.nextInt();

                 if (c1 != -1) {
                     TreeNode n = new TreeNode();
                     n.val = c1;
                     rv.left = n;
                     q.add(n);

                 }

                 if (c2 != -1) {

                     TreeNode n = new TreeNode();
                     n.val = c2;
                     rv.right = n;
                     q.add(n);
                 }
             }

             return root;
         }

}
