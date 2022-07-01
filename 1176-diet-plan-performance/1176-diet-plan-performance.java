class Solution {
    
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        
        int sum = 0;
        
        for(int i = 0; i < k; i++){
            sum += calories[i];
        }
        
        int result = sum < lower ? -1 : sum > upper ? 1 : 0;
        
        for(int i = k; i < calories.length; i++){
            
            sum = sum + calories[i] - calories[i - k];
            
            result += sum < lower ? -1 : sum > upper ? 1 : 0;
        }
        
        return result;
    }
}