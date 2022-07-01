class Solution {
    public int trap(int[] height) {
        
        int n = height.length;
        
        if(n < 3)
            return 0;
        
        int trappedWater = 0;
        
        int[] leftMax = leftMax(height);
        int[] rightMax = rightMax(height);
        
        for(int i=0; i<n; i++){
            
            int min = Math.min(leftMax[i], rightMax[i]);
            trappedWater += min-height[i];
        }
        
        return trappedWater;
        
    }
    
    // Helper method to preCompute Max values to the left;
    static int[] leftMax(int[] arr){
        
        int n = arr.length;
        int[] leftMax = new int[n];
        leftMax[0] = arr[0];
            
        for(int i=1; i<n; i++){
            int max = Math.max(arr[i], leftMax[i-1]);
            leftMax[i] = max;
            
        }
        
        return leftMax;
    }
    
    // Helper method to preCompute Max values to the right;
    static int[] rightMax(int[] arr){
        
        int n = arr.length;
        int[] rightMax = new int[n];
        rightMax[n-1] = arr[n-1];
            
        for(int i=n-2; i>=0; i--){
            int max = Math.max(arr[i], rightMax[i+1]);
            rightMax[i] = max;
            
        }
        
        return rightMax;
    }
    
}