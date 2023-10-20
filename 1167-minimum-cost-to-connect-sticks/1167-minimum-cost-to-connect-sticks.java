class Solution {
    
    public int connectSticks(int[] sticks) {
        
        if(sticks.length == 1) return 0;
        
        int result = 0;
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int stick: sticks){
            queue.offer(stick);
        }
        
        while(queue.size() > 1){
            int sum = queue.poll() + queue.poll();
            result += sum;
            queue.offer(sum);
        }
        
        return result;
    }
}