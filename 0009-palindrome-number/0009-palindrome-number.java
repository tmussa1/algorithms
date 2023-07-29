class Solution {
    public boolean isPalindrome(int x) {
        
        if(x < 0) return false;
        
        int reversed = 0, num = x;
        
        while(num > 0){
            reversed = 10 * reversed + (num % 10);
            num /= 10;
        }
        return reversed == x;
    }
}