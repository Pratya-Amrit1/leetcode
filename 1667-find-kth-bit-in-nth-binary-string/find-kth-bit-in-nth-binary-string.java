class Solution {
    public char findKthBit(int n, int k) {

        String binStr = "0";

        for(int i = 1; i < n; i++) {

            if (binStr.length() >= k) {
                return binStr.charAt(k - 1);
            }

            binStr = buildTail(binStr);
        }

        return binStr.charAt(k - 1);
    }

    private String buildTail(String str) {

        StringBuilder sb = new StringBuilder();
        for(int i = str.length() - 1; i > -1; i--) {

            sb.append(str.charAt(i) == '0' ? '1' : '0');
        }

        return str + "1" + sb.toString();
    }
}