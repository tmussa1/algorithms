class Solution {
    
    public List<Integer> getRow(int rowIndex) {
        
        List<List<Integer>> triangles = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        result.add(1);
        triangles.add(result);
        
        if(rowIndex == 0){
            return result;
        }
        
        List<Integer> prev = null;
        
        for(int i = 1; i <= rowIndex; i++){
            
            prev = triangles.get(i - 1);
             
            Integer [] next = new Integer[i + 1];
            next[0] = 1;
            next[i] = 1;
            
            for(int j = 1; j < i; j++){
                next[j] = prev.get(j - 1) + prev.get(j);
            }
            
            triangles.add(Arrays.asList(next));
        }
        
        return triangles.get(triangles.size() - 1);
    }
}