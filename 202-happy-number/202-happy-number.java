class Solution {
    
    public boolean isHappy(int n) {
        
        Set<Integer> seen = new HashSet<>();
        
        while(n != 1){
            
            int copy = n, sum = 0;
            
            while(copy > 0){
                sum += ((copy % 10) * (copy % 10));
                copy /= 10;
            }
            
            if(seen.contains(sum)){
                return false;
            }
            
            n = sum;
            
            seen.add(sum);
        }
        
        return true;
    }
}