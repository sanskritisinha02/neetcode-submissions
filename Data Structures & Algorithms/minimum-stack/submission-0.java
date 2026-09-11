class MinStack {

    Stack<Integer> stack;
    Stack<Integer> support_stack;

    public MinStack() {

        stack = new Stack<> ();
        support_stack = new Stack<> ();
    }
    
    public void push(int val) {

        stack.push(val);
        if(support_stack.isEmpty() || support_stack.peek() >= val){
            support_stack.push(val);
        }   
    }
    
    public void pop() {

        if(stack.isEmpty()){
            return;
        }

        int ans = stack.peek();
        stack.pop();

        if(ans == support_stack.peek()){
            support_stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {

        if(support_stack.isEmpty()){
            return -1;
        }

        return support_stack.peek();
        
    }
}
