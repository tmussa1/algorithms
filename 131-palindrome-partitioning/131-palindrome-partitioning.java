class Solution {
    public List<List<String>> partition(String s) {
        
        List<List<String>> result = new ArrayList<>();
        
        findPalindromes(s, result, new LinkedList<String>(), 0);
        
        return result;
    }
    
    private void findPalindromes(String s,
                                List<List<String>> result, LinkedList<String> currList,
                                int index){
        
        if(index >= s.length()){
            result.add(new LinkedList<>(currList));
        }
        
        for(int i = index; i < s.length(); i++){
            
            if(checkPalindrome(s, index, i)){
                currList.add(s.substring(index, i + 1));
                findPalindromes(s, result, currList, i + 1);
                currList.removeLast();
            }
        }
    }
    
    private boolean checkPalindrome(String s, int left, int right){
        
        while(left < right && right < s.length() && left < s.length()){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}