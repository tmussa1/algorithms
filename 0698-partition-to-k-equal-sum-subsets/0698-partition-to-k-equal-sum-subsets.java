class Solution {
    
    public boolean canPartitionKSubsets(int[] nums, int k) {
        
        Arrays.sort(nums);
        
        long sum = Arrays.stream(nums).sum();
        
        if(sum % k != 0) return false;
        
        long target = sum / k;
        
        char [] charr = new char [nums.length];
        
        Arrays.fill(charr, '0');
        
        return sums(nums, k, 0, 0L, target, 0, charr, new HashMap<>());
    }
    
    private boolean sums(int[] nums, int k, int index, long sum, long target, int count, char [] cache, Map<String, Boolean> memo){
        
       String key = new String(cache);
        
       if(count == k - 1) {
           return true;
       }
        
       if(sum > target || index == nums.length) {
           return false;
       }
        
       if(memo.containsKey(key)){
          return memo.get(key);
       }
        
       boolean result = sums(nums, k, index + 1, sum, target, count, cache, memo);
        
       if(sum == target){
           result |= sums(nums, k, 0, 0L, target, count + 1, cache, memo);
           memo.put(key, result);
          // return result;
       }
        
       if(cache[index] == '0'){
         cache[index] = '1';
         result |= sums(nums, k, index + 1, sum + nums[index], target, count, cache, memo); 
         cache[index] = '0';
       }
        
       memo.put(key, result);
        
       return result;
    }
}