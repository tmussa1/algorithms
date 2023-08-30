class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        
        Arrays.sort(houses);
        
        Arrays.sort(heaters);
        
        int heaterIndex = 0, houseIndex = 0, radius = 0;
        
        while(houseIndex < houses.length && heaterIndex < heaters.length){
            
            int diff = Math.abs(houses[houseIndex] - heaters[heaterIndex]), prevDiff = Integer.MAX_VALUE;
            
            while(heaterIndex < heaters.length){
                prevDiff = diff;
                diff = Math.abs(houses[houseIndex] - heaters[heaterIndex]);
                if(diff > prevDiff) break;
                heaterIndex++;
            }
            
            if(diff > prevDiff || heaterIndex == heaters.length) heaterIndex--;
            
            radius = Math.max(radius, Math.min(diff, prevDiff));
            
            houseIndex++;
        }
        
        return radius;
    }
}