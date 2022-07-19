class Solution {
    
    public int coinChange(int[] coins, int amount) {
        
        int [] dp = new int [amount + 1];
        
        Arrays.fill(dp, amount + 1);
        
        dp[0] = 0;
        
        for(int j = 1; j <= amount; j++){
            for(int i = 0; i < coins.length; i++){
                if(j - coins[i] >= 0){
                    dp[j] = Math.min(dp[j], 1 + dp[j - coins[i]]);
                } 
            }
        }
        
        return dp[amount] <= amount ? dp[amount] : -1;
    }
}