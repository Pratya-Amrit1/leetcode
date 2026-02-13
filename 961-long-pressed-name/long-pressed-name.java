class Solution {
    public boolean isLongPressedName(String name, String typed) {

        int i = 0; // pointer for name
        int j = 0; // pointer for typed

        while (j < typed.length()) {

            // Case 1: characters match → move both
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            }
            // Case 2: long press → match previous typed character
            else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            }
            // Case 3: mismatch
            else {
                return false;
            }
        }

        // All characters of name must be matched
        return i == name.length();
    }
}
