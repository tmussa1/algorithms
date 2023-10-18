/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        
        PriorityQueue<int []> queue = new PriorityQueue<>((a, b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        
        for(List<Interval> intervals: schedule){
            
            for(int i = 0; i < intervals.size(); i++){
                
                Interval interval = intervals.get(i);
                
                int start = interval.start;
                int end = interval.end;
                
                queue.offer(new int [] { start, end });
            }
        }
        
        
        int [] curr = queue.poll();
        
        int start = curr[0], end = curr[1];
        
        List<Interval> intersections = new ArrayList<>();
        
        while(!queue.isEmpty()){
            
            curr = queue.poll();
            
            if(curr[0] > end){
                Interval interval = new Interval(end, curr[0]);
                intersections.add(interval);
                end = curr[1];
            } else {
                end = Math.max(curr[1], end);
            }
        }
        
        return intersections;
    }
}