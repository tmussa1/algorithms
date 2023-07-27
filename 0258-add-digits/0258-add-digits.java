class Solution {
    
    public int addDigits(int num) {
        
        int result = 0;
        
        while(num / 10 > 0){
            
            int currNum = num, sum = 0;
            
            while(currNum > 0){
                sum += (currNum % 10);
                currNum /= 10;
            }
            
            num = sum;
        }
        
        return num;
    }
}