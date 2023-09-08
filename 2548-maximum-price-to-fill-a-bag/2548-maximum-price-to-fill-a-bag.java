class Solution {
    
    public double maxPrice(int[][] items, int capacity) {
        
        double result = 0;
        
        Arrays.sort(items, (a, b) -> {
            int diff1 = (a[0] / a[1]), diff2 = (b[0]/ b[1]);
            if(diff1 == diff2){
               double diffs1 = (a[0] * 1.0 / a[1]), diffs2 = (b[0] * 1.0 / b[1]);
               return Double.compare(diffs2, diffs1);
            }
            return diff2 - diff1;
        });
        
        int index = 0;
        
        double cap = capacity * 1.0;
        
        for(index = 0; index < items.length; index++){
            
            if(items[index][1] * 1.0 < cap){
                result += items[index][0];
                cap -= items[index][1];
            } else {
                result += (cap * 1.0 / items[index][1] * 1.0) * items[index][0];
                cap -= (cap * 1.0 / items[index][1] * 1.0) * items[index][1];
            }
        }
        
        if(index == items.length && cap > 0.0) return -1;
        
        return result;
    }
}