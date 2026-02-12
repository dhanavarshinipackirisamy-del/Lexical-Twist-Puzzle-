import java.util.Scanner;

public class LexicalTwistPuzzle {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Display puzzle title
        System.out.println("Lexical Twist Puzzle");

        // Read inputs
        System.out.print("Enter first word: ");
        String word1 = sc.nextLine();

        System.out.print("Enter second word: ");
        String word2 = sc.nextLine();

        // Validate input
        if (!WordValidator.isValid(word1) || !WordValidator.isValid(word2)) {
            System.out.println("Invalid input. Only single words allowed.");
            sc.close();
            return;
        }

        // Process words
        LexicalAnalyzer analyzer = new LexicalAnalyzer();
        analyzer.processWords(word1, word2);

        sc.close();
    }
}