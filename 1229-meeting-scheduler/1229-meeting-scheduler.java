class Solution {
    
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        
        int slot1Ptr = 0, slot2Ptr = 0;
        
        List<Integer> result = new ArrayList<>();
        
        Arrays.sort(slots1, (a, b) -> a[0] - b[0]);
        Arrays.sort(slots2, (a, b) -> a[0] - b[0]);
        
        while(slot1Ptr < slots1.length && slot2Ptr < slots2.length){
            
            int [] slot1 = slots1[slot1Ptr];
            int [] slot2 = slots2[slot2Ptr];
            
            int start = Math.max(slot1[0], slot2[0]);
            int end = Math.min(slot1[1], slot2[1]);
            
            if(end - start >= duration){
                result.add(start);
                result.add(start + duration);
                return result;
            }
            
            if(slot1[1] < slot2[1]){
                slot1Ptr++;
            } else if(slot2[1] < slot1[1]){
                slot2Ptr++;
            } else {
                slot1Ptr++;
                slot2Ptr++;
            }
        }
   
        return result;
    }
}