class Solution {
    
    
    public List<String> letterCombinations(String digits) {
        
        Map<Integer, List<Character>> adjList = constructAdjList();
        
        List<String> result = new ArrayList<>();
        
        if(digits.length() == 0) return result;
        
        backtrack(digits, adjList, 0, result, new StringBuilder());
        
        return result;
    }
    
    private void backtrack(String digits, 
                           Map<Integer, List<Character>> adjList,
                           int index,
                           List<String> result,
                           StringBuilder builder){
        
        if(index == digits.length()) {
            result.add(new String(builder));
            return;
        }
        
        int digit = digits.charAt(index) - '0';
        
        List<Character> chars = adjList.get(digit);
        
        for(char c: chars){
            builder.append(c);
            backtrack(digits, adjList, index + 1, result, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
    
    Map<Integer, List<Character>> constructAdjList(){
       
        Map<Integer, List<Character>> adjList = new HashMap<>();
        
        adjList.put(2, Arrays.asList('a', 'b', 'c'));
        adjList.put(3, Arrays.asList('d', 'e', 'f'));
        adjList.put(4, Arrays.asList('g', 'h', 'i'));
        
        adjList.put(5, Arrays.asList('j', 'k', 'l'));
        adjList.put(6, Arrays.asList('m', 'n', 'o'));
        adjList.put(7, Arrays.asList('p', 'q', 'r', 's'));
        
        adjList.put(8, Arrays.asList('t', 'u', 'v'));
        adjList.put(9, Arrays.asList('w', 'x', 'y', 'z'));
        
        return adjList;
    }
}