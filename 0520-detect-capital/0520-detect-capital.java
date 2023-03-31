class Solution {

    public boolean detectCapitalUse(String word) {
        
        char [] chars = word.toCharArray();

        boolean sawLower = false;
        int capitals = 0;

        for(int i = 0; i < chars.length; i++){

            if(Character.isLowerCase(chars[i])){
                if(capitals > 1) return false;
                sawLower = true;
            }

            if(Character.isUpperCase(chars[i])) {
                if(i > 0 && sawLower) return false;
                capitals++;
            }
        }

        return true;
    }
}