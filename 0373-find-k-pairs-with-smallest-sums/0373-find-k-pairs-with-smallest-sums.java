class Solution {
    
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        PriorityQueue<int []> queue = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));
        
        for(int i = 0; i < nums1.length; i++){
            int [] entry = new int[3];
            entry[0] = nums1[i];
            entry[1] = nums2[0];
            entry[2] = 0;
            queue.offer(entry);
        }
        
        List<List<Integer>> result = new ArrayList<>();
        
        while(result.size() < k && !queue.isEmpty()){
            
            int [] curr = queue.poll();
            
            List<Integer> lst = new ArrayList<>();
            
            for(int i = 0; i < curr.length - 1; i++){
                lst.add(curr[i]);
            }
            
            result.add(lst);
            
            if(curr[2] + 1 < nums2.length){
                int [] entry = new int[3];
                entry[0] = curr[0];
                entry[1] = nums2[curr[2] + 1];
                entry[2] = curr[2] + 1;
                queue.offer(entry);
            }
        }
       
        
        
        return result;
    }
}