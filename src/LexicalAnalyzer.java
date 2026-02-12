
public class LexicalAnalyzer {

    // Main processing method
    public void processWords(String word1, String word2) {

        String reversed = reverseWord(word1);

        // UC4 + UC5: Reverse check & transformation
        if (reversed.equalsIgnoreCase(word2)) {
            transformWord(reversed);
        }
        // UC6 + UC7: Combine, count & rule-based output
        else {
            analyzeCombinedWords(word1, word2);
        }
    }

    // Reverse a word
    private String reverseWord(String word) {
        return new StringBuilder(word).reverse().toString();
    }

    // UC5: Replace vowels with '@'
    private void transformWord(String word) {

        String lower = word.toLowerCase();
        StringBuilder result = new StringBuilder();

        for (char ch : lower.toCharArray()) {
            if ("aeiou".indexOf(ch) != -1) {
                result.append("@");
            } else {
                result.append(ch);
            }
        }

        System.out.println("Transformed word: " + result);
    }

    // UC6 + UC7 logic
    private void analyzeCombinedWords(String word1, String word2) {

        String combined = (word1 + word2).toUpperCase();

        int vowelCount = 0;
        int consonantCount = 0;

        for (char ch : combined.toCharArray()) {

            if ("AEIOU".indexOf(ch) != -1) {
                vowelCount++;
            }
            else if (Character.isLetter(ch)) {
                consonantCount++;
            }
        }

        if (vowelCount > consonantCount) {
            System.out.println("First 2 unique vowels:");
            printUniqueCharacters(combined, true);
        }
        else if (consonantCount > vowelCount) {
            System.out.println("First 2 unique consonants:");
            printUniqueCharacters(combined, false);
        }
        else {
            System.out.println("Vowels and consonants are equal");
        }
    }

    // UC7 helper method
    private void printUniqueCharacters(String str, boolean vowels) {

        boolean[] seen = new boolean[26];
        int count = 0;

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