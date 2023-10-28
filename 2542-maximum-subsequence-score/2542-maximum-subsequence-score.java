class Solution {
    
    public long maxScore(int[] nums1, int[] nums2, int k) {
        
        int [] [] combined = new int[nums1.length][2];
        
        long result = 0;
        
        for(int i = 0; i < nums1.length; i++){
            combined[i][0] = nums1[i];
            combined[i][1] = nums2[i];
        }
        
        Arrays.sort(combined, (a, b) -> {
            if(a[1] == b[1]){
                return b[0] - a[0];
            }
            return b[1] - a[1];
        });
        
   //     System.out.println(Arrays.deepToString(combined));
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a, b) -> a - b);
        
        long runningSum = 0;
        
        for(int i = 0; i < nums1.length; i++){
            
            minHeap.offer(combined[i][0]);
            
            runningSum += combined[i][0];
            
            if(minHeap.size() > k){
                runningSum -= minHeap.poll();
            }
            
            if(i >= k - 1) {
                int num2 = combined[i][1];
                long product = ((long) (num2 * runningSum));
                result = Math.max(result, product);
            } 
        }
        
        return result;
    }
}