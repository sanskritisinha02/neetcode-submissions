class Solution {
    public int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        int originalEnd = end;

        while(start < end){

            int mid = start + (end - start)/2;

            if(nums[mid] > nums[end]){
                start = mid + 1;
            }
            else{
                end = mid;
            }
        }
        int ans = start; //index = 4 which is 1.

        if(nums[ans] <= target && target <= nums[originalEnd]){
            return binarySearch(nums, ans, originalEnd, target);
        }
        else{
            return binarySearch(nums, 0, ans - 1, target);
        }
    }

    static int binarySearch(int[] nums, int start, int end, int target){
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                return mid;
            }

            if(nums[mid] > target){
                end = mid - 1;
            }
            else if(nums[mid] < target){
                start = mid + 1;
            }
        }
        return -1;
    }
}
