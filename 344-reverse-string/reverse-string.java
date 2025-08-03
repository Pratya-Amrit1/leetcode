public class Solution {
    public void reverseString(char[] s) {
        List<Character> list = new ArrayList<>();
        for (char c : s) {
            list.add(c);
        }
        Collections.reverse(list);

        for (int i = 0; i < s.length; i++) {
            s[i] = list.get(i);
        }
    }
}