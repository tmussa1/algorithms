class Solution {
    
    public int numRollsToTarget(int n, int k, int target) {
        
        Integer [] [] memo = new Integer[n + 1][target + 1];
        
        int result = backtrack(n, k, target, memo);
            
        return result;
    }
    
    private int backtrack(int n, int k, int target, Integer [] [] memo){
        
        if(n < 0 || target < 0){
            return 0;
        }
        
        if(n == 0){
            return target == 0 ? 1 : 0;
        }
        
        if(memo[n][target] == null){
            long result = 0L;
            for(int die = 1; die <= k; die++){
                result += backtrack(n - 1, k, target - die, memo);
                memo[n][target] = (int) (result % (Math.pow(10, 9) + 7));
            }
        }
        
        return memo[n][target];
    }
}