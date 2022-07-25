class Solution {
    public String stringShift(String s, int[][] shift) {
        
        LinkedList<Integer> lst = new LinkedList<Integer>();
        
        for(int i = 0; i < s.length(); i++){
            lst.add(i);
        }
        
        for(int i = 0; i < shift.length; i++){
            
            int direction = shift[i][0];
            int move = shift[i][1] % s.length();
            
            if(direction == 1){
                move = s.length() - move;
            }
            
            List<Integer> tempList = new ArrayList<>();
            
            int index = 0;
            
            while(lst.size() > 0 && index < move){
                tempList.add(lst.removeFirst());
                index++;
            }
            
            lst.addAll(tempList);
        }
        
        StringBuilder builder = new StringBuilder();
        
        for(int i = 0; i < lst.size(); i++){
            builder.append(s.charAt(lst.get(i)));
        }
        
        return builder.toString();
    }
}