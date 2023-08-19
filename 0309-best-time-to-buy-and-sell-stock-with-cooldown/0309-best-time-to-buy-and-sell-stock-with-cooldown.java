class Solution {
    
    public int maxProfit(int[] prices) {
        return maxProfit(prices, new HashMap<>(), true, 0);
    }
    
    private int maxProfit(int[] prices, Map<String, Integer> memo, 
                          boolean buying, int index) {
        
        String key = buying + "," + index;
            
        if(index >= prices.length){
            return 0;
        }
        
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        
        int cooldown = maxProfit(prices, memo, buying, index + 1);
        
        if(buying){
            int sell = -prices[index] + maxProfit(prices, memo, !buying, index + 1);
            memo.put(key, Math.max(sell, cooldown));
        } else {
            int buy = prices[index] + maxProfit(prices, memo, !buying, index + 2);
            memo.put(key, Math.max(buy, cooldown));
        }
        
        return memo.get(key);
    }
}