class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        int i = a.length()-1;
        int j = b.length() -1;
        StringBuilder sb = new StringBuilder();
        while(i>=0 || j>=0){
            int sum = carry;
            if(i>=0){
                sum = sum + (a.charAt(i) - '0');
                i--;
            }
            if(j>=0){
                sum = sum + (b.charAt(j) - '0');
                j--;
            }
            sb.append(sum%2);
            carry = sum/2;
        }
        if(carry == 1){
            sb.append('1');
        }
        sb.reverse();
        String st = sb.toString();
        return st;

        }
    }