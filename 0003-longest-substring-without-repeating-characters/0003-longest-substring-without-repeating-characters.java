class Solution {
    
    public int lengthOfLongestSubstring(String s) {
        
        Set<Character> visited = new HashSet<>();
        
        int left = 0, right = 0, length = 0;
        
        while(right < s.length()){
            
            char currChar = s.charAt(right);
            
            while(visited.contains(currChar)){
                visited.remove(s.charAt(left));
                left++;
            }
            
            visited.add(currChar);
            
            length = Math.max(length, right - left + 1);
            right++;
        }
        
        return length;
    }
}