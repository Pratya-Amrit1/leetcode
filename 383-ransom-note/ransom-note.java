class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] target=new int[26];
        int[] target1=new int[26];
        for(char c:ransomNote.toCharArray()){
            target[c-'a']++;
        }
        for(char c:magazine.toCharArray()){
            target1[c-'a']++;
        }
        for(int i=0;i<26;i++){
            if(target1[i]<target[i]) return false;
        }
        return true;

    }
}