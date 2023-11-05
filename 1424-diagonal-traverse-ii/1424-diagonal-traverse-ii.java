class Solution {
    
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        
        Queue<int []> queue = new LinkedList<>();
        queue.offer(new int [] {0, 0});
        
        int rows = nums.size();
        
        List<Integer> list = new ArrayList<>();
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                
                int [] curr = queue.poll();
                
                int row = curr[0], col = curr[1];
                
                list.add(nums.get(row).get(col));
                
                if(col == 0 && row < rows - 1){
                    queue.offer(new int [] {row + 1, col});
                }
                
                if(col < nums.get(row).size() - 1){
                    queue.offer(new int [] {row, col + 1});
                }
            }
        }
        
        int [] result = new int [list.size()];
        
        int index = 0;
        
        for(Integer num: list){
            result[index] = list.get(index++);
        }
        
        return result;
    }
}