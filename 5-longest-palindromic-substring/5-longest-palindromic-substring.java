class Solution {
    
    public String longestPalindrome(String s) {
        
        char [] sArr = s.toCharArray();
        String result = "";
        int [] max = new int[1];
        
        for(int i = 0; i < s.length(); i++){
            result = updateMax(sArr, i, i, s, max, result);
        }
        
        for(int i = 0; i < s.length(); i++){
            result = updateMax(sArr, i, i + 1, s, max, result);
        }
        
        return result;
    }
    
    String updateMax(char [] sArr, int l, int r, String s, int [] max, String result){
        
        int currMax = 0;
        
        while(l >= 0 && r < s.length() && sArr[l] == sArr[r]){
            currMax++;
            l--;
            r++;
        }
        
        if(currMax >= max[0]){
            max[0] = currMax;
            result = s.substring(l + 1,  r);
         }
        
        return result;
    }
}