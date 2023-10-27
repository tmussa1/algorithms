class Solution {
    
    public int equalPairs(int[][] grid) {
        
        Map<String, Integer> equalMap = new HashMap<>();
        Map<String, Integer> equalColMap = new HashMap<>();
        
        int result = 0;
        
        int rows = grid.length, cols = grid[0].length;
        
        for(int row = 0; row < rows; row++){
            
            List<String> lst = new ArrayList<>();
            
            for(int col = 0; col < cols; col++){
                lst.add(grid[row][col] + "");
            }
            
            String key = String.join(",", lst);
            
            equalMap.put(key, equalMap.getOrDefault(key, 0) + 1);
        }
        
        
        for(int col = 0; col < cols; col++){
            
            List<String> lst = new ArrayList<>();
            
            for(int row = 0; row < rows; row++){
                lst.add(grid[row][col]+"");
            }
            
            String key = String.join(",", lst);
            equalColMap.put(key, equalColMap.getOrDefault(key, 0) + 1);
        }
        
        for(String key: equalMap.keySet()){
            if(equalColMap.containsKey(key)){
                 result += (equalMap.get(key) * equalColMap.get(key));
            }
        }
        
     //   System.out.println(equalMap + " " + result);
        
        return result;
    }
}