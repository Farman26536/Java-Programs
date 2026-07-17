public class Stringtoint {

    public int myAtoi(String s) {

        int index = 0;
        int sign = 1;
        long number = 0;

        // Skip leading spaces
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }

        // Check for + or - sign
        if (index < s.length()) {
            if (s.charAt(index) == '-') {
                sign = -1;
                index++;
            } else if (s.charAt(index) == '+') {
                index++;
            }
        }

        // Read digits
        while (index < s.length()) {

            char ch = s.charAt(index);

            if (ch < '0' || ch > '9') {
                break;
            }

            int digit = ch - '0';
            number = number * 10 + digit;

            // Check overflow
            if (sign == 1 && number > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            if (sign == -1 && -number < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            index++;
        }

        number = number * sign;

        return (int) number;
    }
}