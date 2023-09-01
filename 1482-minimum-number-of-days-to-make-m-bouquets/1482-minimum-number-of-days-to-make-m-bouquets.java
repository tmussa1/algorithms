class Solution {
    
    public int minDays(int[] bloomDay, int m, int k) {
        
        if(m * k > bloomDay.length) return -1;
        
        int max = Arrays.stream(bloomDay).max().getAsInt();
        
        int right = max, left = 1;
        
        while(left <= right){
            
            int mid = left + ((right - left) / 2);
            
            if(isPossible(bloomDay, mid, m, k)){
                right = mid - 1;
            } else {
                left = mid + 1; 
            }
        }
        
        return left <= max ? left : -1;
    }
    
    private boolean isPossible(int[] bloomDay, int value, int m, int k){
        
        int count = 0, sum = 0;
        
        for(int bloom: bloomDay){
            
            if(bloom <= value){
                count++;
            } else {
                count = 0;
            }
            
            if(count == k){
                count = 0;
                sum++;
            }
            
        }
        
        return sum >= m;
    }
}