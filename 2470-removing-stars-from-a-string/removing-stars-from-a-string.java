class Solution {
    public String removeStars(String s) {
        int c = 0;  // Counter to track number of '*' seen (characters to remove)
        StringBuilder sb = new StringBuilder(); // To store the resulting characters

        // Traverse from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '*') {
                c++;  // Found a '*', so we need to remove a valid character
            } else if (c == 0) {
                sb.append(s.charAt(i));  // No '*' to cancel this character, so keep it
            } else {
                c--;  // This character is cancelled by a previous '*'
            }
        }

        // The result was built in reverse order, so reverse it
        return sb.reverse().toString();
    }
}