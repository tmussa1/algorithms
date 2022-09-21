class Solution {
    
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        PriorityQueue<Tuple> tuples = new PriorityQueue<Tuple>((t1, t2) -> {
            if(t1.diff == t2.diff){
                return t2.num - t1.num;
            } 
            return t2.diff - t1.diff;
        });
        
        for(int i = 0; i < arr.length; i++){
            
            int diff = Math.abs(x - arr[i]);
            
            Tuple tuple = new Tuple();
            tuple.diff = diff;
            tuple.num = arr[i];
            
            tuples.add(tuple);
            
            if(tuples.size() > k){
                tuples.poll();
            }
        }
        
        List<Integer> result = new ArrayList<>();
        
        while(!tuples.isEmpty()){
            result.add(tuples.poll().num);
        }
        
        Collections.sort(result);
        
        return result;
    }
    
    class Tuple {
        int num;
        int diff;
    }
}