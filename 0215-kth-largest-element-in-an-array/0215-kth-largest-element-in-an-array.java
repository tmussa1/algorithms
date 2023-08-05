class Solution {
    
    public int findKthLargest(int[] nums, int k) {
        
        if(k > nums.length) return -1;
        
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        
        for(int i = 0; i < k; i++){
            queue.offer(nums[i]);
        }
        
        int index = k;
        
        while(index < nums.length){
            if(nums[index] > queue.peek()){
                queue.poll();
                queue.offer(nums[index]);
            }
            index++;
        }
        
        return queue.poll();
    }
}