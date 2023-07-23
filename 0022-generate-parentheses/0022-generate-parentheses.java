class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> result = new ArrayList<>();
        
        backtrack(result, new StringBuilder(), 0, 0, n);
        
        return result;
    }
    
    private void backtrack(List<String> result, StringBuilder builder, 
                           int openCount, int closeCount, int n){
        
        if(builder.length() == 2 * n){
            result.add(new String(builder.toString()));
            return;
        }
        
        if(openCount < n){
            builder.append("(");
            backtrack(result, builder, openCount + 1, closeCount, n);
            builder.deleteCharAt(builder.length() - 1);
        }
        
        if(openCount > closeCount){
            builder.append(")");
            backtrack(result, builder, openCount, closeCount + 1, n);
            builder.deleteCharAt(builder.length() - 1);            
        }
    }
}