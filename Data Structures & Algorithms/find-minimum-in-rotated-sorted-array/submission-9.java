class Solution {
    public int findMin(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        // Already sorted
        if (nums[start] <= nums[end]) {
            return nums[start];
        }

        while (start <= end) {

            int mid = start + (end - start) / 2;

            // mid is the minimum
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            // Left part is sorted,
            // so minimum must be on the right
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