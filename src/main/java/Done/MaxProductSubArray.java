package Done;

public class MaxProductSubArray {
    public int maxProduct(int[] nums) {
        return  calculateMax(0,nums.length-1,nums);
    }

    private int calculateMax(int start, int end, int[] nums) {
        if(start == end){
            return nums[start];
        }
        int leftsub = calculateMax(start, end - 1, nums);
        int left = Math.max(leftsub * nums[end], leftsub);
        int rightsub = calculateMax(start + 1, end, nums);
        int right = Math.max(rightsub * nums[start], rightsub);
        return Math.max(left,right);
    }
}
