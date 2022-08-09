class Solution {
    
    public int deleteAndEarn(int[] nums) {
        
        Set<Integer> numSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        List<Integer> numList = new ArrayList<>(numSet);
        Collections.sort(numList);
        Map<Integer, Integer> countsMap = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            countsMap.put(nums[i], countsMap.getOrDefault(nums[i], 0) + 1);
        }
        
        int [] result = new int[numList.size()];
        result[0] = countsMap.get(numList.get(0)) * numList.get(0);
        
        for(int i = 1; i < numList.size(); i++){
            int value = countsMap.get(numList.get(i)) * numList.get(i);
            if(numList.get(i) == numList.get(i - 1) + 1){
                int past =  i - 2 >= 0 ? result[i - 2] + value : value;
                result[i] = Math.max(result[i - 1], past);
            } else {
                result[i] = result[i - 1] + value;
            }
        }
        
        int max = 0;
        
        for(int i = 0; i < result.length; i++){
            if(result[i] > max){
                max = result[i];
            }
        }
        
        return max;
    }
}