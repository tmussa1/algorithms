class Solution {
    public String countAndSay(int n) {
        
        String prevString = "1";
        
        if(n == 1) return prevString;
        
        StringBuilder currBuilder = new StringBuilder();
        
        int index = 1;
        
        while(index < n){
            
            int prevIndex = 0, count = 0;
            char prevChar = prevString.charAt(0);
            
            while(prevIndex < prevString.length()){
                if(prevString.charAt(prevIndex) == prevChar){
                    count++;
                } else {
                    currBuilder.append(count + "" + prevChar);
                    count = 1;
                    prevChar = prevString.charAt(prevIndex);
                }
                prevIndex++;
            }
            
            currBuilder.append(count + "" + prevChar);
            
            prevString = currBuilder.toString();
            currBuilder = new StringBuilder();
            index++;
        }
        
        return prevString;
    }
}

// 1 - 1 - 1
// 11 - 1 - 2
// 21 - 11 - 3
// 1211 - 21 - 4
// 111221 - 1211 - 5
// 312211 - 6