// O(1)
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

//O(n)

// class MinStack {

//     Stack<Integer> stack;
//     Stack<Integer> support_stack;

//     public MinStack() {

//         stack = new Stack<> ();
//         support_stack = new Stack<> ();
//     }
    
//     public void push(int val) {

//         stack.push(val);
//         if(support_stack.isEmpty() || support_stack.peek() >= val){
//             support_stack.push(val);
//         }   
//     }
    
//     public void pop() {

//         if(stack.isEmpty()){
//             return;
//         }

//         int ans = stack.peek();
//         stack.pop();

//         if(ans == support_stack.peek()){
//             support_stack.pop();
//         }
//     }
    
//     public int top() {
//         return stack.peek();
//     }
    
//     public int getMin() {

//         if(support_stack.isEmpty()){
//             return -1;
//         }

//         return support_stack.peek();
        
//     }
// }

