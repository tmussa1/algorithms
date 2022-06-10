class Solution {
    
    public List<String> generateParenthesis(int n) {
        
        List<String> result = new ArrayList<>();
        
        generateParenthesis(n, result, new StringBuilder(), 0, 0);
        
        return result;
    }
    
    public void generateParenthesis(int n, List<String> result, StringBuilder currStr, int openCount, int closeCount) {
    
        if(currStr.toString().length() == 2 * n) {
            result.add(currStr.toString());
            return;
        }
        
        if(openCount < n){
            currStr.append("(");
            generateParenthesis(n, result, currStr, openCount + 1, closeCount);
            currStr.deleteCharAt(currStr.length() - 1);
        }
        
        if(closeCount < n && closeCount < openCount){
            currStr.append(")");
            generateParenthesis(n, result, currStr, openCount, closeCount + 1);
            currStr.deleteCharAt(currStr.length() - 1);
        }
    }
    
}