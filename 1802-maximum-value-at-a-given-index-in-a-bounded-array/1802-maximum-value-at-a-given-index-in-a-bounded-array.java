class Solution {
    
    public int maxValue(int n, int index, int maxSum) {
        
        if(n == maxSum) return 1;
        
        int left = 1, right = maxSum, result = 0;
        
        long max = maxSum;
        
        while(left <= right){
            
            int mid = left + ((right - left) / 2);
            
            if(canPlace(n, index, mid, max)){
                left = mid + 1;
                result = Math.max(result, mid);
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    private boolean canPlace(int n, int index, int value, long maxSum){
        
        long sum = 0;
        
        if (value >= n - index) {
            sum += (long)(value + value - n + 1 + index) * (n - index) / 2;
        } else {
            sum += (long)(value + 1) * value / 2 + n - index - value;
        } 
        
        if (value > index) {
            sum += (long)(value + value - index) * (index + 1) / 2;
        } else {
            sum += (long)(value + 1) * value / 2 + index - value + 1;
        };
        
        return sum - value <= maxSum;
    }
}