class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue <Integer> minH = new PriorityQueue<> ();

        for(int i = 0; i < nums.length; i++){

            minH.add(nums[i]);

            if(minH.size() > k){

                minH.poll();
            }
        }

        return minH.peek();
        
    }
}
