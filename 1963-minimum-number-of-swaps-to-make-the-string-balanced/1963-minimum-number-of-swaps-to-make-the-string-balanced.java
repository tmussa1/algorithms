class Solution {
    
    public int minSwaps(String s) {
        
        char [] parenArray = s.toCharArray();
        
        int left = 0, right = s.length() - 1;
        
        int swapCount = 0;
        
        Stack<Character> stack = new Stack<>();
        
        while(left < right){
            
            if(parenArray[left] == ']'){
                if(stack.isEmpty()){
                    swap(parenArray, left, right);
                    right--;
                    swapCount++;
                    stack.push('[');
                } else {
                    stack.pop();
                }
            } else if(parenArray[left] == '['){
                stack.push(parenArray[left]);
            } 
            
            left++;
        }
        
        return swapCount;
    }
    
    private void swap(char [] parenArray, int left, int right){
        
        char temp = parenArray[left];
        parenArray[left] = parenArray[right];
        parenArray[right] = temp;
    }
}