class Solution {
    public int longestValidParentheses(String s) {
        int open = 0;
        int close = 0;
        int maxlength = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                open++;
            } else {
                close++;
            }
            if (open == close) {
                maxlength = Math.max(maxlength, 2 * close);
            } else if (close > open) {
                open = close = 0;
            }
        }

        open = close = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                close++;
            } else {
                open++;
            }
            if (open == close) {
                maxlength = Math.max(maxlength, 2 * open);
            } else if (open > close) {
                open = close = 0;
            }
        }

        return maxlength;
    }
}