class Solution {
    
    public int calPoints(String[] operations) {
        
        Stack<String> stack = new Stack<>();
        
        for(String op: operations){
            
            if(op.equals("C")){
                stack.pop();
            } else if(op.equals("D")){
                int num1 = Integer.parseInt(stack.peek());
                stack.push((num1 * 2) + "");
            } else if(op.equals("+")){
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.peek());
                stack.push((num1) + "");
                stack.push((num1 + num2) + "");
            } else {
                stack.push(op);
            }
        }
        
        int sum = 0;
        
        while(!stack.isEmpty()){
            sum += Integer.parseInt(stack.pop());
        }
        
        return sum;
    }
}