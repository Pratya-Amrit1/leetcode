class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int skipcount = 0;;
        for (int i=0; i<fruits.length; i++) {
            int foundBasket = leftmostAvailableBasket(fruits[i], baskets);
            if (foundBasket != -1) {
                baskets[foundBasket] = -1;
            }
            else {
                skipcount++;
            }
        }
        return skipcount;
    }

    private int leftmostAvailableBasket(int fruit, int[] baskets) {
        for (int i=0; i<baskets.length; i++) {
            if (baskets[i] >= fruit) {
                return i;
            }
        }

        return -1;
    }
}



// class Solution { 
//     public static boolean checkFill(boolean[] arr, int target, int[] basket){
//         for(int i=0;i<basket.length;i++){
//             if(target <= basket[i] && arr[i] == false){  
//                 arr[i] = true;    
//                 return true;
//             }
//         }
//         return false;
//     }
//     public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
//         boolean arr[] = new boolean[baskets.length];
//         int count=0;
//         for(int i=0;i<fruits.length;i++){
//             if(checkFill(arr, fruits[i], baskets) == false){ 
//                 count++;
//             }
//         }
//         return count;
//     }
// }