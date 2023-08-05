class Solution {
    
    
    private Tuple find(Tuple tuple){
        if(tuple != tuple.parent){
            tuple.parent = find(tuple.parent);
        }
        return tuple.parent;
    }
    
    private int link(Tuple tuple1, Tuple tuple2){
        
        Tuple tuple1Parent = find(tuple1);
        Tuple tuple2Parent = find(tuple2);
        
        if(tuple1Parent == tuple2Parent){
            return 0;
        }
        
        if(tuple1Parent.rank > tuple2Parent.rank){
            tuple2Parent.parent = tuple1Parent;
        } else if(tuple1Parent.rank < tuple2Parent.rank){
            tuple1Parent.parent = tuple2Parent;
        } else {
           tuple2Parent.parent = tuple1Parent;
           tuple1Parent.rank += 1;
        }
        
        return 1;
    }
    
    public int findCircleNum(int[][] isConnected) {
        
        int provinces = isConnected.length;
        
        Tuple [] tuples = new Tuple[provinces];
        
        for(int i = 0; i < isConnected.length; i++){
             tuples[i] = new Tuple(i, null, 1);
             tuples[i].parent = tuples[i];
        }
        
        for(int i = 0; i < isConnected.length; i++){
            for(int j = 0; j < isConnected[i].length; j++){
                if(isConnected[i][j] == 1 && i != j){
                    provinces -= link(tuples[i], tuples[j]);
                }
            }
        }
        
        return provinces;
    }
    
    class Tuple {
        public int index;
        public Tuple parent;
        public int rank;
        
        Tuple(int index, Tuple parent, int rank){
            this.index = index;
            this.parent = parent;
            this.rank = rank;
        }
    }
}