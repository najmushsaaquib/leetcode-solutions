class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int n = heights.length;
        int[] leftSmall = leftSmall(heights,n);
        int[] rightSmall = rightSmall(heights,n);
        
        int maxArea = 0;
        
        for(int i=0; i<n; i++){
            
            int diff = (rightSmall[i] - leftSmall[i]) - 1;
            int area = diff * heights[i];
            maxArea = Math.max(maxArea, area);
        }
        
        return maxArea;
        
    }
    
    // Function to find left smaller element for each index
    public int[] leftSmall(int[] arr, int n){
        
        Stack<Integer> stack = new Stack();
        int[] leftSmaller = new int[n];
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && arr[i] <= arr[stack.peek()])
                    stack.pop();
            
            if(stack.isEmpty())
                leftSmaller[i] = -1;
            else 
                leftSmaller[i] = stack.peek();
            
            stack.push(i);
        }
        
        return leftSmaller;
    }
    
    // Function to find right smaller element for each index
    public int[] rightSmall(int[] arr, int n){
        
        Stack<Integer> stack = new Stack();
        int[] rightSmaller = new int[n];
        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && arr[i] <= arr[stack.peek()])
                    stack.pop();
            
            if(stack.isEmpty())
                rightSmaller[i] = n;
            else 
                rightSmaller[i] = stack.peek();
            
            stack.push(i);
        }
        
        return rightSmaller;
    }
    
}