class Solution {
    
    public int minAddToMakeValid(String s) {
        
        Stack<Character> stack = new Stack<>();
        
        char [] parens = s.toCharArray();
        
        int result = 0;
        
        for(char c: parens){
            if(c == '('){
                stack.push(c);
            } else {
                if(!stack.isEmpty()){
                    stack.pop();
                } else {
                    result++;
                }
            }
        }
        
        result += stack.size();
        
        return result;
    }
}