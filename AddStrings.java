public class AddStrings {
    public String addStrings(String num1, String num2) {

        int i = num1.length() - 1;
        int j = num2.length() - 1;

        int carry = 0;
        String answer = "";

        while (i >= 0 || j >= 0 || carry != 0) {

            int firstNumber = 0;
            int secondNumber = 0;

            if (i >= 0) {
                firstNumber = num1.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                secondNumber = num2.charAt(j) - '0';
                j--;
            }

            int total = firstNumber + secondNumber + carry;

            int digit = total % 10;
            carry = total / 10;

            answer = digit + answer;
        }

        return answer;
    }
}