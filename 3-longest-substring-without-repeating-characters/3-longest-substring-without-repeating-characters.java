class Solution {
    
    public int lengthOfLongestSubstring(String s) {
         
        if(s ==  null || s.equals("")){
            return 0;
        }
        
        char [] cArr = s.toCharArray();
        
        int i = 0, j = 0, max = 1;
        Set<Character> countMap = new HashSet<>();
        
        while(j < s.length()){
            
            while(countMap.contains(cArr[j])){
                countMap.remove(cArr[i]);
                i++;
            }
            
            max = Math.max(max, j - i + 1);
            countMap.add(cArr[j]);               
            j++;
        }
            
            
        return max;
    }
}