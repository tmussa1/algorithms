class Solution {
    
    public int getKth(int lo, int hi, int k) {
        
        PriorityQueue<Tuple> tuples = new PriorityQueue<Tuple>((a, b) -> {
            if(a.powerValue == b.powerValue) return a.num - b.num;
            return a.powerValue - b.powerValue;
        });
        
        for(int i = lo; i <= hi; i++){
            Tuple tuple = new Tuple();
            tuple.num = i;
            tuple.powerValue = powerValue(i);
            tuples.add(tuple);
        }
        
        while(!tuples.isEmpty() && k > 1){
            tuples.poll();
            k--;
        }
        
        return tuples.peek().num;
    }
    
    private int powerValue(int num){
        
        int steps = 0;
        
        while(num != 1){
            
            if(num % 2 == 0){
                num /= 2;
            } else {
                num = 3 * num + 1;
            }
            
            steps++;
        }
        
        return steps;
    }
    
    class Tuple {
        int num;
        int powerValue;
    }
}