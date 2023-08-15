class Solution {
    
    public int coinChange(int[] coins, int amount) {
        
        int result = coinChange(coins, amount, new Integer[amount + 1]);
        return result;
    }
    
    private int coinChange(int[] coins, int amount, Integer [] memo) {
        
        if(amount == 0) return 0;
        
        if(amount < 0) return -1;
        
        if(memo[amount] != null) return memo[amount];
        
        int minWays = Integer.MAX_VALUE;
        
        for(int i = 0; i < coins.length; i++){
            int ways = coinChange(coins, amount - coins[i], memo);
            if(ways != -1){
                minWays = Math.min(ways + 1, minWays);
            }
        }
        
        memo[amount] = (minWays == Integer.MAX_VALUE) ? -1 : minWays;
        
        return memo[amount];
    }
}