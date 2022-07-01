class Solution {
    public boolean wordPattern(String pattern, String str) {
        char [] patternArr = pattern.toCharArray();
        String [] strArray = str.split(" ");
        LinkedHashMap<Character, String> patternMap = new LinkedHashMap<>();
        LinkedHashMap<String, Character> reversedMap = new LinkedHashMap<>();
        
        if(patternArr.length != strArray.length){
            return false;
        }
        
        for(int i = 0; i < patternArr.length; i++){
  
            if(patternMap.get(patternArr[i]) == null){
                patternMap.put(patternArr[i], strArray[i]);         
            } 
            if(reversedMap.get(strArray[i]) == null){
                reversedMap.put(strArray[i], patternArr[i]);
            }
            
            if(!patternMap.get(patternArr[i]).equals(strArray[i]) || !reversedMap.get(strArray[i]).equals(patternArr[i])){
                return false;            
            } 
        }
        
        return true;
    }
}