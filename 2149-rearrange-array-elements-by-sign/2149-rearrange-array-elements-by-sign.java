class Solution {
    
    public int[] rearrangeArray(int[] nums) {
        
        List<Integer> positives = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();
        
        for(int num: nums){
            if(num < 0){
                negatives.add(num);
            } else {
                positives.add(num);
            }
        }
        
        int index = 0, negIndex = 0, posIndex = 0;
        
        int [] result = new int[nums.length];
        
        while(index < nums.length){
            
            if(index % 2 == 0){
                result[index] = positives.get(posIndex++);
            } else {
                result[index] = negatives.get(negIndex++);
            }
            
            index++;
        }
        
        return result;
    }
}