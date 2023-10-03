class Solution {
    
    public int arrangeCoins(int n) {
        
        long sum = 0;
        
        int result = 0;
        
        long left = 1, right = n;
        
        while(left <= right){
            
            long num = left + ((right - left) / 2);
            
            sum = (num * (num + 1)) / 2;
            
            if(sum == n) return (int) num;
            
            if(sum <= n) {
               left = num + 1;
            } else {
               right = num - 1;
            }
        }
        
        return (int) right;
    }
}