class WordDistance {

    private String[] wordsDict;
    private Map<String, List<Integer>> indexMap;
    
    public WordDistance(String[] wordsDict) {
        this.wordsDict= wordsDict;
        this.indexMap = new HashMap<>();
        
        for(int i = 0; i < wordsDict.length; i++){
            String word = wordsDict[i];
            List<Integer> indices = this.indexMap.getOrDefault(word, new ArrayList<>());
            indices.add(i);
            this.indexMap.put(word, indices);
        }
    }
    
    public int shortest(String word1, String word2) {
        

        int diff = Integer.MAX_VALUE;
        
        List<Integer> word1Indices = this.indexMap.get(word1);
        List<Integer> word2Indices = this.indexMap.get(word2);
        
        Collections.sort(word1Indices);
        Collections.sort(word2Indices);
        
        
        for(int i = 0; i < word1Indices.size(); i++){
            for(int j = 0; j < word2Indices.size(); j++){
                
                diff = Math.min(diff, Math.abs(word1Indices.get(i) - word2Indices.get(j)));
            }
        }
        
        return diff;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */