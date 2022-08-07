class Solution {
    
    public String intToRoman(int num) {
        
        StringBuilder builder = new StringBuilder();
        
        Map<Integer, Character> romanMap = romanMap();
        
        while(num > 0){
            
            if(num >= 1000){
                int howMany = num / 1000;
                builder.append((romanMap.get(1000) + "").repeat(howMany));
                num = num % 1000;
            } else if(num >= 900){
                builder.append((romanMap.get(100) + "") + (romanMap.get(1000) + ""));
                num = num % 900;
            } else if(num >= 500){
                builder.append((romanMap.get(500) + ""));
                num = num % 500;
            } else if(num >= 400){
                builder.append((romanMap.get(100) + "") + (romanMap.get(500) + ""));
                num = num % 400;
            } else if(num >= 100){
                int howMany = num / 100;
                builder.append((romanMap.get(100) + "").repeat(howMany));
                num = num % 100;
            } else if(num >= 90){
                builder.append((romanMap.get(10) + "") + (romanMap.get(100) + ""));
                num = num % 90;
            } else if(num >= 50){
                builder.append((romanMap.get(50) + ""));
                num = num % 50;
            } else if(num >= 40){
                builder.append((romanMap.get(10) + "") + (romanMap.get(50) + ""));
                num = num % 40;
            } else if(num >= 10){
                int howMany = num / 10;
                builder.append((romanMap.get(10) + "").repeat(howMany));
                num = num % 10;
            } else if(num == 9){
                builder.append((romanMap.get(1) + "") + (romanMap.get(10) + ""));
                num = 0;
            } else if(num >= 5){
                builder.append((romanMap.get(5) + ""));
                num = num % 5;
            } else if(num == 4){
                builder.append((romanMap.get(1) + "") + (romanMap.get(5) + ""));
                num = 0;
            } else {
                builder.append((romanMap.get(1) + "").repeat(num));
                num = 0;
            }
        }
        
        return builder.toString();
    }
    
    Map<Integer, Character> romanMap(){
        
        Map<Integer, Character> romanMap = new HashMap<>();
        
        romanMap.put(1, 'I');
        romanMap.put(5, 'V');
        romanMap.put(10, 'X');
        romanMap.put(50, 'L');
        romanMap.put(100, 'C');
        romanMap.put(500, 'D');
        romanMap.put(1000, 'M');
        
        return romanMap;
    }
}