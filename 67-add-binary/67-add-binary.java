class Solution {
    
    public String addBinary(String a, String b) {
        
        if(a.equals("0") && b.equals("0")){
            return "0";
        }
        
        StringBuilder str = new StringBuilder();
        
        char [] chA = a.toCharArray();
        char [] chB = b.toCharArray();
        int length = Math.max(chA.length, chB.length);
        int carry = 0;
        int sum = 0;
        
        for(int i = 1; i <= length; i++){
            
            sum = 0;
            
            if(i <= Math.min(chA.length, chB.length)){
                sum = Integer.parseInt(chA[chA.length - i] + "")
                + Integer.parseInt(chB[chB.length - i] + "") + carry;
            } else {
                
                if(chA.length > Math.min(chA.length, chB.length)){
                    sum += Integer.parseInt(chA[chA.length - i] + "") + carry;
                }
                
                if(chB.length > Math.min(chA.length, chB.length)){
                    sum += Integer.parseInt(chB[chB.length - i] + "") + carry;
                }
            }
            
            if(sum % 2 == 0){
                
                if(sum == 0){
                    carry = 0;
                } else {
                    carry = 1;
                }
                
                str.append('0');
            } else {
                
                if(sum == 3){
                    carry = 1;
                }
                
                if(sum == 1){
                    carry = 0;
                }
                
                str.append('1');
            } 
        }
        
        if(carry == 1){
            str.append('1');
        }
        
        return str.reverse().toString();
    }

}