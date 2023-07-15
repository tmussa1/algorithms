class Solution {
    
    public String getHint(String secret, String guess) {
        
        Map<Character, Integer> secretMap = new HashMap<>();
        
        for(char c: secret.toCharArray()){
            secretMap.put(c, secretMap.getOrDefault(c, 0) + 1);
        }
        
        StringBuilder builder = new StringBuilder();
        
        int a = 0, b = 0;
        
        int length = guess.length();
        
        for(int i = 0; i < length; i++){
            
            char g = guess.charAt(i), s = secret.charAt(i);
            
            if(s == g && secretMap.get(s) > 0){
                secretMap.put(s, secretMap.get(s) - 1);
                a++;
            }
        }
        
        
        for(int i = 0; i < length; i++){
            char g = guess.charAt(i), s = secret.charAt(i);
            if(s != g && secretMap.containsKey(g) && secretMap.get(g) > 0){
                secretMap.put(g, secretMap.get(g) - 1);
                b++;
            }
        }
        
        builder.append(a + "A");
        builder.append(b + "B");
        
        return builder.toString();
    }
}