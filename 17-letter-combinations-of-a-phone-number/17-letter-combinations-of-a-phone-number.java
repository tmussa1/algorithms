class Solution {
    public List<String> letterCombinations(String digits) {
        
        List<String> result = new ArrayList<>();
        
        if(digits == null || digits.equals("")) return result;
            
        Map<Integer, List<Character>> adjList = constructAdjList();
        
        int size = digits.length();
        
        dfs(adjList, result, size, new StringBuilder(), digits, 0);
        
        return result;
    }
    
    private void dfs(Map<Integer, List<Character>> adjList, List<String> result, int size, StringBuilder builder, String digits, int index){
        
        if(index == size){
            result.add(builder.toString());
            return;
        }
        
        int digit = Integer.parseInt(digits.charAt(index) + "");
        
        for(Character element: adjList.get(digit)){
            
             builder.append(element);
            
             dfs(adjList, result, size, builder, digits, index + 1);
            
             builder.deleteCharAt(index);
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