class Solution {
    
    public int[] findDiagonalOrder(int[][] mat) {
        
        int rows = mat.length, cols = mat[0].length;
        
        int [] result = new int [(rows * cols)];
        
        int level = 0, row = 0, col = 0, sum = 0, count = 0;
        
        List<Integer> lst = new ArrayList<>();
        
        while(sum < rows + cols - 1){
            
            List<Integer> curr = new ArrayList<>();
            
            int startCol = col;
            
            while(row < rows && col < cols && row >= 0 && col >= 0){
                curr.add(mat[row][col]);
                row++;
                col--;
            }
            
            if(level % 2 == 1){
                lst.addAll(curr);
            } else {
                Collections.reverse(curr);
                lst.addAll(curr);
            }
            
    //        System.out.println(lst + " row " + row + " col " + col);
    
            sum++;
            level++;
            
            if(startCol == cols - 1){
                count++;
                row = count;
                col = cols - 1;
            } else {
                col = startCol + 1;
                row = 0;
            }
        }
        
        for(int i = 0; i < result.length; i++){
            result[i] = lst.get(i);
        }
        
     //   System.out.println(lst);
        
        return result;
    }
}