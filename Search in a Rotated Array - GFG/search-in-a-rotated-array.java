// { Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0)
        {
            int n = sc.nextInt();
            int A[] = new int[n];
            
            for (int i = 0;i < n;i++)
            {
                A[i] = sc.nextInt();
            }
            int key = sc.nextInt();
            
            System.out.println(new Solution().search(A, 0, n - 1, key));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    int search(int A[], int l, int h, int key)
    {
        int pivot = -1;
        while(l <= h){
        int mid = l + (h-l)/2;
            if(A[mid] > A[h]){
                l++;
            } else {
                h--;
            }
            
            if(l == h){
                pivot = l;
                break;
            }            
        }
        
        
        
        if(A[0] <= key)
            return recursiveBinary(A, 0, pivot-1, key);
            
        return recursiveBinary(A, pivot+1, A.length-1, key);
        
    }
    
    // simple binary
    int binary(int[] arr, int low, int high, int key){
        
        while(low <= high){
            
            int mid = low + (high-low)/2;
            
            if(arr[mid] == key) 
                return mid;
                
            else if (arr[mid] > key) 
                high--;
            
            else low++;
        }
        
        return -1;         
    }
    
    // recursive binary
    int recursiveBinary(int[] arr, int low, int high, int key){
        
        if(high < low)
            return -1;
        
        int mid = low + (high-low)/2;
        
        if(arr[mid] == key)
            return mid;
            
        if(key > arr[mid]) 
            return recursiveBinary(arr, mid+1, high, key);
        else 
            return recursiveBinary(arr, low, mid-1, key);
    }
    
    
}