// class Solution {
//     public int minimumDeletions(String s) {
//         int acount=0;
//         int bcount=0;
//         int mindel=s.length();
//         for(char i:s.toCharArray()){
//             if(i=='a'){
//                 acount++;
//             }
//         }
//         for(char i:s.toCharArray()){
//             if(i=='a'){
//                 acount--;
//             }
//             mindel=Math.min(mindel,acount+bcount);
//              if(i=='b'){
//                 bcount++;
//             }
//         }
//         return mindel;
//     }
// }

class Solution {
    public int minimumDeletions(String s) {
        int bCount = 0;  
        int deletions = 0;

        for (char c : s.toCharArray()) {
            if (c == 'b') {
                bCount++;
            } else {
                deletions = Math.min(deletions + 1, bCount);
            }
        }
        return deletions;
    }
}