class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {

        PriorityQueue<Tuple> tuples = new PriorityQueue<>((a, b) -> a.value - b.value);

        int diff = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for(int i = 0; i < nums.size(); i++){
            int num = nums.get(i).get(0);
            tuples.add(new Tuple(num, i, 0));
            max = Math.max(max, num);
        }

        int start = -1, end = -1;

        while(!tuples.isEmpty()){

            Tuple tuple = tuples.poll();

            if(max - tuple.value < diff){
                start = tuple.value;
                end = max;
                diff = max - tuple.value;
            }

            if(tuple.currIndex < nums.get(tuple.index).size() - 1){
                int nextNum = nums.get(tuple.index).get(tuple.currIndex + 1);
                tuples.offer(new Tuple(nextNum, tuple.index, tuple.currIndex + 1));
                if(nextNum > max){
                    max = nextNum;
                }
            } else {
                break;
            }
        }

        return new int [] {start, end};
    }

    class Tuple {
        int index;
        int value;
        int currIndex;
        Tuple(int value, int index, int currIndex){
            this.value = value;
            this.index = index;
            this.currIndex = currIndex;
        }
    }
}