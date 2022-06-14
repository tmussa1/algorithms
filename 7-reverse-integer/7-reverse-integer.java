class Solution {
    public int reverse(int x) {
        char [] str = String.valueOf(x).toCharArray();
        String result = "";
        
        for(int i = str.length - 1; i >= 0; i--){
            result += str[i];
        }
        
        if(str[0] == '-'){
            result = result.substring(0, result.length() - 1);
            
            if(Long.parseLong(result) > Math.pow(2, 31)){
                return 0;
            }
            
            return -Integer.parseInt(result);
        }
        
        if(Long.parseLong(result) > Math.pow(2, 31)){
                return 0;
        }
        
        return Integer.parseInt(result);
    }
}