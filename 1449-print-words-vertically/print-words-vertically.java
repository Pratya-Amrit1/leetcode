class Solution {
    public List<String> printVertically(String s) {
        int n=s.length();
        s+=" ";
        String str="";
        int len=0,count=0;
        for(char ch: s.toCharArray()){
            if(ch!=' '){
                str+=ch;
            }else{
                len=Math.max(len,str.length());
                count++;
                str="";
            }
        }
        char[][] arr=new char[count][len];
        int i=0,j=0;
        for(char ch : s.toCharArray()){
            if(ch!=' '){
                arr[i][j]=ch;
                j++;
            }else{
                i++;
                j=0;
            }
        }
        List<String> li= new ArrayList<>();

        for( j=0;j<len;j++){
            String t="";
            for( i=0;i<count;i++){
                int num=(int )arr[i][j];
                if(arr[i][j]=='\u0000')t+=' ';
                else t+=arr[i][j];
            }
            t=t.stripTrailing();
            li.add(t);
        }
        return li;
    }
}