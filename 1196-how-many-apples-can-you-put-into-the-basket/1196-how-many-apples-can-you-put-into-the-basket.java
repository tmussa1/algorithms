class Solution {
    
    public int maxNumberOfApples(int[] weight) {
        
        Arrays.sort(weight);
        
        int index = 0, currSum = 0;
        
        
        while(index < weight.length && currSum <= 5_000){
            currSum += weight[index];
            index++;
        }
        
        return currSum > 5_000 ? index - 1 : index;
    }
}