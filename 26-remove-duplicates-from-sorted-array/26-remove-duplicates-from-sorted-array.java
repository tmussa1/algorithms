class Solution {
    
    public int removeDuplicates(int[] nums) {
        
        Set<Integer> numSet = new HashSet<>();
        
        for(int i = 0; i < nums.length; i++){
            numSet.add(nums[i]);
        }
        
        List<Integer> numList = new ArrayList<>();
        numList.addAll(numSet);
        
        Collections.sort(numList);
        
        for(int i = 0; i < numList.size(); i++){
            nums[i] = numList.get(i);
        }
        
        return numList.size();
    }
}