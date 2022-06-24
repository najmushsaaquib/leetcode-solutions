class Solution {
    public int[] sortArray(int[] nums) {
        
        int lo=0;
        int hi=nums.length-1;
        
       int[] sortedArr= mergSort(nums,lo,hi);
        
        return sortedArr; 
      

    }
    
    public int[] mergSort(int[] arr,int lo,int hi){
        
        if(lo==hi){
            int[] ba=new int[1];
            ba[0]=arr[lo];
            return ba;
        }
        
        int mid=lo+(hi-lo)/2;
        
        int[] fsa=mergSort(arr,lo,mid);
        int[] ssa= mergSort(arr,mid+1,hi);
        
        int[] flsa=merge(fsa,ssa);
        return flsa;
        
    }
    
    public static int[] merge(int[] arr1,int[] arr2){
        
        int i=0;
        int j=0;
        int k=0;
        
        int[] newarr=new int[arr1.length+arr2.length];
        while(i<arr1.length&&j<arr2.length){
            
            if(arr1[i]<arr2[j]){
                newarr[k]=arr1[i];
                    k++;
                    i++;
            }
            else{
                newarr[k]=arr2[j];
                k++;
                j++;
            }
        }
        
        if(i<arr1.length){
            while(i<arr1.length){
                  newarr[k]=arr1[i];
                    k++;
                    i++;
            }
        }
        if(j<arr2.length){
            while(j<arr2.length){
             newarr[k]=arr2[j];
                k++;
                j++;
         }
        }
        
        return newarr;
    }
}