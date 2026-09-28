class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        //cyclic sort

        int i = 0;
        while(i < nums.length){

            int correct = nums[i] - 1; //because 1...n if 0...n then correct = nums[i];
            if(i < nums.length && nums[i] != nums[correct]){
                //swap!
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            } 
            else{
                i++;
            }
        }
        //search missing num.
        List<Integer> ans = new ArrayList<>();
        for(int index = 0; index < nums.length; index++){
            if(nums[index] != index + 1){
                ans.add(index + 1);
            }
        }
        return ans;
    }
}