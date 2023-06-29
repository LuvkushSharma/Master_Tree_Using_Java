package Tree_Interview_Questions_Part1_6.Determine_Two_Trees_Identical_Or_Not_3;

// Input - 1 :
// Tree1 : 1 true 2 false false true 3 false false
// Tree2 : 1 true 2 false false true 3 false false

// Input - 2 :
// Tree1 : 1 true 2 true 3 false false false true 4 false false
// Tree2 : 1 true 2 false false true 3 false false

public class Identical_Client {

    public static void main(String[] args) {

        System.out.println("---------- Making Tree1 ------------");
        Identical tree1 = new Identical(); // ---> Tree1

        System.out.println();

        System.out.println("---------- Making Tree2 ------------");
        Identical tree2 = new Identical(); // ---> Tree2

        boolean ans = tree1.isIdentical(tree2);

        if (ans) {

            System.out.println("Yes");
        } else {

            System.out.println("No");
        }

    }
}
