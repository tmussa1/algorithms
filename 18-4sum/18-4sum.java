class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        Arrays.sort(nums);
        
        Set<List<Integer>> result = new HashSet<>();
        
        if(nums[0] > 0 && nums[0] > target){
            return new ArrayList<>(result);
        }
        
        int left = 0, right = 1;
        
        while(left < nums.length && right < nums.length){
            
            twoSum(nums, result, left, right, Long.valueOf(target));
           
            right++;
            
            if(right == nums.length){
                left++;
                right = left + 1;
            }
        }
        
        return new ArrayList<>(result);
    }
    
    private void twoSum(int[] nums, Set<List<Integer>> result, int left, int right, long target){
        
        int low = left + 1, high = right - 1;
        
        while(low < high){
            
            long sum = Long.valueOf(nums[left]) + Long.valueOf(nums[low]) + Long.valueOf(nums[high]) + Long.valueOf(nums[right]);
            
            if(sum > target){
                high--;
            } else if(sum < target){
                low++;
            } else {
                
                result.add(Arrays.asList(nums[left], nums[low++], nums[high--], nums[right]));

                while(low < high && nums[low] == nums[low - 1]){
                    low++;
                }
            }
        }
    }
}