class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int n = points.length;
        int res = 0;

        for(int i = 0; i < n - 1; i++){
            int dX = Math.abs(points[i+1][0] - points[i][0]);
            int dY = Math.abs(points[i+1][1] - points[i][1]);
            
            res += Math.max(dX, dY);
        }

        return res;
    }
}

