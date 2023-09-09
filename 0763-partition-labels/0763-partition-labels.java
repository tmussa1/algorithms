class Solution {
    
    public List<Integer> partitionLabels(String s) {
        
        Map<Character, Integer> indexMap = new HashMap<>();
        
        List<Integer> indices = new ArrayList<>();
        indices.add(-1);
        
        for(int i = 0; i < s.length(); i++){
            indexMap.put(s.charAt(i), i);
        }
        
        int index = 0, forward = -1;
        
        while(index < s.length()){
            
            char c = s.charAt(index);
            int lastIndex = indexMap.get(c);
            
            if(lastIndex >= forward){
                forward = lastIndex;
            }
            
            if(index == forward){
              indices.add(forward);
            }
                
            index++;
        }
        
        List<Integer> result = new ArrayList<>();
        
        for(int i = 1; i < indices.size(); i++){
            result.add(indices.get(i) - indices.get(i - 1));
        }
        
        return result;
    }
}