class Solution {
    public int findMin(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        // Array is not rotated
        if (nums[start] <= nums[end]) {
            return nums[start];
        }

        while (start <= end) {

            int mid = start + (end - start) / 2;

            // mid is the minimum
            if ((mid == 0 || nums[mid] < nums[mid - 1]) &&
                (mid == nums.length - 1 || nums[mid] < nums[mid + 1])) {

                return nums[mid];
            }

            // Left half is sorted
            if (nums[start] <= nums[mid]) {
                start = mid + 1;
            } 
            else {
                end = mid - 1;
            }
        }

        return -1;
    }
}