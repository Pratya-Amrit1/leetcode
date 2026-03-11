class Solution {
    public int repeatedStringMatch(String a, String b) {
        int n = a.length();
        int m = b.length();

        int repetition = (m+n-1)/n;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<repetition;i++){
            sb.append(a);
        }
        if(sb.toString().contains(b)){
            return repetition;
        }
        sb.append(a);
        if(sb.toString().contains(b)){
            return repetition+1;
        }
        return -1;
    }
}