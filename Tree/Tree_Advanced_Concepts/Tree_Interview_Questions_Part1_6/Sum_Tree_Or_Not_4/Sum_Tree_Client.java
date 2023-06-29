package Tree_Interview_Questions_Part1_6.Sum_Tree_Or_Not_4;

// Input - 1:
// 3 true 1 false false true 2 false false

// Input - 2 :
// 1 true 2 false false true 3 false false

public class Sum_Tree_Client {

    public static void main(String[] args) {

        Sum_Tree tree = new Sum_Tree();

        boolean ans = tree.isSumTree();

        if (ans) {

            System.out.println("Yes");
        } else {

            System.out.println("No");
        }
    }
}
