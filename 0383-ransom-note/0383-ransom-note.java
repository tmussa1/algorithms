class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        char [] ransom = ransomNote.toCharArray();
        char [] maga = magazine.toCharArray();
        
        HashMap<Character, Integer> ransomMap = new HashMap<>();
        HashMap<Character, Integer> magaMap = new HashMap<>();
        
        if(ransom.length == 0){
            return true;
        }
        
        if(maga.length == 0){
            return false;
        }
         
        for(int i = 0, l = 0; i < ransom.length || l < maga.length; i++, l++){
            
            if(i < ransom.length){
                 populateRansom(ransom[i], ransomMap);
            }
            
            if(l < maga.length){
                 populateMaga(maga[l], magaMap);
            }       
            
        }  
        
        return compareEntries(ransomMap, magaMap);
    }
    
    public boolean compareEntries(HashMap<Character, Integer> ransomMap,
                                 HashMap<Character, Integer> magaMap){
        for(Map.Entry<Character, Integer> ransomEntry : ransomMap.entrySet()){
            
            if(magaMap.get(ransomEntry.getKey()) == null ||
               magaMap.get(ransomEntry.getKey()) < ransomEntry.getValue()){
                return false;
            }
            
        }
        return true;
    }
    
    public void populateRansom(char ransom , HashMap<Character, Integer> ransomMap){
        
        if(ransomMap.get(ransom) == null){
            ransomMap.put(ransom, 0);
        } else {
            ransomMap.replace(ransom , ransomMap.get(ransom) + 1);
        }
    }
    
    public void populateMaga(char maga, HashMap<Character, Integer> magaMap){
        if(magaMap.get(maga) == null){
            magaMap.put(maga, 0);
        } else {
            magaMap.replace(maga , magaMap.get(maga) + 1);
        }
    }
}