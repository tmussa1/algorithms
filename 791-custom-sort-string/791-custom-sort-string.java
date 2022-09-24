class Solution {
    
    public String customSortString(String order, String s) {
        
        StringBuilder builder = new StringBuilder();
        
        Map<Character, Integer> orderMap = new HashMap<>();
        
        int rank = 1;
        
        for(int i = 0; i < order.length(); i++){
            char currChar = order.charAt(i);
            orderMap.put(currChar, rank++);
        }
        
        PriorityQueue<Tuple> tuples = new PriorityQueue<Tuple>((a, b) -> a.rank - b.rank);
        
        for(int i = 0; i < s.length(); i++){
            char currChar = s.charAt(i);
            Tuple tuple = new Tuple();
            tuple.currChar = currChar;
            tuple.rank = orderMap.getOrDefault(currChar, - 1);
            tuples.add(tuple);
        }
        
        while(!tuples.isEmpty()){
            builder.append(tuples.poll().currChar);
        }
        
        return builder.toString();
    }
    
    class Tuple {
        char currChar;
        int rank;
    }
}