public class ExpressionMatching {

    public boolean isMatch(String text, String pattern) {

        // If the pattern is empty, the text must also be empty
        if (pattern.length() == 0) {
            return text.length() == 0;
        }

        // Check if the first characters match
        boolean firstCharacterMatches = false;

        if (text.length() > 0) {
            if (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.') {
                firstCharacterMatches = true;
            }
        }

        // Check if the second character in the pattern is '*'
        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {

            // Option 1: Ignore "x*"
            boolean skipStar = isMatch(text, pattern.substring(2));

            // Option 2: Use one matching character
            boolean useStar = false;

            if (firstCharacterMatches) {
                useStar = isMatch(text.substring(1), pattern);
            }

            return skipStar || useStar;
        }

        // Normal character matching
        if (firstCharacterMatches) {
            return isMatch(text.substring(1), pattern.substring(1));
        }

        return false;
    }
}