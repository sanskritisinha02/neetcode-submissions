class Solution {
    public int findPeakElement(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        while(start < end){

            int mid = start + (end-start)/2;

            //middle elems
            if(mid > 0 && mid < nums.length - 1){

                if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]){
                    return mid;
                }

                else if(nums[mid] < nums[mid - 1]){
                    end = mid - 1;
                }
                else if(nums[mid] < nums[mid + 1]){
                    start = mid + 1;
                }
            }

            //first elem
            else if(mid == 0){
                if(nums[mid] > nums[mid + 1]){
                    return mid;
                }
                else{
                    return mid + 1;
                }
            }

            //last elem
            else if(mid == nums.length - 1){
                if(nums[mid] > nums[mid - 1]){
                    return mid;
                }
                else{
                    return mid - 1;
                }
            }
        }
        return start;
    }
}