class Solution {
    public int findDuplicate(int[] nums) {

        //cyclic sort 

        int i = 0;

        while(i < nums.length){

            int correct = nums[i] - 1; //cause 1...n if 0...n then nums[i] only.

            if(nums[i] != nums[correct]){
                //swap

                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            }
            else{
                i++;
            }
        }

        //duplicate find.

        for(int index = 0; index < nums.length; index ++){

            if(nums[index] != index + 1){
                return nums[index];
            }
        }
        return -1;
    }
}
