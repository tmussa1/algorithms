class Solution {
    
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();
        
        char [] chars = s.toCharArray();
        
        for(char c: chars){
            
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            } else {
                
                if(stack.isEmpty()) return false;
                    
                char top = stack.peek();
                
                if(c == ')' && top == '('){
                    stack.pop();
                } else if(c == ']' && top == '['){
                    stack.pop();
                } else if(c == '}' && top == '{'){
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}