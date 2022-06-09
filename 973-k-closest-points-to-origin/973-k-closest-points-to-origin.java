class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<Tuple> queue = new PriorityQueue<Tuple>((a, b) -> Double.compare(a.distance, b.distance));
        
        for(int i = 0; i < points.length; i++){
            
            double distance = Math.sqrt((Math.pow(points[i][0], 2)) + (Math.pow(points[i][1], 2)));
                                         
            Tuple tuple = new Tuple();
            tuple.distance = distance;
            tuple.x = points[i][0];
            tuple.y = points[i][1];
             
            queue.offer(tuple);
        }
           
        int [] [] result = new int[k][2];
        int count = 0;
                                         
        while(k > 0 && !queue.isEmpty()){
            Tuple t = queue.poll();
            result[count][0] = t.x;
            result[count++][1] = t.y;
            k--;
        }
        
        return result;
    }
    
    class Tuple {
        int x;
        int y;
        double distance;
    }
}