class Solution {
    
    public int[] constructRectangle(int area) {
        
        int [] sides = new int[2];
        int diff = Integer.MAX_VALUE;
        
        for(int i = 1; i <= area; i++){
            
            int side = area / i;
            
            if(area % i == 0 && i >= side){
                if(i - side < diff){
                    sides[0] = i;
                    sides[1] = side;
                    diff = i - side;
                }
            }
        }
        
        return sides;
    }
}