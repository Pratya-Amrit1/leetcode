class Solution {
    public double angleClock(int hour, int minutes) {
        double hourangle= 30*hour+0.5 * minutes;
        double minuteangle= 6 *minutes;
        double angle =Math.abs(hourangle-minuteangle);
        double angle2=Math.abs(360-angle);
        double res=Math.min(angle,angle2);
        


        return res;
    }
}