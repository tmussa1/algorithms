class Vector2D {
    
    List<List<Integer>> nums;
    
    int row, col;

    public Vector2D(int[][] vec) {
        
        this.nums = new ArrayList<>();
        
        for(int i = 0; i < vec.length; i++){
            List<Integer> lst = new ArrayList<>(vec[i].length);
            for(int j = 0; j < vec[i].length; j++){
                lst.add(vec[i][j]);
            }
            if(lst.size() > 0){
               nums.add(lst);
            }
        }
        
        this.row = 0;
        this.col = 0;
    }
    
    public int next() {
        
        int num = nums.get(row).get(col);
        
        if(col == nums.get(row).size() - 1){
            row++;
            col = 0;
        } else {
            col++;
        }
        
        return num;
    }
    
    public boolean hasNext() {
        return row < nums.size();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */