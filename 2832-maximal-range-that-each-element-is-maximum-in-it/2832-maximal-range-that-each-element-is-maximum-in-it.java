class Solution {
    
    public int[] maximumLengthOfRanges(int[] nums) {
        
        int [] result = new int[nums.length];
        
        Stack<Integer> monoStack = new Stack<>();
        monoStack.push(-1);
        
        int index = 0;
        
        while(index < nums.length){
            
            int curr = nums[index];
            
            while(monoStack.peek() != -1 && curr > nums[monoStack.peek()]){
               monoStack.pop();
            }
            
            result[index] = index - monoStack.peek();
            
            monoStack.push(index);
            
            index++;
        }
        
        monoStack = new Stack<>();
        monoStack.push(nums.length);
        index = nums.length - 1;
        
        while(index >= 0){
            
            int curr = nums[index];
            
            while(monoStack.peek() != nums.length && curr > nums[monoStack.peek()]){
               monoStack.pop();
            }
            
            result[index] += monoStack.peek() - index - 1;
            
            monoStack.push(index);
            
            index--;
        }
        
        return result;
    }
}