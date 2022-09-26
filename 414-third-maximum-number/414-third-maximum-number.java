class Solution {
    public int thirdMax(int[] nums) {
        
        PriorityQueue<Long> queue = new PriorityQueue<Long>((a, b) -> Long.compare(b, a));
        
        for(int num: nums){
            queue.offer((long)num);
        }
        
        int count = 3;
        long max = 0, maxNum = queue.peek();
        
        while(!queue.isEmpty() && count > 0){
            
            max = queue.poll();
            
            while(!queue.isEmpty() && max == queue.peek()){
                queue.poll();
            }
            
            count--;
        }
        
        return count == 0 ? (int) max : (int) maxNum;
    }
}