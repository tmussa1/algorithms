class Solution {
    
    public String longestPalindrome(String s) {
        
        int result = 1, index = 0, left = 0, right = 0;
        
        char [] cArr = s.toCharArray();
        
        while(index < s.length()){
            
            int [] outwards = isPalindrome(cArr, index, index);
            
            int [] middle = isPalindrome(cArr, index, index + 1);
            
            if(outwards[0] > result){
                result = outwards[0];
                left = outwards[1];
                right = outwards[2];
            }
            
            if(middle[0] > result){
                result = middle[0];
                left = middle[1];
                right = middle[2];
            }
            
            index++;
        }
        
        return left + 1 <= right ? s.substring(left + 1, right) : s.substring(0, 1);
    }
    
    private int [] isPalindrome(char [] cArr, int left, int right){
        
        while(left >= 0 && right < cArr.length && cArr[left] == cArr[right]){
            left--;
            right++;
        }
        
        int [] result = new int[3];
        result[0] = (right - left - 1);
        result[1] = left;
        result[2] = right;
        
        return result;
    }
}