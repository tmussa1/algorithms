class Solution {
    
    public int maxProfit(int[] prices) {
        
        int [] dp = new int[prices.length];
        dp[0] = 0;
        
        for(int i = 1; i < prices.length; i++){
            dp[i] = Math.max(dp[i - 1] + prices[i] - prices[i - 1], prices[i] - prices[i - 1]);
        }
        
        int max = 0;
        
        for(int i = 0; i < dp.length; i++){
            if(dp[i] > max){
                max = dp[i];
            }
        }
        
        return max;
    }
}