class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0;
        int right=0;
        int maxlen=0;
        Set<Character> st = new HashSet<>();
        for(right=0;right<s.length();right++){

            while(st.contains(s.charAt(right))){
                st.remove(s.charAt(left));
                left++;
            }
            st.add(s.charAt(right));
            maxlen=Math.max(right-left+1,maxlen);
        }
        return maxlen;
    }
}