package Lec_2.LCA_in_BST;

// Input :
// 4 2 5 1 3 -1
// p = 2 and q = 5

public class LCAinBst_Client {

    public static void main(String[] args) {

        LCAinBst tree = new LCAinBst();

        System.out.println("Enter p : ");
        int p = tree.sc.nextInt();

        System.out.println("Enter q : ");
        int q = tree.sc.nextInt();

        int ans = tree.LCA(p , q);

        System.out.println(ans);
    }
}
