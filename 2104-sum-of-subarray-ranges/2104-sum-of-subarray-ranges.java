class Solution {
    
    public long subArrayRanges(int[] nums) {
        
        int right = 0;
        long result = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        while(right <= nums.length){
            while(!stack.isEmpty() && (right == nums.length || nums[stack.peek()] >= nums[right])){
                int mid = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                long count = (mid - left) * (right - mid);
                result -= nums[mid] * count;
            }
            stack.push(right);
            right++;
        }
        
        stack = new Stack<>();
        right = 0;
        
        while(right <= nums.length){
            while(!stack.isEmpty() && (right == nums.length || nums[stack.peek()] <= nums[right])){
                int mid = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                long count = (mid - left) * (right - mid);
                result += nums[mid] * count;
            }
            stack.push(right);
            right++;
        }
        
        
        return result;
    }
}