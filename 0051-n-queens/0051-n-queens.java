class Solution {
    
    public List<List<String>> solveNQueens(int n) {
        
        List<List<String>> result = new ArrayList<>();
        
        char [] [] blocks = new char[n][n];
        
        for(int i = 0; i < n; i++){
           Arrays.fill(blocks[i], '.');
        }
        
        solveQueen(result, new HashSet<>(), new HashSet<>(), 
                   new HashSet<>(), 0, n, blocks);
        
        return result;
    }
    
    private void solveQueen(List<List<String>> result,
                            Set<Integer> rows,
                            Set<Integer> diags,
                            Set<Integer> reverseDiags,
                            int row, int n, 
                            char[] [] blocks){
        
        if(row == n){
            List<String> oneResult = new ArrayList<>();
            for(char [] chars: blocks){
                StringBuilder builder = new StringBuilder();
                for(char c: chars){
                    builder.append(c);
                }
                oneResult.add(builder.toString());
            }
            result.add(oneResult);
            return;
        }
        
        
        for(int col = 0; col < n; col++){
            
            if(rows.contains(col) 
              || reverseDiags.contains(col + row)
              || diags.contains(col - row)){
                continue;
            }
             rows.add(col);
             reverseDiags.add(row + col);
             diags.add(col - row);
             blocks[row][col] = 'Q';
             solveQueen(result, rows, diags, reverseDiags, row + 1, n, blocks);
             rows.remove(col);
             reverseDiags.remove(row + col);
             diags.remove(col - row);
             blocks[row][col] = '.';
        }
    }
}