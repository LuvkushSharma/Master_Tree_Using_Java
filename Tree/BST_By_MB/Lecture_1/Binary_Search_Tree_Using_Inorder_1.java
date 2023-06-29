package Lecture_4;

// Inorder traversal of BST is always sorted.
public class Binary_Search_Tree_Using_Inorder_1 {

    public class Node {

        int val;
        Node left;
        Node right;
    }

    private Node root;

    public Binary_Search_Tree_Using_Inorder_1(int[] inorder) {

        this.root = CreateTree(inorder , 0, inorder.length - 1);
    }

    // We can build multiple BST from given Inorder Traversal.
    // But , we are trying to build Balanced BST.
    private Node CreateTree(int[] inorder, int si, int ei) {

        if (si > ei) {
            return null;
        }

        int mid = (si + ei) / 2;

        Node nn = new Node();
        nn.val = inorder[mid];

        nn.left = CreateTree(inorder , si, mid - 1);
        nn.right = CreateTree(inorder , mid + 1, ei);

        return nn;
    }

    public int max() {

        return max(this.root);
    }

    public int max(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int r = max(root.right);
        return Math.max(root.val, r);

    }

    public int min() {

        return min(this.root);
    }

    public int min(Node root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        int r = min(root.left);
        return Math.min(root.val, r);

    }

    public boolean find(int item) {

        return find(this.root , item);
    }

    private boolean find (Node nn , int item) {

        // Base Case
        if(nn == null){
            return false;
        }


        if(nn.val == item) {
            return true;

        } else if (nn.val > item) {

            return find(nn.left , item);

        } else {

            return find (nn.right , item);
        }

    }
}
