public class Main {


    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String s) {
        int checked = 0;
        for (int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                checked+=1;
            }else{
                checked-=1;
            }
        }
        return checked==0;
    }

    // 2. reverseInteger
    public static String reverseInteger(int i) {
        String outcome = "";
        String end_str = i + "";
        for (int a = 0; a < end_str.length(); a++) {
            outcome = outcome + i%10;
            i = i/10;
        }
        return outcome;
    }
    // 3. encryptThis
    public static String encryptThis(String n ) {
        StringBuilder encrypt = new StringBuilder();
        int start = 0;
        String ascii;
        int change = 0;
        char fornow;

        for (int i = 0; i <= n.length(); i++) {
            if (i == n.length() || n.charAt(i) == ' ') {
                fornow = n.charAt(start - change + 1);
                encrypt.replace(start + 1, start + 2, Character.toString(n.charAt(i - 1)));
                encrypt.replace(i + change - 1, i + change, Character.toString(fornow));
                ascii = Integer.toString(n.charAt(start - change));
                encrypt.replace(start, start + 1, ascii);
                change += (ascii.length() - 1);

                start = i + change + 1; // account for space character & ascii number length
            }

            if (i < n.length()) encrypt.append(n.charAt(i));
        }
        return encrypt.toString();
    }

    // 4. decipherThis
    public static String decipherThis(String s) {
        StringBuilder result = new StringBuilder();
        StringBuilder decrypt = new StringBuilder();
        char last = 'a';
        int length = 0;
        int second;
        int change = 0;

        for (int i = 0; i <= s.length(); i++) {
            if (i == s.length() || s.charAt(i) == ' ') {
                second = i - change - length;
                result.replace(second, second + 1, Character.toString(s.charAt(i - 1)));
                result.replace(i - change - 1, i - change, Character.toString(last));

                length = -1;
            }

            if (length == 0) {
                if (Character.isDigit(s.charAt(i))) {
                    decrypt.append(s.charAt(i));
                    change++;
                } else {
                    change--;
                    result.append((char) Integer.valueOf(decrypt.toString()).intValue());
                    decrypt.setLength(0);
                    length++;
                    last = s.charAt(i);
                    result.append(s.charAt(i));
                }
            } else if (i < s.length()) {
               result.append(s.charAt(i));
                length++;
            }
        }

        return result.toString();
    }





    }

