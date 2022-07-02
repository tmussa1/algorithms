class Solution {
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        for(int row = 0; row < heights.length; row++){
            for(int col = 0; col < heights[0].length; col++){
                
                boolean [] foundPacific = new boolean[1];
                foundPacific[0] = false;
                boolean [] foundAtlantic = new boolean[1];
                foundAtlantic[0] = false;
                
                dfs(heights, result, row, col, foundPacific, foundAtlantic, new HashSet<>());
                
                if(foundPacific[0] && foundAtlantic[0]){
                    result.add(Arrays.asList(row, col));
                }
            }
        }
        
        return result;
    }
    
    void dfs(int[][] heights, List<List<Integer>> result, int row, int col, boolean [] foundPacific, boolean [] foundAtlantic, Set<String> visited){
        
        if(row <= 0 || col <= 0){
            foundPacific[0] = true;
        }
        
        if(row >= heights.length - 1 || col >= heights[0].length - 1){
            foundAtlantic[0] = true;
        }
        
        if(visited.contains(row + "," + col)){
            return;
        }
        
        visited.add(row + "," + col);
        
        if(row + 1 < heights.length && heights[row + 1][col] <= heights[row][col]){
            dfs(heights, result, row + 1, col, foundPacific, foundAtlantic, visited);
        }
        
        if(row - 1 >= 0 && heights[row - 1][col] <= heights[row][col]){
            dfs(heights, result, row - 1, col, foundPacific, foundAtlantic, visited);
        }
        
        if(col + 1 < heights[0].length && heights[row][col + 1] <= heights[row][col]){
            dfs(heights, result, row, col + 1, foundPacific, foundAtlantic, visited);
        }
        
        if(col - 1 >= 0 && heights[row][col - 1] <= heights[row][col]){
            dfs(heights, result, row, col - 1, foundPacific, foundAtlantic, visited);
        }
    }
}