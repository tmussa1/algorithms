class Solution {
    
    public String[] reorderLogFiles(String[] logs) {
        
        List<String> digits = new ArrayList<>();
        List<String> letters = new ArrayList<>();
        
        for(int i = 0; i < logs.length; i++){
            
            String word = logs[i];
            
            String [] wordSplit = word.split(" ");
            
            if(wordSplit[1].length() > 0){ 
                if(Character.isDigit(wordSplit[1].charAt(0))) {
                    digits.add(word);
                } else {
                    letters.add(word);
                }
            }  
        }
        
        Collections.sort(letters, (a, b) -> {
            
            String [] aSplit = a.split(" ");
            String [] bSplit = b.split(" ");
            
            String aStr = "";
            
            for(int i = 1; i < aSplit.length; i++){
                aStr += aSplit[i] + " ";
            }
            
            String bStr = "";
            
            for(int i = 1; i < bSplit.length; i++){
                bStr += bSplit[i] + " ";
            }
            
            if(aStr.compareTo(bStr) == 0) {
                return aSplit[0].compareTo(bSplit[0]);
            }
            
            return aStr.compareTo(bStr);
        });
        
        letters.addAll(digits);
        
        return letters.toArray(new String[0]);
    }
}