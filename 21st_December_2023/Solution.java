import java.util.Arrays;

class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        // Arrays.sort(points, Comparator.comparingInt(p -> p[0]));
        Arrays.sort(points, (a, b) -> a[0] - b[0]);
        int max = Integer.MIN_VALUE;

        for(int i = 1; i < points.length; i++){
            max = Math.max(max, (points[i][0] - points[i - 1][0]));
        }

        return max;
    }
}

class SolutionII {
    public int maxWidthOfVerticalArea(int[][] points) {
        int[] arr = new int[points.length];

        for(int i = 0; i < arr.length; i++){
            arr[i] = points[i][0];
        }

        Arrays.sort(arr);
        int max = Integer.MIN_VALUE;

        for(int i = arr.length - 1; i > 0; i--){
            // if((arr[i] - arr[i-1]) > max){
            //     max = arr[i] - arr[i-1];
            // }
            max = Math.max(max, (arr[i] - arr[i-1]));
        }

        return max;
    }
}