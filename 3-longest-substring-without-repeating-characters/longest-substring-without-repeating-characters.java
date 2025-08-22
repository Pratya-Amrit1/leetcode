class Solution {
    public int lengthOfLongestSubstring(String s) {
      int n =s.length();
      Set<Character> set= new HashSet<>();
      int maxlength=0; 
      int left=0;
      for(int i=0;i<n;i++){
        while(set.contains(s.charAt(i))){
            set.remove(s.charAt(left));
            left++;
        }
        set.add(s.charAt(i));
        maxlength= Math.max(maxlength, i - left +1);
      }
      return maxlength;
    }
}