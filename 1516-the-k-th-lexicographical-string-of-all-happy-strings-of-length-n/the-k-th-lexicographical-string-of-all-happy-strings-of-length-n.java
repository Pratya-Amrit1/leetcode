import java.util.*;

class Solution {
    public String getHappyString(int n, int k) {
        List<String> list = new ArrayList<>();
        generate(n, "", list);

        if (k > list.size()) return "";
        return list.get(k - 1);
    }

    private void generate(int n, String curr, List<String> list) {
        if (curr.length() == n) {
            list.add(curr);
            return;
        }

        for (char c : new char[]{'a','b','c'}) {
            if (curr.length() == 0 || curr.charAt(curr.length() - 1) != c) {
                generate(n, curr + c, list);
            }
        }
    }
}