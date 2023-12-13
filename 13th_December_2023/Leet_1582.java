
public class Leet_1582 {
    public int numSpecial(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;

        int[] row = new int[r]; // sum of each row
        int[] col = new int[c]; // sum of each col 

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                row[i] += mat[i][j];
                col[j] += mat[i][j];
            }
        }

        int spclPosition = 0;

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){

                if(mat[i][j] == 1 && row[i] == 1 && col[j] == 1){
                    spclPosition += 1;
                }
            }
        }

        return spclPosition;
    }
}
