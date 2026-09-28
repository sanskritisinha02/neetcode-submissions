class MinStack {

    Stack<Integer> stack;
    public int minElem = Integer.MIN_VALUE;

    public MinStack() {

        stack = new Stack<> ();        
    }
    
    public void push(int val) {

        if(stack.isEmpty()){
            stack.push(val);
            minElem = val;
        }
        
        else{
            if(stack.size() > 0 && val >= minElem){
                stack.push(val);
            } 
            else if(stack.size() > 0 && val < minElem){
                stack.push(2*val - minElem);
                minElem = val;
            }
        }
    }
    
    public void pop() {

        if(stack.isEmpty()){
            return;
        }

        if(stack.peek() > minElem){
            stack.pop();
        }
        else if(stack.peek() < minElem){
            minElem = 2*minElem - stack.peek();
            stack.pop();
        }
    }
    
    public int top() {
        if(stack.isEmpty()){
            return -1;
        }

        if(stack.peek() > minElem){
            return stack.peek();
        }
        return minElem;
    }
    
    public int getMin() {

        if(stack.isEmpty()){
            return -1;
        }

        return minElem;
        
    }
}
