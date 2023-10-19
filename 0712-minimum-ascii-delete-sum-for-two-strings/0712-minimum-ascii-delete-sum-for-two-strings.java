class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        return minimumDeleteSum(s1, s2, 0, 0, new Integer [s1.length()] [s2.length()]);
    }
    
    private int minimumDeleteSum(String s1, String s2, int s1Index, int s2Index,
                                 Integer [] [] memo) {
        
        if(s1Index == s1.length() && s2Index == s2.length()){
            return 0;
        }
        
        if(s1Index == s1.length()){
            String sub2 = s2.substring(s2Index);
            int sum = 0;
            for(char c: sub2.toCharArray()){
                sum += c;
            }
            return sum;
        }
        
        if(s2Index == s2.length()){
            String sub1 = s1.substring(s1Index);
            int sum = 0;
            for(char c: sub1.toCharArray()){
                sum += c;
            }
            return sum;
        }
        
        if(memo[s1Index][s2Index] != null) return memo[s1Index][s2Index];
        
        if(s1.charAt(s1Index) == s2.charAt(s2Index)){
            return minimumDeleteSum(s1, s2, s1Index + 1, s2Index + 1, memo);
        }
        
        int left = s1.charAt(s1Index) + minimumDeleteSum(s1, s2, s1Index + 1, s2Index, memo);
        int right = s2.charAt(s2Index) + minimumDeleteSum(s1, s2, s1Index, s2Index + 1, memo);
        
        memo[s1Index][s2Index] = Math.min(left, right);
        return memo[s1Index][s2Index];
    }
}