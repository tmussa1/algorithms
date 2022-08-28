class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> numberToCountMap = new HashMap<>();
        int size = nums.length / 2;
        
        for(int i = 0; i < nums.length; i++){        
            if(numberToCountMap.containsKey(nums[i])){
                Integer value = numberToCountMap.get(nums[i]);
                numberToCountMap.replace(nums[i], value + 1);
                if(value + 1 > size){
                    return nums[i];
                }
            } else {
                numberToCountMap.put(nums[i], 1);
            }
        }
        
        return nums[0];
    }
}