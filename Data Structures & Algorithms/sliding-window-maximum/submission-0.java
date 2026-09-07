class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        int i = 0;
        int j = 0;
        int index = 0;
        int [] ans = new int[n-k+1];
        Deque<Integer> deque = new LinkedList<> ();

        while(j < n){

            while(!deque.isEmpty() && nums[deque.peekLast()]< nums[j]){
                deque.pollLast();
            }

            deque.addLast(j);

            if(j-i+1 < k){
                j++;
            }

            else if(j-i+1 == k){

                ans[index] = nums[deque.peekFirst()];
                index++;

                if(deque.peek() == i){
                    deque.pollFirst();
                }

                i++;
                j++;
            }
        }

        return ans;
    }
}
