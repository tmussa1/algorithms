class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        
        String [] morseCode = new String [] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        Map<Character, String> morseMap = new HashMap<>();
        
        for(int i = 0; i < 26; i++){
            char c = (char) ('a' + i);
            morseMap.put(c, morseCode[i]);
        }
        
        Map<String, String> wordsMap = new HashMap<>();
        
        for(String word: words){
            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                builder.append(morseMap.get(c));
            }
            wordsMap.put(builder.toString(), word);
        }
        
        return wordsMap.size();
    }
}