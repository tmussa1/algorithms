class Solution {
    
    public int leastBricks(List<List<Integer>> wall) {
        
        int rowSum = 0;
        
        Map<Integer, Integer> countMap = new HashMap<>();
            
        for(List<Integer> row: wall){
            rowSum = 0;
            for(int i = 0; i < row.size() - 1; i++){
                rowSum += row.get(i);
                row.set(i, rowSum);
                countMap.put(rowSum, countMap.getOrDefault(rowSum, 0) + 1);
            }
        }
        
        // for(int i = 0; i < wall.get(0).size(); i++){
        //     System.out.println(wall.get(0).get(i));
        // }
        
        int max = 0;
        
        for(Map.Entry<Integer, Integer> entry: countMap.entrySet()){
            if(entry.getValue() > max){
                max = entry.getValue();
            }
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        
        return wall.size() - max;
    }
}