class Solution {
    
    public List<Integer> intersection(int[][] nums) {
        
        Map<Integer, Integer> countMap = new HashMap<>();
        
        TreeSet<Integer> result = new TreeSet<>();
        
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums[i].length; j++){
                int num = nums[i][j];
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
                if(countMap.get(num) == nums.length){
                    result.add(num);
                }
            }
        }
        
        return new ArrayList<>(result);
    }
}