import java.util.Arrays;

class Solution {
    public int maxProductDifference(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        int pro1 = nums[0] * nums[1];
        int pro2 = nums[n-2] * nums[n-1];

        return pro2 - pro1;
    }
}

class Solution2 {
    public int maxProductDifference(int[] nums) {

        int fstMax = Integer.MIN_VALUE;;
        int secMax = Integer.MIN_VALUE;

        // Find Max & secMax element
        for(int num : nums){
            if(num > fstMax){
                secMax = fstMax;
                fstMax = num;
            }

            else if(num <= fstMax && num > secMax){
                secMax = num;
            }
        }

        int fstMin = Integer.MAX_VALUE;
        int secMin = Integer.MAX_VALUE;
        
        // Find Min & secMin element
        for(int num : nums){
            if(num < fstMin){
                secMin = fstMin;
                fstMin = num;
            } 
            
            else if(num >= fstMin && num < secMin){
                secMin = num;
            }
        }

        return (fstMax * secMax) - (fstMin * secMin);
    }
}
