class Solution {
    public int numTrees(int n) {
        return numTrees(n, new HashMap<>());
    }

    private int numTrees(int n, Map<Integer, Integer> memo){

        if(n == 0 || n == 1){
            return 1;
        }

        if(memo.containsKey(n)){
            return memo.get(n);
        }

        int result = 0;

        for(int left = 0; left < n; left++){
            int right = n - left - 1;
            result += (numTrees(left, memo) * numTrees(right, memo));
        }

        memo.put(n, result);

        return result;
    }
}