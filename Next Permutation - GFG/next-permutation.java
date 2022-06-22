// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.nextPermutation(N, arr);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < N;i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution{
    
    
    static List<Integer> nextPermutation(int n, int arr[]){
        // code here
        
        // List<Integer> list  = Arrays.stream(arr).boxed().collect( Collectors.toList() );
        // List<Integer> list = new List<Integer>(Arrays.asList(arr));
        List<Integer> list = new ArrayList<Integer>(arr.length);
        for (int i : arr)
            list.add(i);
        
        
        int peak = peakPoint(arr, n);
        if(peak == -1){
            Collections.reverse(list);
            return list;
            
        } else {
            
            int maxPeak = 0;
            for(int i=n-1; i>=0; i--){
                if(arr[i] > arr[peak]){
                    maxPeak = i;
                    break;
                }
            }
            
            swap(peak, maxPeak, arr);
            reverse(peak+1, n-1, arr);
            
            // List<Integer> reverseList  = Arrays.stream(arr).boxed().collect( Collectors.toList() );
            // List<Integer> reverseList = new List<Integer>(Arrays.asList(arr));
            List<Integer> reverseList = new ArrayList<Integer>(arr.length);
            for (int i : arr)
                reverseList.add(i);
                
            return reverseList;
        }
                
    }
    
    
    static int peakPoint(int[] arr, int n){
        
        int peak = -1;
        for(int i=n-2; i>=0; i--){
            if(arr[i] < arr[i+1]){
                peak = i;
                break;
            }
        }
        
        return peak;
    }
    
    static void reverse(int low, int high, int[] arr){
        
        while (low < high){
            swap(low, high, arr);
            low++;
            high--;
        }
        
    }    
    
    static void swap(int left, int right, int[] arr){
        
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        
    }    
    
}