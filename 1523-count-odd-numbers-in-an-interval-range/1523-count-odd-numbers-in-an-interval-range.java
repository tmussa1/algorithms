class Solution {
    
    public int countOdds(int low, int high) {
        
        int sum = (low % 2 == 1 || high % 2 == 1 ? 1 : 0);
        
        int diff = (high - low) / 2;
        
        return sum + diff;
    }
}