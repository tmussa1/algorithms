class Solution {
    public int[] countBits(int n) {

        int [] bits = new int[n + 1];

        for(int i = 0; i <= n; i++){

            int count = i, bit = 0;

            while(count > 0){
                count &= count - 1;
                bit++;
            }

            bits[i] = bit;
        }

        return bits;
    }
}