class Solution {
    
    public double champagneTower(int poured, int query_row, int query_glass) {
        
        List<List<Double>> result = new ArrayList<>();
        
        List<Double> lst1 = new ArrayList<>();
        lst1.add(poured * 1.0);
        
        result.add(lst1);
        
        int row = 1;
        
        while(row <= query_row){
            
            List<Double> prev = result.get(result.size() - 1);
             
            Double [] currArray = new Double [prev.size() + 1];
            
            Arrays.fill(currArray, 0.0);
            
            for(int i = 0; i < prev.size(); i++){
                
                double extra = prev.get(i) - 1;
                
                if(extra > 0) {
                    currArray[i] += extra * 0.5;
                    currArray[i + 1] = extra * 0.5;
                }
            }
            
            result.add(Arrays.asList(currArray));
                
            row++;
        }
        
        return result.get(query_row).get(query_glass) > 1 ? 1 : result.get(query_row).get(query_glass);
    }
}