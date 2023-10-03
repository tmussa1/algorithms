class Solution {
    
    public String removeStars(String s) {
        
        Stack<Character> stack = new Stack<>();
        
        char [] sArr = s.toCharArray();
        
        for(char c: sArr){
            if(c == '*'){
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        
        StringBuilder builder = new StringBuilder();
        
        while(!stack.isEmpty()){
            builder.append(stack.pop());
        }
        
        return builder.reverse().toString();
    }
}