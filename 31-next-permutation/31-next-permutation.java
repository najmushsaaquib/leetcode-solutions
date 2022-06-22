class Solution {
    public void nextPermutation(int[] nums) {
        
        int n = nums.length;
        int peek = peekPoint(nums);
        
        if(peek == -1){
            reverse(nums, 0, n-1);
            
        } else {
            int peekEnd = n-1;
            for(int i=n-1; i>=0; i--){
                if(nums[i] > nums[peek]){
                    peekEnd = i;
                    break;
                }
            }
            
            swap(nums, peek, peekEnd);
            reverse(nums, peek+1, n-1);
        }
        
    }
    
    static int peekPoint(int[] arr){
        
        int n = arr.length;
        int peek = -1;
        
        for(int i=n-2; i>=0; i--){
            if(arr[i] < arr[i+1]){
                peek =  i;
                break;
            }
        }
        
        return peek;
    }
    
    static void swap(int[] arr, int low, int high){
        
        int temp = arr[high];
        arr[high] = arr[low];
        arr[low] = temp;
    }
    
    static void reverse(int[] arr, int low, int high){
        
        while(low < high){
            swap(arr, low, high);
            low++;
            high--;
        }
        
    }
}