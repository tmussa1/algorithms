class Solution {

    int [] [] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int minimumEffortPath(int[][] heights) {

        int rows = heights.length, cols = heights[0].length;
        
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> a.effort - b.effort);
        queue.offer(new Node(0, 0, 0));

        Set<String> visited = new HashSet<>();
        visited.add(0 + "," + 0);

        int efforts = 0;

        while(!queue.isEmpty()){

            Node node = queue.poll();
            visited.add(node.x + "," + node.y);

            efforts = Math.max(efforts, node.effort);

            if(node.x == rows - 1 && node.y == cols - 1) return efforts;

            for(int [] dir: directions){
                int nextRow = node.x + dir[0], nextCol = node.y + dir[1];

                if(!visited.contains(nextRow + "," + nextCol) &&
                   nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols){
                    int effort = Math.abs(heights[node.x][node.y] - heights[nextRow][nextCol]);
                    queue.offer(new Node(nextRow, nextCol, effort));
                }
            }
        }

        return -1;
    }

    class Node {

        int x, y, effort;

        Node(int x, int y, int effort){
            this.x = x;
            this.y = y;
            this.effort = effort;
        }
    }
}