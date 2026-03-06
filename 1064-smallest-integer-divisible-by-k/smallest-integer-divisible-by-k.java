class Solution {
    public int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0) return -1;
        HashSet<Integer> seen = new HashSet<>();
        int remainder = 1 % k;
        int length = 1;
        while (!seen.contains(remainder)) {
            if (remainder == 0) return length;
            seen.add(remainder);
            remainder = (remainder * 10 + 1) % k;
            length++;
        }
        return -1;
    }
}