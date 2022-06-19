class Solution {
    
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> reverseStack = new Stack<>();
        stack.push(asteroids[0]);
        
        for(int i = 1; i < asteroids.length; i++){
        
            int curr = asteroids[i];
            
            if(curr < 0){
                
                if(!stack.isEmpty() && Math.abs(curr) < stack.peek()){
                    continue;
                }
                
                while(!stack.isEmpty() && stack.peek() > 0 && Math.abs(curr) > stack.peek()){
                    stack.pop();
                }
                
                if(!stack.isEmpty() && Math.abs(curr) == stack.peek()){
                    stack.pop();
                    continue;
                }
                
                if(stack.isEmpty() || Math.abs(curr) > stack.peek()){
                    stack.push(curr);
                }
            } else {
                stack.push(curr);
            }
        }
        
        while(!stack.isEmpty()){
            reverseStack.push(stack.pop());
        }
        
        int [] result = new int[reverseStack.size()];
        int count = 0;
        
        while(!reverseStack.isEmpty()){
            result[count++] = reverseStack.pop();
        }
        
        return result;
    }
}