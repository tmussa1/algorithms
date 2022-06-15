class Solution {
    
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        
        Stack<Integer> stack = new Stack<>();
        
        int index = 0, poppedIndex = 0;
        
        while(index < pushed.length){
            stack.push(pushed[index]);
            
            while(poppedIndex < popped.length && !stack.isEmpty() && stack.peek() == popped[poppedIndex]){
                stack.pop();
                poppedIndex++;
            }
            
            index++;
        }
        
        return stack.isEmpty();
    }
}