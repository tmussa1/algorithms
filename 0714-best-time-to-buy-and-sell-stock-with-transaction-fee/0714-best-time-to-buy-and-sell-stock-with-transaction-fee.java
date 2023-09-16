class Solution {
    public int maxProfit(int[] prices, int fee) {
        return maxProfit(prices, fee, new HashMap<>(), 0, true);
    }
    
    private int maxProfit(int[] prices, int fee, Map<String, Integer> memo, int index, boolean isBuy) {
        
        String key = isBuy + "," + index;
        
        if(index == prices.length){
            return 0;
        }
        
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        
        int result = 0;
        
        if(isBuy){
            result += Math.max(
                -(prices[index]) + maxProfit(prices, fee, memo, index + 1, !isBuy),
                 maxProfit(prices, fee, memo, index + 1, isBuy));
        } else {
            result += Math.max(
                (prices[index] - fee) + maxProfit(prices, fee, memo, index + 1, !isBuy),
                maxProfit(prices, fee, memo, index + 1, isBuy));
        }
        
        memo.put(key, result);
        
        return result;
    }
}