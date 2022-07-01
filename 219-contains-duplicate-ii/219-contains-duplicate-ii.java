class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        Map<Integer, List<Integer>> indexMap =  new HashMap<>();
        
       for(int i = 0; i < nums.length; i++){
           
           List<Integer> lst = indexMap.getOrDefault(nums[i], new ArrayList<>());
           lst.add(i);
           
           indexMap.put(nums[i], lst);
           
           if(lst.size() >= 2){
               
               Collections.sort(lst);
               
               int left = 0, right = 1;
               
               while(left < lst.size() && right < lst.size()){
                   
                   if(lst.get(right) - lst.get(left) > k){
                       left++;
                   } else {
                       return true;
                   }
                   
                   right++;
               }
           }
       }

        return false;
    }
}