class Solution {
    
    public int firstUniqChar(String s) {
        
        Map<Character, Integer> countsMap = new HashMap<>();
        
        char [] chArr = s.toCharArray();
        
        for(int i = 0; i < chArr.length; i++){
            
            if(countsMap.containsKey(chArr[i])){
              countsMap.replace(chArr[i], countsMap.get(chArr[i]) + 1);
            } else {
              countsMap.put(chArr[i],1); 
            }
          
        }
        
        for(int i = 0; i < chArr.length; i++){

            if(countsMap.get(chArr[i]) == 1){
                return i;
            }
        }
        
        return -1;
    }
}