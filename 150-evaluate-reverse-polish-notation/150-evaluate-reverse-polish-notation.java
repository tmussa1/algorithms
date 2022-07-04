class Solution {
    
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < tokens.length; i++){
            
            String token = tokens[i];
                
            if(isDigit(token)){
                if(isNegative(token)){
                    stack.push(-1 * Integer.parseInt(token.substring(1)));
                } else {
                    stack.push(Integer.parseInt(token));
                }
            } else {
                
                int num1 = stack.pop();
                int num2 = stack.pop();
                
                switch(token.charAt(0)){
                    case '/': {
                        stack.push(num2 / num1);
                        break;
                    }
                    case '-': {
                        stack.push(num2 - num1);
                        break;
                    }
                    case '*': {
                        stack.push(num2 * num1);
                        break;
                    }
                    case '+': {
                        stack.push(num2 + num1);
                        break;
                    }
                }
                
            }
        }
        
        return stack.pop();
    }
    
    boolean isDigit(String token){
        return Character.isDigit(token.charAt(0)) || (token.length() > 1 && token.substring(1).matches("\\d+"));
    }
    
    boolean isNegative(String token){
        return token.length() > 1 && token.charAt(0) == '-' && token.substring(1).matches("\\d+");
    }
}