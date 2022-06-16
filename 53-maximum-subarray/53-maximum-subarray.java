class Solution {
    public int maxSubArray(int[] nums) {
        
        int currentSum = nums[0];
        int sumSoFar = nums[0];
        
        for(int i=1; i<nums.length; i++){
            currentSum = currentSum > 0 ? currentSum + nums[i] : nums[i];
             sumSoFar = Math.max(currentSum, sumSoFar);
        }
        return sumSoFar;    
    }
}