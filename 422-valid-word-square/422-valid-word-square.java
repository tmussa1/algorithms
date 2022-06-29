class Solution {
    
    public boolean validWordSquare(List<String> words) {
        
        for(int i = 0; i < words.size(); i++){
            
            String word = words.get(i);
            
            String columnWord = findColumn(words, i);
            
            if(!word.equals(columnWord)){
                return false;
            }
        }
        
        return true;
    }
    
    private String findColumn(List<String> words, int column){
        
        StringBuilder builder = new StringBuilder();
        
        for(int i = 0; i < words.size(); i++){
            
            if(column < words.get(i).length()){
                char c = words.get(i).charAt(column);
                builder.append(c + "");
            }
        }
        
        return builder.toString();
    }
}