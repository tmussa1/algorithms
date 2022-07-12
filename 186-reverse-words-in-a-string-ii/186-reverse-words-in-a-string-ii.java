class Solution {
    
    public void reverseWords(char[] s) {
        
        int left = 0, right = s.length - 1;
        
        while(left < right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
        
        left = 0;
        right = s.length - 1;
        
        while(left <= right){
            
            int begin = left;
            
            while(left <= right && s[left] != ' '){
                left++;
            }
            
            int end = left - 1;
            
            while(begin < end){
                char temp = s[begin];
                s[begin] = s[end];
                s[end] = temp;
                begin++;
                end--;
            }
            
            left++;
        }
    }
}