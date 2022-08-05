class Solution {
    public int calculateTime(String keyboard, String word) {
        
        char [] wordChars = word.toCharArray();
        char [] keyboardChars = keyboard.toCharArray();
        
        Map<Character, Integer> keyboardCharsMap = new HashMap<>();
        
        for(int i = 0; i < keyboardChars.length; i++){
            keyboardCharsMap.put(keyboardChars[i], i);
        }
        
        int result = keyboardCharsMap.get(wordChars[0]);
        
        for(int i = 1; i < wordChars.length; i++){
            result += Math.abs(keyboardCharsMap.get(wordChars[i]) - keyboardCharsMap.get(wordChars[i - 1]));
        }
        
        return result;
    }
}