class MinStack {

    Stack<Long> stack;
    public long minElem;

    public MinStack() {

        stack = new Stack<> ();        
    }
    
    public void push(int val) {

        if(stack.isEmpty()){
            stack.push((long) val);
            minElem = val;
        }
        
        else{
            if(stack.size() > 0 && val >= minElem){
                stack.push((long) val);
            } 
            else if(stack.size() > 0 && val < minElem){
                stack.push(2L * val - minElem);
                minElem = val;
            }
        }
    }
    
    public void pop() {

        if(stack.isEmpty()){
            return;
        }
        else if(stack.peek() < minElem){
            minElem = 2*minElem - stack.peek();
        }
        stack.pop();
    }
    
    public int top() {
        if(stack.isEmpty()){
            return -1;
        }

        if(stack.peek() < minElem){
            return (int) minElem;
        }
        return stack.peek().intValue();
    }
    
    public int getMin() {

        if(stack.isEmpty()){
            return -1;
        }

        return (int) minElem;
        
    }
}
