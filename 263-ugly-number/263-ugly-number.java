class Solution {
    public boolean isUgly(int n) {
        
        if(n == 0) return false;
            
        if(n == 1) return true;
            
        boolean divisible = true;
        
        while(divisible){
            
            divisible = false;
            
            if(n % 2 == 0){
                n /= 2;
                divisible = true;
            } else if(n % 3 == 0){
                n /= 3;
                divisible = true;
            } else if(n % 5 == 0){
                n /= 5;
                divisible = true;
            }
        }
        
        return n == 1;
    }
}