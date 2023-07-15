class Solution {
    
    public int strStr(String haystack, String needle) {
        
        
        int left = 0, needleIndex = 0;
        
        while(left < haystack.length()){
            
            
            int leftBefore = left;
            
            needleIndex = 0;
            
            while(left < haystack.length() && needleIndex < needle.length()
                  && haystack.charAt(left) == needle.charAt(needleIndex)){
                
                left++;
                needleIndex++;
                
                if(needleIndex == needle.length()){
                    return left - needleIndex;
                }
            }
            
            left = leftBefore + 1;
        }
        
        return -1;
    }
}