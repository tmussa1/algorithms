class Solution {
    
    public int twoCitySchedCost(int[][] costs) {
        
        Arrays.sort(costs, (a, b) -> a[0] - a[1] - (b[0] - b[1]));
        
        int result = 0, length = costs.length / 2, index = 0;
        
        while(index < length){
            result += costs[index][0];
            result += costs[index + length][1];
            index++;
        }
        
        return result;
    }
}