class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<> ();
        int n = tokens.length;
        int ans = 0;

        for(int i = 0; i < n; i++){
            if(!tokens[i].equals("+") &&
                !tokens[i].equals("-") &&
                !tokens[i].equals("*") &&
                !tokens[i].equals("/"))
            {
                stack.push(Integer.parseInt(tokens[i]));
            }
            else{
                int b = stack.pop();
                int a = stack.pop();

                if(tokens[i].equals("+")){
                    ans = a + b;
                }
                else if(tokens[i].equals("-")){
                    ans = a - b;
                }
                else if(tokens[i].equals("*")){
                    ans = a * b;
                }
                else if(tokens[i].equals("/")){
                    ans = a / b;
                }
                stack.push(ans);
            }
        }
        return stack.pop();
    }
}
