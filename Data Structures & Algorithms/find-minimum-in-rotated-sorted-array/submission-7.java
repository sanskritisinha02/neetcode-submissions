class Solution {
    public int findMin(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            // Is mid the minimum?
            if ((mid == 0 || nums[mid] < nums[mid - 1]) &&
                (mid == nums.length - 1 || nums[mid] < nums[mid + 1])) {

                return nums[mid];
            }

            // Left side is sorted
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