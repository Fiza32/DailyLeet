import java.util.Arrays;

public class Leet_1464 {
    // 1st Approach
    public int maxProduct(int[] nums) {
        int n = nums.length;
        
        int fst = -1;
        int sec = -1;

        for(int i = 0; i < n; i++){
            if(nums[i] > fst){
                sec = fst;
                fst = nums[i];
            }

            else if(nums[i] <= fst && nums[i] > sec){
                sec = nums[i];
            }
        }

        return (fst - 1) * (sec - 1);
    }

    // 2nd Approach
    public int maxProductI(int[] nums) {
        int n = nums.length;
        int pro = 1;
        int res = 0;

        for(int i = 0; i < n; i++){

            for(int j = i + 1; j < n; j++){
                pro = (nums[i] - 1) * (nums[j] - 1);

                res = Math.max(res, pro);
            }
        }

        return res;
    }

    // 3rd Approach
    public int maxProductII(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int pro = (nums[n-1] - 1) * (nums[n-2] - 1);

        return pro;
    }
}
