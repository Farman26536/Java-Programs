public class Validinteger {

    public boolean isNumber(String s) {

        s = s.trim();

        if (s.length() == 0) {
            return false;
        }

        try {
            Double.parseDouble(s);

            // parseDouble accepts "Infinity", which LeetCode does not.
            if (s.equals("Infinity") || s.equals("-Infinity") || s.equals("+Infinity")) {
                return false;
            }

            return true;

        } catch (Exception e) {
            return false;
        }
    }
}