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

            String lower = reversed.toLowerCase();
            String result = "";

            for(char ch : lower.toCharArray()) {
                if("aeiou".indexOf(ch) != -1) {
                    result += "@";
                } else {
                    result += ch;
                }
            }

            System.out.println("Transformed word: " + result);
        }
        else {

            String combined = (word1 + word2).toUpperCase();

            int vowelCount = 0;
            int consonantCount = 0;

            for(char ch : combined.toCharArray()) {

                if("AEIOU".indexOf(ch) != -1) {
                    vowelCount++;
                }
                else if(Character.isLetter(ch)) {
                    consonantCount++;
                }
            }

            System.out.println("Vowels: " + vowelCount);
            System.out.println("Consonants: " + consonantCount);
        }

    }
}
