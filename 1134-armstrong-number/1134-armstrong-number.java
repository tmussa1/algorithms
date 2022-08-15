class Solution {
    public boolean isArmstrong(int n) {
        
        String digits = String.valueOf(n);
        int length = digits.length();
        
        int sumDigits = 0;
        int index = 0;
        
        while(index < length){
            String digit = digits.charAt(index) + "";
            sumDigits += (int) Math.pow(Integer.parseInt(digit), length);
            index++;
        }
        
        return sumDigits == n;
    }
}