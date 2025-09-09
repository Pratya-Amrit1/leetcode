class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character , Integer> count = new HashMap<>();
        int l=0, maxfreq=0;
        int rees=0;
        for(int i=0;i<s.length();i++){
            count.put(s.charAt(i),count.getOrDefault(s.charAt(i),0)+1);
            maxfreq= Math.max(maxfreq,count.get(s.charAt(i)));
            while((i-l+1)-maxfreq>k){
                count.put(s.charAt(l),count.get(s.charAt(l))-1);
                l++;
            }
            rees=Math.max(rees,i-l+1);
            
        }
        return rees;
    }
}