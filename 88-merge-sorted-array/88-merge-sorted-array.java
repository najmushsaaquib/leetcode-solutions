class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int i=0;
        int j=0;
        int k=0;
        
        int[] merge = new int[m+n];
        
        while( i<m && j<n ){
            
            if(nums1[i] <= nums2[j]){
                merge[k] = nums1[i];
                i++;
                k++;
            } else {
                
                merge[k] = nums2[j];
                j++;
                k++;
            }
            
        }
        
        while( i<m ){
             merge[k] = nums1[i];
                i++;
                k++;
            
        }
        while( j<n ){
              merge[k] = nums2[j];
                j++;
                k++;
            
        }
        
        
        for(int s=0; s<n+m;s++){
            nums1[s] = merge[s];
        }            
        
    }
}