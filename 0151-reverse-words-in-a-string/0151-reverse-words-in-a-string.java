class Solution {
    
    
    public String reverseWords(String s) {
        
        char [] sArray = s.toCharArray();
            
        int left = 0, right = s.length() - 1;
        
        reverse(sArray, left, right);
        
        int leftIndex = 0, rightIndex = 0;
        
        StringBuilder builder = new StringBuilder();
        
        while(rightIndex < s.length()){
            if(sArray[rightIndex] == ' '){
                reverse(sArray, leftIndex, rightIndex - 1);
                builder.append(String.copyValueOf(sArray, leftIndex, rightIndex - leftIndex) + " ");
                while(rightIndex < s.length() && sArray[rightIndex] == ' '){
                    rightIndex++;
                }
                leftIndex = rightIndex;
            } else {
                rightIndex++;
            }
        }
        
        reverse(sArray, leftIndex, rightIndex - 1);
        builder.append(String.copyValueOf(sArray, leftIndex, rightIndex - leftIndex));
        
        return builder.toString().trim();
    }
    
    private void reverse(char [] sArray, int left, int right){
        while(left <= right){
            swap(sArray, left, right);
            left++;
            right--;
        }
    }
    
    private void swap(char [] sArray, int left, int right){
        char temp = sArray[left];
        sArray[left] = sArray[right];
        sArray[right] = temp;
    }
}