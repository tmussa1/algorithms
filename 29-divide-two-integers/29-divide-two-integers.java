class Solution {
    public int divide(int dividend, int divisor) {
            
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if(dividend == Integer.MIN_VALUE && divisor == Integer.MIN_VALUE) return 1;
        if(dividend == Integer.MIN_VALUE && divisor == 1) return Integer.MIN_VALUE;
        if(dividend == Integer.MAX_VALUE && divisor == 1) return Integer.MAX_VALUE;
        
        
        if(dividend < 0 && divisor < 0){
          return divideHelper(dividend, divisor);
        }
        
        if(dividend < 0 || divisor < 0){
          return -1 * divideHelper(dividend, divisor);
        }
        
        return divideHelper(dividend, divisor);
    }
    
    public int divideHelper(int dividend, int divisor) {
        
        if(dividend > 0){
            dividend = -dividend;
        }
        
        if(divisor > 0){;
            divisor = -divisor;
        }
        
        int quotient = 0;
        
        while(dividend - divisor <= 0){
            quotient++;
            dividend -= divisor;
        }
        
        return quotient;
    }
}