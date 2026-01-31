class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int l=0;
        int h = letters.length -1;
        int ans=letters.length;
        while(l<=h){
            int mid =(l+h)/2;
            if(target<letters[mid]){
                ans=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }

        }
        return letters[ans%letters.length];
    }
}