class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> map=new HashMap<>();
        

        
        for(int i=0;i<magazine.length();i++){
            char left=magazine.charAt(i);
            map.put(left,map.getOrDefault(left,0)+1);
        }
        int n=ransomNote.length();
        for(int i=0;i<ransomNote.length();i++){
            char ch=ransomNote.charAt(i);
            if(map.containsKey(ch)){
                n--;
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0){
                    map.remove(ch);
                }
            }
            
            
        }
        return n==0;

    }
}