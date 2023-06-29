package Tree_Traversals_1.VerticalOrderTraversal_4;


import java.util.*;

public class Vertical_Order_Traversal {

    Scanner sc = new Scanner(System.in);

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private TreeNode root;

    // Constructor of the Binary Tree
    public Vertical_Order_Traversal() {

        this.root = Create_Binary_Tree();
    }

    private TreeNode Create_Binary_Tree() {

        System.out.println("Enter the data : ");
        int data = sc.nextInt();
        TreeNode root = new TreeNode(data);

        System.out.println("Left of " + data + " ");
        boolean hasLeftNode = sc.nextBoolean();
        if (hasLeftNode == true) {

            root.left = Create_Binary_Tree();
        }

        System.out.println("Right of " + data + " ");
        boolean hasRightNode = sc.nextBoolean();
        if (hasRightNode == true) {

            root.right = Create_Binary_Tree();
        }

        return root;
    }

    public ArrayList<Integer> VerticalOrderTraversal() {

        return VerticalOrderTraversal(root);
    }

    private void solve (Map<Integer , ArrayList<Integer>> map , TreeNode root , int Horizontal_Dist) {

        // Pair stores the Node and hd corresponding to that node.
        Queue<Pair> q = new LinkedList<>();

        Pair p = new Pair();

        p.hd = Horizontal_Dist;
        p.node = root;

        // Initially pair contains root node and it's hd i.e 0.
        q.add (p);

        while (!q.isEmpty()) {

            Pair temp = q.peek();

            // Getting frontNode from the queue
            TreeNode frontNode = temp.node;
            int Hor_dis = temp.hd;

            q.remove();

            // This hd is not stored till now
            // so, store it in the map with it's value i.e node values corresponding to this hd
            // Agar Hor_dis naam kii key nhi hain map main toh .get() function null return karega.
            if (map.get(Hor_dis) == null) {

                ArrayList<Integer> leftAns = new ArrayList<>();
                leftAns.add(frontNode.val);

                map.put(Hor_dis , leftAns);

            } else {

                ArrayList<Integer> rightAns = map.get(Hor_dis);
                rightAns.add(frontNode.val);

                map.put(Hor_dis , rightAns);
            }

            if (frontNode.left != null) {

                Pair pLeft = new Pair();

                pLeft.node = frontNode.left;
                pLeft.hd = Hor_dis - 1;

                q.add(pLeft);
            }

            if (frontNode.right != null) {

                Pair pRight = new Pair();

                pRight.node = frontNode.right;
                pRight.hd = Hor_dis + 1;

                q.add(pRight);
            }
        }
    }

    private ArrayList<Integer> VerticalOrderTraversal(TreeNode root) {

        // Here Key denotes the horizontal distance. And value represents the nodes on that hd.
        // I am taking TreeMap instead of hashMap because we have to traverse from the extreme end of the tree to the top most right corner of the tree.
        // i.e. We want that Map should be sorted hd wise.
        Map<Integer , ArrayList<Integer>> map = new TreeMap<>();

        solve (map , root , 0);

        ArrayList<Integer> ans = new ArrayList<>();

        // Fetching the ArrayList from the map.
        for(ArrayList<Integer> arr: map.values()){

            ans.addAll(arr);
        }

        System.out.println(map);

        return ans;
    }

    class Pair {

        int hd;
        TreeNode node;

        // Constructor
        public Pair () {
            this.hd = 0;
            this.node = null;
        }
    }

}
