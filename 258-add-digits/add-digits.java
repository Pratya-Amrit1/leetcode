class Solution {
    public static int digitSum(int num) {
        if (num < 10) return num;
        return (num % 10) + digitSum(num / 10);
    }

    public int addDigits(int n) {
        if(n<10)return n;
        int sum =digitSum(n);
        return addDigits(sum);
    }
}