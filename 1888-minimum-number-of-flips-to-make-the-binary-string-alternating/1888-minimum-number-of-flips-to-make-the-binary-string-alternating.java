class Solution {
    
    public int minFlips(String s) {
        
        int window = s.length(), minFlip = s.length();
        
        StringBuilder alt1 = new StringBuilder();
        StringBuilder alt2 = new StringBuilder();
        
        for(int i = 0; i < window * 2; i++){
            if(i % 2 == 0){
                alt1.append(0);
                alt2.append(1);
            } else {
                alt1.append(1);
                alt2.append(0);
            }
        }
        
        int diffAlt1 = 0, diffAlt2 = 0;
        
        for(int i = 0; i < window; i++){
            if(alt1.charAt(i) != s.charAt(i)){
                diffAlt1++;
            }
            if(alt2.charAt(i) != s.charAt(i)){
                diffAlt2++;
            }
        }
        
        minFlip = Math.min(minFlip, Math.min(diffAlt1, diffAlt2));
        
        s = s + s;
        
        for(int i = window; i < window * 2; i++){
            int left = i - window;
            if(alt1.charAt(left) != s.charAt(left)){
                diffAlt1--;
            }
            if(alt2.charAt(left) != s.charAt(left)){
                diffAlt2--;
            }
            if(alt1.charAt(i) != s.charAt(i)){
                diffAlt1++;
            }
            if(alt2.charAt(i) != s.charAt(i)){
                diffAlt2++;
            }
            minFlip = Math.min(minFlip, Math.min(diffAlt1, diffAlt2));
        }
        
        return minFlip;
    }
}