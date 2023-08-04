class Solution {
    
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<Tuple> queue = new PriorityQueue<>((a, b) -> b.distance - a.distance);
        
        for(int i = 0; i < k; i++){
            int [] point = points[i];
            queue.offer(new Tuple(point[0], point[1], calculateDistance(point)));
        }
        
        int index = k;
        
        while(index < points.length){
            int [] point = points[index];
            int distance = calculateDistance(point);
            
            if(distance < queue.peek().distance){
                queue.poll();
                queue.offer(new Tuple(point[0], point[1], distance));
            }
            index++;
        }
        
        int [][] result = new int[k][2];
        index = 0;
        
        while(!queue.isEmpty()){
            result[index][0] = queue.peek().x;
            result[index++][1] = queue.poll().y;
        }
        
        return result;
    }
    
    private int calculateDistance(int [] point){
        return (int) Math.pow(point[0], 2) + (int) Math.pow(point[1], 2);
    }
    
    record Tuple(int x, int y, int distance){}
}