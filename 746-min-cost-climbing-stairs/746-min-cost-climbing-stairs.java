class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int [] memo = new int[cost.length + 1];
            
        return Math.min(minCostClimbingStairs(cost, 0, memo),
                        minCostClimbingStairs(cost, 1, memo));
    }
    
    private int minCostClimbingStairs(int[] cost, int index, int [] memo){
        
        if(index >= cost.length){
            return 0;
        }
        
        if(memo[index] > 0){
            return memo[index];
        }
        
        memo[index] = cost[index] + 
              Math.min(minCostClimbingStairs(cost, index + 1, memo),
                       minCostClimbingStairs(cost, index + 2, memo));
        
        return memo[index];
    }
}