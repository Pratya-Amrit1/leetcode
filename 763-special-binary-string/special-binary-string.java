class Solution {
    //we will use recursion leap of faith
    public String solve(String s){
        List<String> sp = new ArrayList<>();
        int start=0;
        int sum=0;
        for(int i=0;i<s.length();i++){
            sum+= s.charAt(i)=='1'? 1:-1;
            if(sum==0){
                String inner = s.substring(start+1, i);
                sp.add( "1"+solve(inner)+"0");
                start=i+1;
            }
        }
        Collections.sort(sp, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(String c : sp){
            sb.append(c);
        }
        return sb.toString();
    }
    public String makeLargestSpecial(String s) {
        return solve(s);
    }
}