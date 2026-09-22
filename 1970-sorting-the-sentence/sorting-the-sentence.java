class Solution {
    public String sortSentence(String s) {
        String[] arr= s.split(" ");
        String [] res= new String[arr.length];
        int i=0;
        for(String ch: arr){
            i=(int)(ch.charAt(ch.length()-1)-'0');
            res[i-1]=ch.substring(0,ch.length()-1);
        }
        StringBuilder sb = new StringBuilder();
        for( i=0;i<res.length-1;i++){
            sb.append(res[i]).append(" ");
        }
        sb.append(res[i]);
       return  sb.toString();
    }
}