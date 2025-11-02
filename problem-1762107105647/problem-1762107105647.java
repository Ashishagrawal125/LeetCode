// Last updated: 11/2/2025, 11:41:45 PM
class Solution {
    public int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;
        int num = 0, lastNum = 0, result = 0;
        char sign = '+';
        s = s.replaceAll(" ", "");

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (!Character.isDigit(c) || i == s.length() - 1) {
                if (sign == '+') {
                    result += lastNum;
                    lastNum = num;
                } else if (sign == '-') {
                    result += lastNum;
                    lastNum = -num;
                } else if (sign == '*') {
                    lastNum = lastNum * num;
                } else if (sign == '/') {
                    lastNum = lastNum / num;
                }
                sign = c;
                num = 0;
            }
        }
        result += lastNum;
        return result;
    }
}
