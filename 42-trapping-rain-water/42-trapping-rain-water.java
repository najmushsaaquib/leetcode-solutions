class Solution {
    public int trap(int[] arr) {
        
        int n = arr.length;
        if(n < 3)
            return 0;
        
        int trappedWater = 0;
        
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        
        //PreComputing Max values to the left;
        leftMax[0] = arr[0];
        for(int i=1; i<n; i++)
            leftMax[i] = Math.max(arr[i], leftMax[i-1]);
        
         //PreComputing Max values to the right;
         rightMax[n-1] = arr[n-1];
         for(int i=n-2; i>=0; i--)
            rightMax[i] = Math.max(arr[i], rightMax[i+1]);
        
         //Computing how much water can be trapped
         for(int i=0; i<n; i++){
            int min = Math.min(leftMax[i], rightMax[i]);
            trappedWater += min-arr[i];
         }
        
         return trappedWater;
    }
    
}