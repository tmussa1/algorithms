class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] == b[0]){
                return b[1] - a[1];
            }
            
            return a[0] - b[0];
        });
        
        int prevEnd = intervals[0][1], result = 0;
        
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] < prevEnd){
                prevEnd = Math.min(intervals[i][1], prevEnd);
                result++;
            } else {
                prevEnd = Math.max(intervals[i][1], prevEnd);
            }
        }
        
        return result;
    }
}