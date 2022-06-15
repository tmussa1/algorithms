class Solution {
    
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        
        for(int i = 0; i < nums.length; i++){
            queue.offer(nums[i]);
        }
        
        while(!queue.isEmpty() && k > 1){
            queue.poll();
            k--;
        }
        
        return queue.poll();
    }
}