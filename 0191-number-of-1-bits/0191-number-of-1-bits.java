public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        
        long num = n & 0xFFFFFFFFL;
        
        int one = 1, result = 0;
        
        while(num > 0){
            
           if((num & one) == 1) {
               result++;
           }
            
           num = num >> 1;
        }
        
        return result;
    }
}