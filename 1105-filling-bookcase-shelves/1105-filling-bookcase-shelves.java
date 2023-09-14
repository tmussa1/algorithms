class Solution {
    
    public int minHeightShelves(int[][] books, int shelfWidth) {
        
        Integer [] [] memo = new Integer[books.length][shelfWidth + 1];
        
        return minHeightShelves(books, shelfWidth, shelfWidth, 0, 0, memo);
    }
    
    private int minHeightShelves(int[][] books, int shelfWidth, int remainingWidth, int height,
                                 int index, Integer [] [] memo){
        
        if(index == books.length){
            return height;
        }
        
        
        if(memo[index][remainingWidth] != null){
            return memo[index][remainingWidth];
        }
        
        if(books[index][0] <= remainingWidth){
            int thisLine = minHeightShelves(books, shelfWidth, remainingWidth - books[index][0],
                                            Math.max(height, books[index][1]), index + 1, memo);
            int nextLine = height + minHeightShelves(books, shelfWidth, shelfWidth - books[index][0], books[index][1], index + 1, memo);
            memo[index][remainingWidth] = Math.min(thisLine, nextLine);
            return memo[index][remainingWidth];
        }
        
         int nextLine = height + minHeightShelves(books, shelfWidth, shelfWidth - books[index][0], books[index][1], index + 1, memo);
        
         memo[index][remainingWidth] = nextLine;
        
         return memo[index][remainingWidth];
    }
}