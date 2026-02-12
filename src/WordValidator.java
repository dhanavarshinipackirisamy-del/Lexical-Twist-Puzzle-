public class WordValidator {

    // Check if word is a single word (no spaces)
    public static boolean isValid(String word) {
        return word != null && !word.contains(" ");
    }
}