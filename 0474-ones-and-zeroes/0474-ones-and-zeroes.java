class Solution {
    
    public int findMaxForm(String[] strs, int m, int n) {
        
        Map<String, Integer> zeroCount = new HashMap<>();
        Map<String, Integer> oneCount = new HashMap<>();
        
        for(String str: strs){
            
            char [] chars = str.toCharArray();
            
            int zeroes = 0, ones = 0;
            
            for(char c: chars){
                if(c == '0'){
                    zeroes++;
                } else {
                    ones++;
                }
            }
            
            zeroCount.put(str, zeroes);
            oneCount.put(str, ones);
        }
        
        Integer [] [] [] memo = new Integer[strs.length][m + 1][n + 1];
        
        return backtrack(zeroCount, oneCount, memo, strs, 0, m, n);
    }
    
    private int backtrack(Map<String, Integer> zeroCount,
                          Map<String, Integer> oneCount,
                          Integer [] [] [] memo,
                          String [] strs,
                          int index,
                          int m, int n){
        
        if(index == strs.length){
            return 0;
        }
        
        if(memo[index][m][n] != null) return memo[index][m][n];
        
        int zeros = zeroCount.get(strs[index]);
        int ones = oneCount.get(strs[index]);
        
        int without = backtrack(zeroCount, oneCount, memo, strs, index + 1, m, n);
        int with = 0;
        
        if(m - zeros >= 0 && n - ones >= 0){
            with = 1 + backtrack(zeroCount, oneCount, memo, strs, index + 1, m - zeros, n - ones);
        }
        
        memo[index][m][n] = Math.max(with, without);
        
        return memo[index][m][n];
    }
}