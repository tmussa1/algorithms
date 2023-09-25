class Solution {

    public String removeDuplicates(String s, int k) {
        
        Stack<Tuple> monoStack = new Stack<>();

        int index = 0;

        while(index < s.length()){

            char currChar = s.charAt(index);

            if(!monoStack.isEmpty() && monoStack.peek().value == currChar){

                Tuple tuple = new Tuple();
                tuple.value = currChar;
                tuple.count = monoStack.peek().count + 1;
                monoStack.push(tuple);

                boolean kEqual = tuple.count == k;

                int kCount = k;

                while(!monoStack.isEmpty() && kEqual && kCount > 0) {
                    monoStack.pop();
                    kCount--;
                }
            } else {
                Tuple tuple = new Tuple();
                tuple.value = currChar;
                tuple.count = 1;
                monoStack.push(tuple);
            }

            index++;
        }

        StringBuilder builder = new StringBuilder();

        while(!monoStack.isEmpty()){
            builder.append(monoStack.pop().value);
        }

        return builder.reverse().toString();
    }

    class Tuple {
        char value;
        int count;
    }
}