class Solution {
    public int stoneGameII(int[] piles) {

        return (Arrays.stream(piles).sum() + stoneGame(piles, 0, 1, new Integer [piles.length] [piles.length + 1])) / 2;
    }

    private int stoneGame(int [] piles, int index, int M, Integer [] [] memo){

        if(index == piles.length){
            return 0;
        }

        if(memo[index][M] != null) return memo[index][M];

        int result = Integer.MIN_VALUE;

        for(int i = 1; i <= 2 * M; i++){
            int score = calculateSum(piles, index, index + i);
            score -= stoneGame(piles, Math.min(index + i, piles.length), Math.min(piles.length, Math.max(i, M)), memo);
            result = Math.max(result, score);
        }

        memo[index][M] = result;

        return result;
    }

    private int calculateSum(int [] piles, int left, int right){
        int sum = 0;
        for(int i = left; i < Math.min(piles.length, right); i++){
            sum += piles[i];
        }
        return sum;
    }
}