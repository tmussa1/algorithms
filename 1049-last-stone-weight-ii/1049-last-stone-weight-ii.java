class Solution {
    
    public int lastStoneWeightII(int[] stones) {
        
        int sum = Arrays.stream(stones).sum();
        
        int target = (sum / 2) + (sum % 2 == 0 ? 0 : 1);
        
        Integer [] [] memo = new Integer [stones.length] [target];
        
        return lastStoneWeight(stones, 0, 0, target, sum, memo);
    }
    
    private int lastStoneWeight(int[] stones, int index, int sum, int target,
                                int total,
                                Integer [] [] memo){
        
        if(index == stones.length || sum >= target){
            return Math.abs(sum - (total - sum));
        }
        
        if(memo[index][sum] != null) return memo[index][sum];
        
        int result = Integer.MAX_VALUE;
        
        result = Math.min(result, lastStoneWeight(stones, index + 1, sum + stones[index], target, total, memo));
        
        result = Math.min(result, lastStoneWeight(stones, index + 1, sum, target, total, memo));
            
        memo[index][sum] = result;
        
        return memo[index][sum];
    }
}