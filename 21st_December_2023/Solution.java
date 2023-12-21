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

    // Time Complexity
    // Sorting - O(n log n)
    // Loop - O(n)
    // Overall --->>>   O(n log n);

    // Space Complexity
    // O(1) -->> The fn doesn't allocate any additional memory structures
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
    // Time Complexity
    // O(n) -->>    The Loop that copies x-coordinates from points to arr
    // O(n log n) -->>     To sort the arr
    // O(n)  -->>       To iterate over the arr
    // Overall T.C      -->>        O(n log n);


    // Space Complexity
    // O(n)  -->>   To create an array 'arr'
    // O(1)  -->>   Constant variables
    // Overall S.C      -->>        O(n);
}