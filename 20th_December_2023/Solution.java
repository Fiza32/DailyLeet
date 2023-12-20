import java.util.Arrays;

class Solution {
    public int buyChoco(int[] prices, int money) {
        int fst = Integer.MAX_VALUE;
        int sec = Integer.MAX_VALUE;
        
        // Find the two smallest number
        for(int num : prices){      // O(n)
            // Finding the two smallest elements involves comparing each element with two variables (fst and sec).
            // Seems like: O(n^2)
            if(num < fst){
                sec = fst;
                fst = num;
            } 
            else if(num >= fst && num < sec){
                sec = num;
            }
        }

        int sum = fst + sec;
        
        if(sum > money){
            return money;
        }
        
        int leftOverMoney = money - sum;

        return leftOverMoney;
    }
 
    // T.C. O(n); the overall time complexity is dominated by the iteration and element comparisons, making it O(n).

    // S.C.     O(1);        this function uses only a few constant-size variables (fst, sec, sum, and leftOverMoney).


}

class SolutionII {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices); // O(n log n)
        int sum = prices[0] + prices[1];

        if(sum > money){
            return money;
        }
        
        int leftOverMoney = money - sum;

        return leftOverMoney;
    }

    // T.C.       O(n log n); where n is the length of the prices

    // S.C        O(1);      The function only uses a few constant-size variables (sum, leftOverMoney) and doesn't allocate any additional memory based on the input size.
}

class SolutionIII {
    public int buyChoco(int[] prices, int money) {
        int sum = Integer.MAX_VALUE;

        for(int i = 0; i < prices.length; i++){

            for(int j = 0; j < prices.length; j++){
                if(i != j){
                    int tempSum = prices[i] + prices[j];
                    sum = Math.min(sum, tempSum);
                }
            }
        }
        
        if(sum > money) return money;
        
        int leftOverMoney = money - sum;

        return leftOverMoney;
    }

    // T.C. O(n^2);     The nested loop iterates through each element in the prices array twice (i and j loop), leading to a total of n * n = n^2 iterations.

    // S.C        O(1);      The function only uses a few constant-size variables (sum, tempSum, leftOverMoney) and doesn't allocate any additional memory based on the input size.
}