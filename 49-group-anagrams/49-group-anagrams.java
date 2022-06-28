class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> anagramMap = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        
        for(int i = 0; i < strs.length; i++){
            
            char [] cArr = strs[i].toCharArray();       
            Arrays.sort(cArr);           
            String key = String.valueOf(cArr);
            
            if(anagramMap.containsKey(key)){
                List<String> lst = anagramMap.get(key);
                lst.add(strs[i]);
                anagramMap.put(key, lst);
            } else {
                List<String> lst = new ArrayList<>();
                lst.add(strs[i]);
                anagramMap.put(key, lst);
            }
        }
        
        for(Map.Entry<String,List<String>> entry : anagramMap.entrySet()){
            result.add(entry.getValue());
        }
        
        return result;
    }
}