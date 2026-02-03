class Solution {
    public int addDigits(int n) {
    
     int sum=0;
     while(n>9){
         int temp=n;
        while(temp!=0){
       int d=temp%10;
       sum+=d;
       temp=temp/10;
        }
       n=sum;
       sum=0;
     }  
     return n; 
    }
}