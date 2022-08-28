class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
        List<Integer> result = new ArrayList<>();
        
        Set<Integer> seen = new HashSet<>();
        
        for(int i = 0; i < nums.length; i++){
            if(seen.contains(nums[i])){
                result.add(nums[i]);
            }
            seen.add(nums[i]);
        }
        return result;
    }
}