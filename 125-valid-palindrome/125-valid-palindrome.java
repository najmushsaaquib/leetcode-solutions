class Solution {
    public boolean isPalindrome(String str) {
        
        str = str.toLowerCase();
        
        int l = 0;
        int h = str.length() - 1;
        
        while(l <= h){
            char cl = str.charAt(l);
            char ch = str.charAt(h);
            
            if(!(( cl >= 'a' && cl <= 'z')  || ( cl >= '0' && cl <= '9'))){
                l++;
            }

            else if(!(( ch >= 'a' && ch <= 'z')  ||  ( ch >= '0' && ch <= '9') )){
                h--;
            }
            
            else if(cl == ch){
                l++;
                h--;
            }
            
            else
               return false;     

        }
        
        return true;
    }
}