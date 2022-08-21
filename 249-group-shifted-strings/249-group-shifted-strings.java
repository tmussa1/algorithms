class Solution {
    
    public List<List<String>> groupStrings(String[] strings) {
        
        Map<String, List<String>> shiftMap = new HashMap<>();
        
        for(int i = 0; i < strings.length; i++){
            String word = strings[i];
            String key = calculateKey(word);
            List<String> shiftList = shiftMap.getOrDefault(key, new ArrayList<>());
            shiftList.add(word);
            shiftMap.put(key, shiftList);
        }
        
        return new ArrayList<>(shiftMap.values());
    }
    
    private String calculateKey(String word){
        
        if(word.length() == 1) return "1";
        
        StringBuilder builder = new StringBuilder();
        
        for(int i = 1; i < word.length(); i++){
            int curr = (word.charAt(i) - 'a') + 1, prev = (word.charAt(i - 1) - 'a') + 1;
            int diff = (((curr - prev) % 26) + 26) % 26;
            builder.append(diff + "|");
        }
        
        return builder.toString();
    }
}