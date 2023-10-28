class Solution {
    
    public long totalCost(int[] costs, int k, int candidates) {
        
        PriorityQueue<int []> queue = new PriorityQueue<int []>((a, b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        
        int left = 0, right = 0, hired = 0;
        
        left = candidates;
        
        for(int i = 0; i < left; i++){
            queue.offer(new int [] {costs[i], i});
        }
        
        right = Math.max(costs.length - candidates - 1, candidates - 1);
        
        for(int i = costs.length - 1; i > right; i--){
            queue.offer(new int [] {costs[i], i});
        }
        
        long result = 0;
        
        while(hired < k){
            
            int [] curr = queue.poll();
            
            result += curr[0];
            
            hired++;
            
            if(left <= right){
                if(curr[1] > right){
                    queue.offer(new int [] {costs[right], right--});
                } else {
                    queue.offer(new int [] {costs[left], left++});
                }
            }
        }
        
        return result;
    }
}