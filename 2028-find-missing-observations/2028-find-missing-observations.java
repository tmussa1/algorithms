class Solution {
    
    
    public int[] missingRolls(int[] rolls, int mean, int n) {
        
        int [] result = new int[n];
        
        int sum = Arrays.stream(rolls).sum();
        
        int target = (rolls.length + n) * mean;
        
        int diff = target - sum;
        
        if(diff < n || diff > (n * 6)) return new int []{};
        
        int ave = diff / n;
        
        int rem = diff % n;
        
        int index = 0;
        
        while(index < n){
            result[index++] = ave + (rem-- > 0 ? 1 : 0);
        }
        
        return result;
    }
}