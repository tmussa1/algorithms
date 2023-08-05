class Solution {
    
    public int kthSmallest(int[][] matrix, int k) {
        
        int row = 0, col = 0, n = matrix.length;
        
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        
        while(row < n && col < n){
            
            while(col < n){
                queue.offer(matrix[row][col]);
                col++;
            }
            
            col = row;
            row++;
            
            while(row < n){
               queue.offer(matrix[row][col]);
               row++; 
            }
            
            row = col;
            
            row++;
            col++;
            
            if(queue.size() >= k){
                while(queue.size() > k){
                    queue.poll();
                }
            }
        }
        
        return queue.peek();
    }
}