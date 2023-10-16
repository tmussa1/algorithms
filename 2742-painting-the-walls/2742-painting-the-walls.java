class Solution {
    
    public int paintWalls(int[] cost, int[] time) {
        
        int totalTime = cost.length;
        
        return (int) paintWalls(cost, time, 0, totalTime, new Long [totalTime + 1] [totalTime + 1]);
    }
    
    private long paintWalls(int[] cost, int[] time, int index,
                           int totalTime, Long [] [] memo) {
        
        if(totalTime <= 0){
            return 0;
        }
        
        if(index == cost.length){
            return Integer.MAX_VALUE;
        }
        
        if(memo[index][totalTime] != null){
            return memo[index][totalTime];
        }
        
        long paint = cost[index] + paintWalls(cost, time, index + 1, totalTime - time[index] - 1, memo);
        long withoutPaint = paintWalls(cost, time, index + 1, totalTime, memo);
        
        memo[index][totalTime] = Math.min(paint, withoutPaint);
        
        return memo[index][totalTime];
    }
}