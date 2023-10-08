class Solution {
    
    public long maxAlternatingSum(int[] nums) {
        return maxAlternatingSum(nums, true, 0, new HashMap<>());
    }
    
    private long maxAlternatingSum(int[] nums, boolean isEven, int index,
                                   Map<String, Long> cache) {
        
        String key = isEven + "," + index;
        
        if(index == nums.length){
            return 0;
        }
        
        if(cache.containsKey(key)){
            return cache.get(key);
        }
        
        long result = 0;
        
        if(isEven){
            long add = nums[index] + maxAlternatingSum(nums, !isEven, index + 1, cache);
            long notAdd = maxAlternatingSum(nums, isEven, index + 1, cache);
            result = Math.max(add, notAdd);
        } else {
            long add = -nums[index] + maxAlternatingSum(nums, !isEven, index + 1, cache);
            long notAdd = maxAlternatingSum(nums, isEven, index + 1, cache);
            result = Math.max(add, notAdd);
        }
        
        cache.put(key, result);
        
        return result;
    }
}