
class Solution {
    public int[][] imageSmoother(int[][] img) {
        // Get the dimension of the input img
        int r = img.length;
        int c = img[0].length;

        // Create an another 2D array of the same dimension
        int[][] ans = new int[r][c];

        // Iterate over each cell of the img
        for(int i = 0; i < r; i++){

            for(int j = 0; j < c; j++){
                // Initialize sum & count
                int sum = 0;
                int count = 0;

                // Iterate over all possible indices
                for(int x = i - 1; x <= i + 1; x++){
                    for(int y = j - 1; y <= j + 1; y++){
                        // Check for the valid neighbours
                        if(x >= 0 && x < r && y >= 0 && y < c){
                            count++;
                            sum += img[x][y];
                        }
                    }
                }

                // initialize each cell of ans with the avg value
                ans[i][j] = sum / count;
            }
        }

        return ans;
    }
}
