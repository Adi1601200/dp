package Done;

import java.util.HashMap;
import java.util.Map;

public class MaxSubArrayTwo {
    public int maxSubArray(int[] nums) {
        Map<String, int[]> map = new HashMap<>();
        int[] ans = calculateMax(0, nums.length-1, nums,map);
        return ans[0];
    }

    private int[] calculateMax(int start, int end, int[] nums, Map<String, int[]> map) {
        if(start>end){
            return new int[]{0, 0};
        }
        if(start == end){
            return new int[]{nums[start], nums[start]};
        }
        if(map.containsKey(start + "|" + end)){
            return map.get(start + "|" + end);
        }
        int[] left = calculateMax(start,end-1,nums,map);
        int[] right = calculateMax(start+1,end,nums,map);
        int leftMax = left[0];
        int leftOriginal = left[1];
        int rightMax = right[0];
        int rightOriginal = right[1];
        int currentOriginal = nums[end] + leftOriginal;
        int currentMax = Math.max(currentOriginal,leftMax);
        currentMax = Math.max(currentMax,rightMax);
        int[] result = new int[]{currentMax, currentOriginal};
        map.put(start + "|" + end,result);
        return result;
    }
}
