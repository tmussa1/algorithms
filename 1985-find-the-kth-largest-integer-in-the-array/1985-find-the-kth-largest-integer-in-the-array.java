class Solution {
    
    public String kthLargestNumber(String[] nums, int k) {
        
        PriorityQueue<String> queue = new PriorityQueue<>((a, b) -> {
            if(a.length() == b.length()){
                return a.compareTo(b);
            }
            return a.length() - b.length();
        });
        
        int index = 0;
        
        while(index < nums.length){
            
            queue.offer(nums[index]);
            
            if(queue.size() > k){
                queue.poll();
            }
            
            index++;
        }
        
        return queue.poll();
    }
}