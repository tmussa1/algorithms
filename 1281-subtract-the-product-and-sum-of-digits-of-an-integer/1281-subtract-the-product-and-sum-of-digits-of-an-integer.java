class Solution {
    
    public int subtractProductAndSum(int n) {
        
        int sumDigits = 0, prodDigits = 1;
        
        while(n > 0){
            sumDigits += (n % 10);
            prodDigits *= (n % 10);
            n /= 10;
        }
        
        return prodDigits - sumDigits;
    }
}