class Solution {
    
    public String minWindow(String s, String t) {
        
        int minIndex = 0, maxIndex = 0, result = -1;
        
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        
        for(int i = 0; i < t.length(); i++){
            char currChar = t.charAt(i);
            tMap.put(currChar, tMap.getOrDefault(currChar, 0) + 1);
        }
        
        int uniqueCharLength = tMap.size(), currMatch = 0;
        int index = 0, left = 0;
        
        while(index < s.length()){
            
            char currChar = s.charAt(index);
            sMap.put(currChar, sMap.getOrDefault(currChar, 0) + 1);
            
            if(tMap.containsKey(currChar) && sMap.get(currChar).intValue() == tMap.get(currChar).intValue()){
                currMatch++;
            }
            
            while(left <= index && currMatch == uniqueCharLength){

                if(result == -1 || index - left + 1 < result){
                    result = index - left + 1;
                    maxIndex = index;
                    minIndex = left;
                }

                char leftChar = s.charAt(left);

                sMap.put(leftChar, sMap.get(leftChar) - 1);

                if(tMap.containsKey(leftChar) && sMap.get(leftChar).intValue() < tMap.get(leftChar).intValue())                 {
                   currMatch--;
                }

                left++;
            }
            index++;
        }
        
        return result ==  -1 ? "" : s.substring(minIndex, maxIndex + 1);
    }
}