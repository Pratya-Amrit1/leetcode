class Solution {
    public String reverseOnlyLetters(String s) {
        int i=0;
        int fin =s.length()-1;
        char[] arr = s.toCharArray();
        while(i<fin){
             if (!Character.isLetter(arr[i])) {
                i++;
            } 
            else if (!Character.isLetter(arr[fin])) {
                fin--;
            } 
            else {
               
                char temp = arr[i];
                arr[i] = arr[fin];
                arr[fin] = temp;

                i++;
                fin--;
            }
        }
        return new String(arr);
    }
}