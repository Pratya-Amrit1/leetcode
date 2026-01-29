class Solution {
    public boolean isBalanced(String num) {
        int oddsum=0;
        int evensum=0;
       for(int i=0;i<num.length();i++){
        if( i%2==0){
            evensum = evensum + Integer.parseInt(String.valueOf(num.charAt(i)));
        }
        else{
            oddsum =oddsum+Integer.parseInt(String.valueOf(num.charAt(i)));
        }

       }
       
       return oddsum==evensum;
    }
}