public class KeyboardRow{
    public String[] findWords(String[] words) {

        String row1 = "qwertyuiopQWERTYUIOP";
        String row2 = "asdfghjklASDFGHJKL";
        String row3 = "zxcvbnmZXCVBNM";

        ArrayList<String> answer = new ArrayList<>();

        for (String word : words) {

            char first = word.charAt(0);
            String currentRow = "";

            if (row1.indexOf(first) != -1) {
                currentRow = row1;
            } else if (row2.indexOf(first) != -1) {
                currentRow = row2;
            } else {
                currentRow = row3;
            }

            boolean valid = true;

            for (int i = 1; i < word.length(); i++) {
                if (currentRow.indexOf(word.charAt(i)) == -1) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                answer.add(word);
            }
        }

        String[] result = new String[answer.size()];

        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }
}