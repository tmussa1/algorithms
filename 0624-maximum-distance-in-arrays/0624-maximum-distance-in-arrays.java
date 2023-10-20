class Solution {
    
    public int maxDistance(List<List<Integer>> arrays) {
        
        PriorityQueue<int []> minQueue = new  PriorityQueue<int []>((a, b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        
        PriorityQueue<int []> maxQueue = new  PriorityQueue<int []>((b, a) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        
        for(int i = 0; i < arrays.size(); i++){
            List<Integer> arr = arrays.get(i);
            int min = arr.get(0), max = arr.get(arr.size() - 1);
            minQueue.offer(new int [] {min, i});
            maxQueue.offer(new int [] {max, i});
        }
        
        int diff = 0;
        
        while(!minQueue.isEmpty() && !maxQueue.isEmpty()){
            
            int [] minQ = minQueue.poll();
            int [] maxQ = maxQueue.poll();
            
            if(minQ[1] == maxQ[1]){
               int [] minQ2 = minQueue.poll();
               int [] maxQ2 = maxQueue.poll(); 
               diff = Math.max(maxQ2[0] - minQ[0], maxQ[0] - minQ2[0]);
            } else {
                diff = maxQ[0] - minQ[0];
            }
            break;
        }
        
        return diff;
    }
}