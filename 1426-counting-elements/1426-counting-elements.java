class Solution {
    public int countElements(int[] arr) {
        
        Set<Integer> nums = new HashSet<>();
        
        int result = 0;
        
        for(int i = 0; i < arr.length; i++){
            nums.add(arr[i]);
        }
        
        for(int i = 0; i < arr.length; i++){
            if(nums.contains(arr[i] + 1)){
                result++;
            }
        }
        
        return result;
    }
}