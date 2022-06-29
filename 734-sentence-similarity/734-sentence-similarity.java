class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        
        if(sentence1.length != sentence2.length){
            return false;
        }
        
        Set<String> similarMap = new HashSet<>();
        
        for(int i = 0; i < similarPairs.size(); i++){
            List<String> lst = similarPairs.get(i);
            similarMap.add(lst.get(0) + "," + lst.get(1));
            similarMap.add(lst.get(1) + "," + lst.get(0));
        }
        
        
        for(int i = 0; i < sentence1.length; i++){
            
            String word1 = sentence1[i], word2 = sentence2[i];
            
            if(word1.equals(word2)){
                continue;
            }
            
            if(similarMap.contains(word1 + "," + word2)) {
                continue;
            } 
               
            if(similarMap.contains(word2 + "," + word1)){
                continue;
            }
            
            return false;
        }
        
        return true;
    }
}