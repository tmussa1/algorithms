class Solution {
    
    public String removeDuplicates(String s) {
        
        int index = 0;
        
        Stack<Character> stack = new Stack<>();
        
        StringBuilder builder = new StringBuilder();
        
        while(index < s.length()){
            
            char currC = s.charAt(index);
            
            if(!stack.isEmpty() && stack.peek() == currC){
                stack.pop();
            } else {
                stack.push(currC);
            }
            
            index++;
        }
        
        while(!stack.isEmpty()){
            builder.append(stack.pop());
        }
        
        return builder.reverse().toString();
    }
}