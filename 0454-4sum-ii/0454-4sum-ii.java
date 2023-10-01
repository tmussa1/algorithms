class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, int []> numMap = new HashMap<>();
        numMap.put(1, nums1);
        numMap.put(2, nums2);
        numMap.put(3, nums3);
        numMap.put(4, nums4);
        
        return fourSumCount(numMap, 1, 0, new HashMap<>());
    }
    
    private int fourSumCount(Map<Integer, int []> numMap, int numIndex, int sum,
                            Map<String, Integer> cache){
        if(numIndex == 5) {
            return sum == 0 ? 1 : 0;
        }
        
        String key = sum + "," + numIndex;
        
        if(cache.containsKey(key)) {
            return cache.get(key);
        }
        
        int result = 0;
        
        for(int num: numMap.get(numIndex)){
            result += fourSumCount(numMap, numIndex + 1, sum + num, cache);
        }
        
        cache.put(key, result);
        
        return result;
    }
}