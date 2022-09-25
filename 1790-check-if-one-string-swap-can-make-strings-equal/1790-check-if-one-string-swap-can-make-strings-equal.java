class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        
        char [] char1 = s1.toCharArray(), char2 = s2.toCharArray();
        
        int mismatches = 0;
        
        int [] mismatchedC1 = new int[26];
        int [] mismatchedC2 = new int[26];
        
        for(int i = 0; i < s1.length(); i++){
            if(char1[i] != char2[i]){
                mismatches++;
                mismatchedC1[char1[i] - 'a']++;
                mismatchedC2[char2[i] - 'a']++;
            }
        }
        
        return mismatches <= 2 && Arrays.equals(mismatchedC1, mismatchedC2);
    }
}