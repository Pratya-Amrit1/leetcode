class Solution {
    static int[] temp;

    public static void sort(int[] arr, int left, int mid, int right) {
        int low = left;
        int high = mid + 1;
        int k = 0;

        // Use temp of appropriate size
        temp = new int[right - left + 1];

        while (low <= mid && high <= right) {
            if (arr[low] < arr[high]) {
                temp[k++] = arr[low++];
            } else {
                temp[k++] = arr[high++];
            }
        }

        while (low <= mid) {
            temp[k++] = arr[low++];
        }

        while (high <= right) {
            temp[k++] = arr[high++];
        }

        // Copy back to original array
        for (int i = 0; i < temp.length; i++) {
            arr[left + i] = temp[i];
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        sort(arr, left, mid, right);
    }

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
}