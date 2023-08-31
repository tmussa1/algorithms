class Solution {
    
    public int[] numsSameConsecDiff(int n, int k) {
        
        List<String> result = new ArrayList<>();
        
        backtrack(new StringBuilder(), result, n, k);
        
        int[] answer = new int[result.size()];
        
        int count = 0;
        
        for(String res: result){
            answer[count++] = Integer.parseInt(res);
        }
        
        return answer;
    }
    
    private void backtrack(StringBuilder builder, List<String> result, int n, int k){
        
        if(builder.length() == n){
            result.add(new String(builder));
            return;
        }
        
        for(int i = 0; i <= 9; i++){
            
            String key = builder.toString() + "" + i;
            
            if(isValid(key, k)){
                builder.append(i + "");
                backtrack(builder, result, n, k);
                builder.deleteCharAt(builder.length() - 1);
            }
        }
    }
    
    private boolean isValid(String key, int k){
        
        if(key.length() > 1 && key.charAt(0) == '0') return false;
        
        for(int i = 1; i < key.length(); i++){
            char c1 = key.charAt(i - 1), c2 = key.charAt(i);
            if(Math.abs(c2 - c1) != k) return false;
        }
        
        return true;
    }
}