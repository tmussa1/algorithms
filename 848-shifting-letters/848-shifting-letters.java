class Solution {
    
    public String shiftingLetters(String s, int[] shifts) {
        
        for(int i = 0; i < shifts.length; i++){
            shifts[i] = shifts[i] % 26;
        }
        
        int maxShift = Arrays.stream(shifts).sum();
        
        StringBuilder builder = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++){
            
            int charIndex = s.charAt(i) - 'a';
            
            charIndex += maxShift;
            
            charIndex = charIndex % 26;
            
            char c = ((char)(charIndex + 'a'));
            
            builder.append(c);
            
            maxShift -= shifts[i];
        }
        
        return builder.toString();
    }
}