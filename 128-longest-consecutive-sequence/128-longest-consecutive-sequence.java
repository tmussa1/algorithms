import java.util.*;
import java.util.TreeSet;

class Solution {
    
    public int longestConsecutive(int[] nums) {
        
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        TreeSet<Integer> countMap = new TreeSet<>();
        
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < nums.length; i++){
            
            if(nums[i] < min){
                min = nums[i];
            }
            
            countMap.add(nums[i]);
        }
        
        int result = 1, count = 0;
        Iterator iterator = countMap.iterator();
        Integer prev = min;
        
        while(iterator.hasNext()){
            
            Integer value = (Integer) iterator.next();
            
            if(prev + 1 == value){
                count++;
                result = Math.max(result, count);
            } else {
                count = 1;
            }
            
            prev = value;
        }
        
        return result;
    }
}