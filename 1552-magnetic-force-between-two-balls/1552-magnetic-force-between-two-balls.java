class Solution {
    
    public int maxDistance(int[] position, int m) {
        
        Arrays.sort(position);
        
        int left = 1, right = position[position.length - 1], result = 0;
        
        while(left <= right){
            
            int mid = left + ((right - left) / 2);
            
            if(canPlace(position, mid, m)){
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    private boolean canPlace(int[] position, int value, int m){
        
        int prevValue = position[0], count = 1;
        
        for(int pos: position){
            if(Math.abs(pos - prevValue) >= value){
                prevValue = pos;
                count++;
            }
        }
        
        return count >= m;
    }
}