class Solution {
    
    public int romanToInt(String s) {
        
        int [] nums = new int[s.length()];
        Map<Character, Integer> lookup = populateMap();
        
        for(int i = 0; i < s.length(); i++){
            nums[i] = lookup.get(s.charAt(i));
        }
        
        int i = 1, sum = nums[0];
        
        while(i < nums.length){
            
            if(nums[i] > nums[i - 1]){
                sum += (nums[i] - (2 * nums[i - 1]));
            } else {
                sum += nums[i];
            }
            i++;
        }
        
        return sum;
    }
    
    private Map <Character, Integer> populateMap(){
       
        Map <Character, Integer> lookup = new HashMap<>();
        
        lookup.put('I', 1);
        lookup.put('V', 5);
        lookup.put('X', 10);
        lookup.put('L', 50);
        lookup.put('C', 100);
        lookup.put('D', 500);
        lookup.put('M', 1000);
        
        return lookup;
    }
}