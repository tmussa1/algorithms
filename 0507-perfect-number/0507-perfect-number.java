class Solution {
    
    public boolean checkPerfectNumber(int num) {
        
        int divisors = 0;
        
        for(int i = 1; i < (num / 2) + 1; i++){
            if(num % i == 0){
                divisors += i;
            }
        }
        
        return divisors == num;
    }
}