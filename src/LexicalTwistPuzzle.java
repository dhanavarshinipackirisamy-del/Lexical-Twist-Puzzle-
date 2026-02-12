import java.util.Scanner;

public class LexicalTwistPuzzle {

    public static void main(String[] args) {

        // Scanner object to take user input
        Scanner sc = new Scanner(System.in);

        // Display puzzle title
        System.out.println("Lexical Twist Puzzle");

        // Read first word
        System.out.print("Enter first word: ");
        String word1 = sc.nextLine();

        // Read second word
        System.out.print("Enter second word: ");
        String word2 = sc.nextLine();

        // Validate that inputs are single words (no spaces)
        if (word1.contains(" ") || word2.contains(" ")) {
            System.out.println("Invalid word input. Only single words allowed.");
            sc.close();
            return;
        }

        // Reverse the first word
        String reversed = new StringBuilder(word1).reverse().toString();

        // If second word is reverse of first word
        if (reversed.equalsIgnoreCase(word2)) {

            // Convert reversed word to lowercase
            String lower = reversed.toLowerCase();
            StringBuilder result = new StringBuilder();

            // Replace vowels with '@'
            for (char ch : lower.toCharArray()) {
                if ("aeiou".indexOf(ch) != -1) {
                    result.append("@");
                } else {
                    result.append(ch);
                }
            }

            // Display transformed word
            System.out.println("Transformed word: " + result);

        }
        // If words are NOT reverse of each other
        else {

            // Combine both words and convert to uppercase
            String combined = (word1 + word2).toUpperCase();

            int vowelCount = 0;
            int consonantCount = 0;

            // Count vowels and consonants
            for (char ch : combined.toCharArray()) {

                if ("AEIOU".indexOf(ch) != -1) {
                    vowelCount++;
                }
                else if (Character.isLetter(ch)) {
                    consonantCount++;
                }
            }

            // UC7: Rule-based output
            if (vowelCount > consonantCount) {

                System.out.println("First 2 unique vowels:");
                printUnique(combined, true);

            }
            else if (consonantCount > vowelCount) {

                System.out.println("First 2 unique consonants:");
                printUnique(combined, false);

            }
            else {
                System.out.println("Vowels and consonants are equal");
            }
        }

        // Display entered words
        System.out.println("\nYou entered: " + word1 + " and " + word2);

        // Close scanner
        sc.close();
    }

    // Method to print first 2 unique vowels or consonants
    public static void printUnique(String str, boolean vowels) {

        int count = 0;
        boolean[] seen = new boolean[26]; // to avoid duplicates

        for (char ch : str.toCharArray()) {

            if (!Character.isLetter(ch))
                continue;

            int index = ch - 'A';

            if (seen[index])
                continue;

            if (vowels && "AEIOU".indexOf(ch) != -1) {
                System.out.print(ch + " ");
                seen[index] = true;
                count++;
            }
            else if (!vowels && "AEIOU".indexOf(ch) == -1) {
                System.out.print(ch + " ");
                seen[index] = true;
                count++;
            }

            if (count == 2)
                break;
        }
    }
}
