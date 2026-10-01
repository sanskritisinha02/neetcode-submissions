class Solution {
    public int findDuplicate(int[] nums) {

        // //cyclic sort 

        // int i = 0;

        // while(i < nums.length){

        //     int correct = nums[i] - 1; //cause 1...n if 0...n then nums[i] only.

        //     if(nums[i] != nums[correct]){
        //         //swap

        //         int temp = nums[i];
        //         nums[i] = nums[correct];
        //         nums[correct] = temp;
        //     }
        //     else{
        //         i++;
        //     }
        // }

        // //duplicate find.

        // for(int index = 0; index < nums.length; index ++){

        //     if(nums[index] != index + 1){
        //         return nums[index];
        //     }
        // }
        // return -1;

        //Floyd's algo (using LL)

        int slow = nums[0]; //1
        int fast = nums[0]; //1

        //find meeting point

        do{
            slow = nums[slow]; //2 -> next -> 3
            fast = nums[nums[fast]]; //3 -> next -> 3
        }while(slow != fast);


        //find duplicate
        slow = nums[0]; //1
        while(slow != fast){
            slow = nums[slow];  //1 - 2 - 3 - 2(match!)
            fast = nums[fast];  //2 - 2 - 2 - 2(match!)
        }

        return slow;
    }
}
