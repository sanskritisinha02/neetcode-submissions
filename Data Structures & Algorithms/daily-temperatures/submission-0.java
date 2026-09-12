class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        Stack<Integer> stack = new Stack<> ();
        int[] ans = new int[n];

        for(int x = 0; x < n; x++){
            ans[x] = 0;;
        }

        for(int i = n-1; i >= 0; i--){
            if(stack.size() == 0){
                ans[i] = 0;;
            }

            else if(stack.size() > 0 && temperatures[i] < temperatures[stack.peek()]){
                ans[i] = stack.peek() - i;
            }

            else if(stack.size() > 0 && temperatures[i] >= temperatures[stack.peek()]){
                while(stack.size() > 0 && temperatures[i] >= temperatures[stack.peek()]){
                    stack.pop();
                }
                if(stack.size() == 0){
                    ans[i] = 0;
                }
                else if(stack.size() > 0 && temperatures[i] < temperatures[stack.peek()]){
                    ans[i] = stack.peek() - i;
                }
            }
            stack.push(i);
        }
        return ans;
    }
}
