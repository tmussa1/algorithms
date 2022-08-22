class Solution {
    
    public void wiggleSort(int[] nums) {
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); 
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a); 
        
        int minSize = nums.length % 2 == 0 ? nums.length / 2 : (nums.length / 2) + 1;
        int maxSize = nums.length / 2;
        
        for(int i = 0; i < nums.length; i++){
            minHeap.offer(nums[i]);
            maxHeap.offer(nums[i]);
        }
        
        int index = 0;
        
        while(index < nums.length){
            nums[index++] = minHeap.poll();
            if(index == nums.length) break;
            nums[index++] = maxHeap.poll();
        }
    }
}