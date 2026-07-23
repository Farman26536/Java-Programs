public class CommonCharacters {
    public List<String> commonChars(String[] words) {

        List<String> result = new ArrayList<>();

        int[] commonCount = new int[26];

        // Count the letters in the first word
        for (int i = 0; i < words[0].length(); i++) {
            char ch = words[0].charAt(i);
            commonCount[ch - 'a']++;
        }

        // Compare with the remaining words
        for (int i = 1; i < words.length; i++) {

            int[] currentCount = new int[26];

            for (int j = 0; j < words[i].length(); j++) {
                char ch = words[i].charAt(j);
                currentCount[ch - 'a']++;
            }

            // Keep only the minimum count of each character
            for (int k = 0; k < 26; k++) {
                if (currentCount[k] < commonCount[k]) {
                    commonCount[k] = currentCount[k];
                }
            }
        }

        // Add the common characters to the answer
        for (int i = 0; i < 26; i++) {

            while (commonCount[i] > 0) {
                char ch = (char) (i + 'a');
                result.add(String.valueOf(ch));
                commonCount[i]--;
            }
        }

        return result;
    }
}