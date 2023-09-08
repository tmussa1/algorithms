class Solution {
    
    public int connectSticks(int[] sticks) {
        
        if(sticks.length == 1) return 0;
        
        Arrays.sort(sticks);
        
        int result = 0, index = 1;
        
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