class Defanging {
    public String defangIPaddr(String address) {
        

        String result = "";

        for (int i = 0; i < address.length(); i++) {

            char ch = address.charAt(i);

            if (ch == '.') {
                result = result + "[.]";
            } else {
                result = result + ch;
            }
        }

        return result;
    }
}