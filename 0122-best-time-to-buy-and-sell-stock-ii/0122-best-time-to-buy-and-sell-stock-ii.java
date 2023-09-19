class Solution {
    public int maxProfit(int[] prices) {
        return maxProfit(prices, new HashMap<>(), 0, true);
    }
    
    private int maxProfit(int[] prices, Map<String, Integer> memo, int index, boolean bought) {
        
        String key = bought + "," + index;
        
        if(index == prices.length){
            return 0;
        }
        
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        
        int result = 0;
        
        if(bought){
            result += Math.max(-(prices[index]) + maxProfit(prices, memo, index + 1, !bought),
                               maxProfit(prices, memo, index + 1, bought));
        } else {
            result += Math.max((prices[index]) + maxProfit(prices, memo, index + 1, !bought),
                               maxProfit(prices, memo, index + 1, bought));
        }
        
        memo.put(key, result);
        
        return memo.get(key);
    }
}