class Solution {
    
    public int[] nextGreaterElements(int[] nums) {
        
        Stack<Integer> indices = new Stack<Integer>();
        
        int index = 0, trips = 0;
        
        int [] result = new int[nums.length];
        Arrays.fill(result, - 1);
        
        while(index < nums.length && trips < 2){
            
            while(!indices.isEmpty() && nums[indices.peek()] < nums[index]){
                result[indices.pop()] = nums[index];
            }
            
            if(result[index] == -1)
                indices.push(index);
            
            index++;
            
            if(index == nums.length){
                index = 0;
                trips++;
            }
        }
        
        result[indices.pop()] = -1;
        
        return result;
    }
}