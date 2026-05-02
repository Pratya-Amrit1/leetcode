class Solution {
    static ArrayList<Integer> goodnum = new ArrayList<>();
    static ArrayList<Integer> goodcnt = new ArrayList<>();
    public int rotatedDigits(int n) {
        if(goodnum.isEmpty()) {
            creategood();
        }
        return goodcnt.get(n);
    }

    private void creategood() {
        int count = 0;
        for(int num = 0; num <= 10000; num++) {
            boolean isValid = isvalidgoodnumber(num);
            if(isValid) {
                count++;
                goodnum.add(num);
            }
            goodcnt.add(count);
        }
    }

    private boolean isvalidgoodnumber(int num) {
        boolean isValid = false;
        while(num > 0) {
            int digit = num % 10;
            if( digit == 3 || digit == 4 || digit == 7) {
                return false;
            }
            if(digit == 2 || digit == 5 || digit == 6 || digit == 9) {
                isValid = true;
            }
            num /= 10;
        }
        return isValid;
    }
}