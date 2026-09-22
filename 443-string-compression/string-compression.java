class Solution {
    public int compress(char[] chars) {
        int ans=0,index=0;
        while(index< chars.length){
            char curr= chars[index];
            int cnt=0;
            while(index<chars.length && curr==chars[index]){
                index++;
                cnt++;
            }
            chars[ans++]=curr;
            if(cnt !=1){
                for(char c: Integer.toString(cnt).toCharArray()){
                    chars[ans++]=c;
                }
            }
        }
        return ans;
    }
}