class Solution {
    
    public int numDistinct(String s, String t) {
        return numDistinct(s, t, 0, 0, new Integer[s.length()][t.length()]);
    }
    
    private int numDistinct(String s, String t, int sIndex, int tIndex,
                            Integer [] [] memo) {
        
        if(tIndex == t.length()){
            
            if(sIndex < s.length()){
                tIndex = 0;
            }
            
            return 1;
        }
        
        if(sIndex == s.length()){
            return 0;
        }
        
        if(memo[sIndex][tIndex] != null) return memo[sIndex][tIndex];
        
        int result = 0;
        
        if(s.charAt(sIndex) == t.charAt(tIndex)){
            result += numDistinct(s, t, sIndex + 1, tIndex + 1, memo);
        }
        
        result += numDistinct(s, t, sIndex + 1, tIndex, memo);
        
        memo[sIndex][tIndex] = result;
        
        return memo[sIndex][tIndex];
    }
}