package Done;

import java.util.concurrent.atomic.AtomicInteger;

public class MaximumSubArrayDP {

    //https://leetcode.com/problems/maximum-subarray/description/
    public int maxSubArray(int[] nums) {
        int currentMax = nums[0];
        int finalMax = Integer.MIN_VALUE;
        for(int i=1;i< nums.length;i++){
            currentMax = nums[i] + (Math.max(currentMax, 0));
            finalMax = Math.max(finalMax,currentMax);
        }
        return finalMax;
    }
}
