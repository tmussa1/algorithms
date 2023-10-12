class Solution {
    
    public boolean isThereAPath(int[][] grid) {
        
        return findPath(grid, 0, 0, grid[0][0],  1 - grid[0][0], new HashSet<>(), new HashMap<>());
    }
    
    private boolean findPath(int[][] grid, int row, int col,
                             int oneCount, int zeroCount,
                             Set<String> visited, Map<String, Boolean> memo){
        
        if(row == grid.length - 1 && col == grid[0].length - 1){
            return oneCount == zeroCount;
        }
        
        String key = row + "," + col;
        
        String memoKey = row + "," + col + "," + oneCount + "," + zeroCount;
        
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited.contains(key)){
            return false;
        }
        
        if(memo.containsKey(memoKey)) return memo.get(memoKey);
        
        visited.add(key);
        
        boolean result = false;
        
        oneCount += grid[row][col];
        zeroCount += (1 - grid[row][col]);
        
        if(row + 1 < grid.length){
            result |= findPath(grid, row + 1, col, oneCount, zeroCount, visited, memo);
        }
        
        if(col + 1 < grid[0].length){
            result |= findPath(grid, row, col + 1, oneCount, zeroCount, visited, memo);
        }
        
       oneCount -= grid[row][col];
       zeroCount -= (1 - grid[row][col]);
        
        memo.put(memoKey, result);
        
        visited.remove(key);
        
        return result;
    }
}