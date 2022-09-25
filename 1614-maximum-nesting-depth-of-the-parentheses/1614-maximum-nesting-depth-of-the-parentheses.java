class Solution {
    public int maxDepth(String s) {
        
        Stack<Character> parens = new Stack<>();
        
        int maxNest = Integer.MIN_VALUE;
        
        for(int i = 0; i < s.length(); i++){
            char currChar = s.charAt(i);
            if(currChar == '('){
                parens.push(currChar);
            } else if(currChar == ')'){
                parens.pop();
            }
            
            maxNest = Math.max(maxNest, parens.size());
        }
        
        return maxNest;
    }
}