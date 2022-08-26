class Solution {
    
    public int maxScoreSightseeingPair(int[] values) {
        
        int runningSum = 0, result = 0;
        
        for(int i = 0; i < values.length; i++){
            result = Math.max(result, runningSum + values[i]);
            if(values[i] > runningSum){
                runningSum = values[i];
            } 
            runningSum--;
        }
        
        return result;
    }
}
