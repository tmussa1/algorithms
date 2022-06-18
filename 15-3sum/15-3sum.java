class Solution {
    
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i = 0; i < nums.length && nums[i] <= 0; i++){
            if(i == 0 || nums[i - 1] != nums[i]){
                twoSum(nums, i, result);
            }
        }
        
        return result;
    }
    
    private void twoSum(int[] nums, int index, List<List<Integer>> result){
        
        int low = index + 1, high = nums.length - 1;
        
        while(low < high){
            
            int sum = nums[index] + nums[low] + nums[high];
            
            if(sum < 0){
                low++;
            } else if(sum > 0){
                high--;
            } else {
                
                result.add(new ArrayList<>(Arrays.asList(nums[index], nums[low++], nums[high--])));
                
                while(low < high && nums[low] == nums[low - 1]){
                    low++;
                }
            }
        }
    }
}