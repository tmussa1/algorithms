class Solution {
    
    public int[][] merge(int[][] intervals) {
        
        List<int []> mergedIntervals = new ArrayList<>();
        
        if(intervals == null || intervals.length == 0) return null;
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        mergedIntervals.add(intervals[0]);
        
        for(int i = 1; i < intervals.length; i++){
            
            int [] prevInterval = mergedIntervals.get(mergedIntervals.size() - 1);
            
            if(intervals[i][0] <= prevInterval[1]){
                prevInterval[1] = Math.max(prevInterval[1], intervals[i][1]);
            } else {
                mergedIntervals.add(intervals[i]);
            }
        }
        
        int [] [] result = new int [mergedIntervals.size()][2];
        
        for(int i = 0; i < mergedIntervals.size(); i++){
            result[i] = mergedIntervals.get(i);
        }
        
        return result;
    }
}