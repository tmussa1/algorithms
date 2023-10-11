class Solution {
    
    public List<String> letterCasePermutation(String s) {
        
        Set<String> seen = new HashSet<>();
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        seen.add(s);
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                
                String curr = queue.poll();
                
                for(int index = 0; index < curr.length(); index++){
                    
                    char c = curr.charAt(index);
                    
                    if(c >= 'a' && c <= 'z'){
                        String sub = curr.substring(0, index) + Character.toUpperCase(c) + curr.substring(index + 1);
                        if(!seen.contains(sub)){
                            queue.offer(sub);
                            seen.add(sub);
                        }
                    } else if(c >= 'A' && c <= 'Z'){
                        String sub = curr.substring(0, index) + Character.toLowerCase(c) + curr.substring(index + 1);
                        if(!seen.contains(sub)){
                            queue.offer(sub);
                            seen.add(sub);
                        }
                    }
                }
            }
        }
        
        return new ArrayList<>(seen);
    }
}