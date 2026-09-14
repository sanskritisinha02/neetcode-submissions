class Solution {
    public int[] searchRange(int[] nums, int target) {

        int first = -1;
        int last = -1;

        //first occurence
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){

            int mid = start + (end - start)/2;

            if(nums[mid] == target){
                first = mid;
                end = mid - 1;
            }
            else if(nums[mid] > target){
                end = mid - 1;

            }
            else if(nums[mid] < target){
                start = mid + 1;
            }
        }

        //last occurence
        start = 0;
        end = nums.length - 1;

        while(start <= end){

            int mid = start + (end - start)/2;

            if(nums[mid] == target){
                last = mid;
                start = mid + 1;
            }
            else if(nums[mid] > target){
                end = mid - 1;

            }
            else if(nums[mid] < target){
                start = mid + 1;
            }
        }

        return new int[] {first, last};
    }
}