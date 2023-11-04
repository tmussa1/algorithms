class Solution {
    
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        
        long [] [] combined = new long[n][2];
        
        long mod = 1_000_000_007;
        
        for(int i = 0; i < n; i++){
            combined[i][0] = ((long) efficiency[i]);
            combined[i][1] = ((long) speed[i]);
        }
        
        Arrays.sort(combined, (a, b) -> Long.compare(b[0], a[0]));
        
        PriorityQueue<Long> queue = new PriorityQueue<Long>();
        
        int index = 0;
        
        long sum = 0, result = 0;
        
        while(index < n){
            
            long toSum = combined[index][1];
            
            queue.offer(toSum);
            
            sum = (sum + toSum);
            
            if(queue.size() > k){
                sum -= queue.poll();
            }
            
            long toMult = combined[index][0];
            
            long product = (sum * toMult);
            
            result = Math.max(product, result);
            
            index++;
        }
        
        return (int) (result % mod);
    }
}