class Solution {
    
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        
        int result = 0;
        
        Map<Integer, Set<Integer>> rowMap = new HashMap<>();
        
        for(int [] reserved: reservedSeats){
            int row = reserved[0];
            Set<Integer> cols = rowMap.getOrDefault(row, new HashSet<>());
            cols.add(reserved[1]);
            rowMap.put(row, cols);
        }
        
        for(Integer key: rowMap.keySet()){
            
            int candidate = 0;
            
            Set<Integer> cols = rowMap.get(key);
            
            boolean left = false, middle = false, right = false;
            
            for(int i = 2; i <= 9; i++){
                
                if(cols.contains(i)){
                    if(i >= 2 && i <= 5){
                        left = true;
                    }
                    if(i >= 4 && i <= 7){
                        middle = true;
                    }
                    if(i >= 6 && i <= 9){
                        right = true;
                    }
                }
            }
            
            if(left && middle && right) {
                candidate = 0;
            } else if(middle){
                candidate = 1;
            } else {
                if(right || left){
                    candidate = 1;
                } else {
                    candidate = 2;
                }
            }
            
            result += candidate;
        }
        
        result += (n - rowMap.size()) * 2;
            
        return result;
    }
}