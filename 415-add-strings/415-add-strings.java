class Solution {
    
    public String addStrings(String num1, String num2) {
        
        StringBuilder builder = new StringBuilder();
        
        int length1 = num1.length(), length2 = num2.length(), carry = 0;
        
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        
        int index = 0;
        
        while(index < Math.min(length1, length2)){
            int n1 = num1.charAt(index) - '0', n2 = num2.charAt(index) - '0';
            int sum  = n1 + n2 + carry;
            if(sum > 9) {
                carry = 1;
            } else {
                carry = 0;
            }
            builder.append((sum % 10) + "");
            index++;
        }
        
        while(index < length1){
            int n1 = num1.charAt(index) - '0';
            int sum  = n1 + carry;
             if(sum > 9) {
                carry = 1;
            } else {
                carry = 0;
            }
            builder.append((sum % 10) + "");
            index++;
        }
        
        while(index < length2){
            int n2 = num2.charAt(index) - '0';
            int sum  = n2 + carry;
            if(sum > 9) {
                carry = 1;
            } else {
                carry = 0;
            }
            builder.append((sum % 10) + "");
            index++;
        }
        
        if(carry == 1){
            builder.append(carry + "");
        }
        
        return builder.reverse().toString();
    }
}