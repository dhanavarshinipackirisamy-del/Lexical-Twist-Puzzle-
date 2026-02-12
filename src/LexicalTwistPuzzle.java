import java.util.Scanner;

public class LexicalTwistPuzzle {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Lexical Twist Puzzle");

        System.out.print("Enter first word: ");

        String word1 = sc.nextLine();

        System.out.print("Enter second word: ");
        String word2 = sc.nextLine();

        System.out.println("You entered: " + word1 + " and " + word2);
        if(word1.contains(" ") || word2.contains(" ")) {
            System.out.println("Invalid word input. Only single words allowed.");
            return;


        }
        String reversed = new StringBuilder(word1).reverse().toString();

        if(reversed.equalsIgnoreCase(word2)) {
            System.out.println("Words are reverse of each other");
        } else {
            System.out.println("Words are NOT reverse of each other");
        }

    }
}
