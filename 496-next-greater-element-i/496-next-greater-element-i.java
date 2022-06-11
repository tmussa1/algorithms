class Solution {
    
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        Map<Integer, Integer> num1Map = new HashMap<>();
        
        for(int i = 0; i < nums1.length; i++){
            num1Map.put(nums1[i], i);
        }
        
        Stack<Integer> monoStack = new Stack<>();
        int [] result = new int[nums1.length];
        Arrays.fill(result, -1);
        
        for(int i = 0; i < nums2.length; i++){
            
            int curr = nums2[i];
            
            while(!monoStack.isEmpty() && curr > monoStack.peek()){
                int val = monoStack.pop();
                int index = num1Map.get(val);
                result[index] = curr;
            }
            
            if(num1Map.containsKey(curr)){
                monoStack.push(curr);
            }
        }
        
        return result;
    }
}