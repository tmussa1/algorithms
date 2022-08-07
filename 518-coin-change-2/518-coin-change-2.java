class Solution {
    
    public int change(int amount, int[] coins) {
        
        Integer [] [] cache = new Integer [amount + 1][coins.length];
        
        return coinChange(0, coins, amount, cache);
    }
    
    private int coinChange(int index, int [] coins, int amount,  Integer [] [] cache){
        
        if(amount == 0){
            return 1;
        }
        
        if(index == coins.length || amount < 0) {
            return 0;
        }
        
        if(cache[amount][index] != null){
            return cache[amount][index];
        }
        
        int result = coinChange(index, coins, amount - coins[index], cache)
                    + coinChange(index + 1, coins, amount, cache);
        
        cache[amount][index] = result;
        
        return cache[amount][index];
    }
}