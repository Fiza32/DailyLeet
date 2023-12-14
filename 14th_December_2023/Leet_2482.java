
public class Leet_2482 {
    public int[][] onesMinusZeros(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        int[] onesRow = new int[r];
        int[] onesCol = new int[c];

        int[] zerosRow = new int[r];
        int[] zerosCol = new int[c];

        for(int i = 0; i < r; i++){

            for(int j = 0; j < c; j++){
                if(grid[i][j] == 1){
                    onesRow[i]++;
                    onesCol[j]++;
                }
                else {
                    zerosRow[i]++;
                    zerosCol[j]++;
                }
            }
        }

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                grid[i][j] = (onesRow[i] + onesCol[j]) - (zerosRow[i] + zerosCol[j]);
            }
        }

        return grid;
    }
}
