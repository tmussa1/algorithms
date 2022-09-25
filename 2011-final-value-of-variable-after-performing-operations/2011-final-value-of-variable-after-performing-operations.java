class Solution {
    public int finalValueAfterOperations(String[] operations) {
        
        int result = 0;
        
        for(String operation: operations){
            switch(operation){
                case "--X": {
                    --result;
                    break;
                }
                case "X--": {
                    result--;
                    break;
                }
                case "++X": {
                    ++result;
                    break;
                }
                case "X++": {
                    result++;
                    break;
                }
            }
        }
            
        return result;
    }
}