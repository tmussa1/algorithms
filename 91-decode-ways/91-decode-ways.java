class Solution {
    public int numDecodings(String s) {
        
        Integer [] memo = new Integer[s.length() + 1];
        
        return backtrack(0, s, memo);
    }
    
    private int backtrack(int index, String s, Integer [] memo){
        
        if(index == s.length()){
            return 1;
        }
        
        if(memo[index] != null){
            return memo[index];
        }
        
        int result = 0;
            
        if(isValid(s.substring(index, index + 1))){
            result += backtrack(index + 1, s, memo);
        } 

        if(index < s.length() - 1 && isValid(s.substring(index, index + 2))){
            result += backtrack(index + 2, s, memo);
        }
        
        memo[index] = result;
        
        return memo[index];
    }
    
    private boolean isValid(String substring){
        return substring.length() > 0 
            && substring.charAt(0) != '0'
            && Integer.parseInt(substring) >= 1 
            && Integer.parseInt(substring) <= 26;
    }
}