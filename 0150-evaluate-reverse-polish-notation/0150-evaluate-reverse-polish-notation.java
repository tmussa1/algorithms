class Solution {
    
    
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> operands = new Stack<>();
        
        for(String token: tokens){
            
            if(isDigit(token) || isNegative(token)){
                if(isNegative(token)){
                    int num = Integer.parseInt(token.substring(1));
                    num *= -1;
                    operands.push(num);
                } else {
                    int num = Integer.parseInt(token);
                    operands.push(num);
                }
            } else if(token.equals("+") || token.equals("-") || token.equals("*")
                     || token.equals("/")){
                if(token.equals("+")){
                    int num1 = operands.pop(), num2 = operands.pop();
                    operands.push(num1 + num2);
                } else if(token.equals("-")){
                    int num1 = operands.pop(), num2 = operands.pop();
                    operands.push(num2 - num1);
                } else if(token.equals("*")){
                    int num1 = operands.pop(), num2 = operands.pop();
                    operands.push(num1 * num2);
                } else if(token.equals("/")){
                    int num1 = operands.pop(), num2 = operands.pop();
                    operands.push(num2 / num1);
                }
            }
        }
        
        return operands.pop();
    }
    
    
    private boolean isNegative(String token){
        return token.charAt(0) == '-' && token.length() > 1 && isDigit(token.substring(1));
    }
    
    private boolean isDigit(String token){
        char [] chars = token.toCharArray();
        return IntStream.range(0, token.length()).map(i -> chars[i])
            .allMatch(c -> Character.isDigit(c));
    }
}