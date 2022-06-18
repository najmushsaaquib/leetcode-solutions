/**
 * @param {string} s
 * @return {boolean}
 */
var isPalindrome = function(s) {
    let str=s.toLowerCase();
    
    if(str.length == 1) return true;
    
    let low = 0;
    let high = str.length - 1;

    while(low <= high){
        
        let lower = str[low]
        let upper = str[high]
        
        if(   ! ((lower >= "a" && lower <= "z") ||  (lower >= "0" && lower <= "9"))){
           low++; 
        }
        
        else if(   !  (  (upper >= "a" && upper <= "z")  ||  (upper >= "0" && upper <= "9"))){
           high--; 
        } 
        
        else if(lower == upper){
            low++;
            high--;
        } 
        
        else 
             return false;   
    }
    
    return true;
};