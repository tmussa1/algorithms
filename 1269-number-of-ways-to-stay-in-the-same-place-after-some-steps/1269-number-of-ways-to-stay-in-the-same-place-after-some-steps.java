class Solution {
    
    public int numWays(int steps, int arrLen) {
        return (int) numWays(steps, 0, arrLen, new HashMap<>());
    }
    
    private long numWays(int steps, int arrLen, int max, Map<String, Long> memo) {
        
        long mod = 1_000_000_007;
        
        String key = steps + "," + arrLen;
        
        if(steps == 0){
            return arrLen == 0 ? 1 : 0;
        }
        
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        
        long result = (numWays(steps - 1, arrLen, max, memo) % mod);
        
        if(arrLen > 0){
           result = (result + numWays(steps - 1, arrLen - 1, max, memo) % mod);
        }
        
        if(arrLen < max - 1) {
            result = (result + numWays(steps - 1, arrLen + 1, max, memo) % mod); 
        }
        
        memo.put(key, result % mod);
        
        return memo.get(key);
    }
}