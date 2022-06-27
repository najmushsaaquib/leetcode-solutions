class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int i=0, j=0, k=0;
        int[] merge = new int[m+n];
        
        while( i<m && j<n )
          merge[k++] = ( nums1[i] <= nums2[j] ) ? nums1[i++] : nums2[j++];  
        
        while( i<m )
             merge[k++] = nums1[i++];
        
        while( j<n )
              merge[k++] = nums2[j++];
        
        for(int s=0; s<n+m;s++)
            nums1[s] = merge[s];
    }
}