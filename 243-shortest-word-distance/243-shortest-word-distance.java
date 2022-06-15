class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int word1Index = Integer.MAX_VALUE;
        int word2Index = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;
        
        Map<String, Integer> indexMap = new HashMap<>();
        
        for(int i = 0; i < wordsDict.length; i++){
            
            indexMap.put(wordsDict[i], i);
            
            if(wordsDict[i].equals(word1)){
                word1Index = i;
            }
            
            if(wordsDict[i].equals(word2)){
                word2Index = i;
            }
            
            if(Math.abs(word1Index - word2Index) != 0){
                diff = Math.min(diff, Math.abs(word1Index - word2Index));
            }
        }
        
        return diff;
    }
}