class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        
        //right
        Stack<Integer> stack_right = new Stack<> ();
        ArrayList<Integer> right = new ArrayList<> ();

        //left
        Stack<Integer> stack_left = new Stack<> ();
        ArrayList<Integer> left = new ArrayList<> ();

        ArrayList<Integer> width = new ArrayList<> ();
        ArrayList<Integer> area = new ArrayList<> ();

        //calculating right - NSR: Nearest smallest right
        int pseudo_right = n;
        for(int x = 0; x < n; x++){
            right.add(pseudo_right);
        }

        for(int i = n-1; i >= 0; i--){

            if(stack_right.size() == 0){
                right.set(i, pseudo_right);
            }

            else if(stack_right.size() > 0 && heights[i] > heights[stack_right.peek()]){
                right.set(i, stack_right.peek());
            }

            else if(stack_right.size() > 0 && heights[i] <= heights[stack_right.peek()]){

                while(stack_right.size() > 0 && heights[i] <= heights[stack_right.peek()]){
                    stack_right.pop();
                }

                if(stack_right.size() == 0){
                    right.set(i, pseudo_right);
                }

                else if(stack_right.size() > 0 && heights[i] > heights[stack_right.peek()]){
                    right.set(i, stack_right.peek());
                }
            }
        stack_right.push(i);
        }

        //calculating left - NSL: Nearest smaller left
        int pseudo_left = -1;

        for(int y = 0; y < n; y++){
            left.add(pseudo_left);
        }

        for(int i = 0; i < n; i++){

            if(stack_left.size() == 0){
                left.set(i, pseudo_left);
            }

            else if(stack_left.size() > 0 && heights[i] > heights[stack_left.peek()]){
                left.set(i, stack_left.peek());
            }

            else if(stack_left.size() > 0 && heights[i] <= heights[stack_left.peek()]){

                while(stack_left.size() > 0 && heights[i] <= heights[stack_left.peek()]){
                    stack_left.pop();
                }

                if(stack_left.size() == 0){
                    left.set(i, pseudo_left);
                }

                else if(stack_left.size() > 0 && heights[i] > heights[stack_left.peek()]){
                    left.set(i, stack_left.peek());
                }
            }
        stack_left.push(i);
        }

        for(int z = 0; z < n; z++){
            width.add(right.get(z) - left.get(z) -1);
        }

        for(int z = 0; z < n; z++){
            area.add(heights[z] * width.get(z));
        }

        return Collections.max(area);
    }
}