public class Occurence {
    public int strStr(String haystack, String needle) {

        for (int i = 0; i < haystack.length(); i++) {

            if (i + needle.length() > haystack.length()) {
                break;
            }

            String temp = haystack.substring(i, i + needle.length());

            if (temp.equals(needle)) {
                return i;
            }
        }

        return -1;
    }
}
