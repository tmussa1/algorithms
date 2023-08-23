class Solution {
    
    public List<String> restoreIpAddresses(String s) {
        
        List<String> result = new ArrayList<>();
        
        restoreIpAddresses(s, new StringBuilder(), 0, 0, result);
        
        return result;
    }
    
    private void restoreIpAddresses(String s,
                                    StringBuilder builder,
                                    int index,
                                    int dotCount,
                                    List<String> result){
        
        if(index == s.length() && builder.charAt(builder.length() - 1) != '.'){
            result.add(new String(builder));
            return;
        }
        
        for(int i = index; i <= s.length(); i++){
            String candidate = s.substring(index, i);
            if(isValid(candidate) && dotCount <= 3){
                builder.append(candidate);
                if(dotCount < 3){
                  builder.append(".");
                }
                restoreIpAddresses(s, builder, i, dotCount + 1, result);
                int length = dotCount < 3 ? candidate.length() + 1 : candidate.length();
                int total = builder.length();
                builder.delete(total - length, total + 1);
            }
        }
    }
    
    private boolean isValid(String ip){
        return ip.length() >= 1 
            && !ip.equals(" ")
            && ip.length() <= 3 
            && !(ip.length() > 1 && ip.charAt(0) == '0')
            && Integer.parseInt(ip) <= 255
            && Integer.parseInt(ip) >= 0;
    }
}