/**
 * @param {string} s
 * @return {boolean}
 */
var isPalindrome = function(s) {
    
   let arr = []
   
   for(let i=0; i<s.length; i++){
       
       if((s[i] >= "A" && s[i]  <= "Z") || (s[i] >= "a" && s[i] <= "z") || (s[i] >= "0" && s[i] <= "9")){
           arr.push(s[i].toLowerCase())
       } 
   }
    
    let seedha = arr.join("");
    let ulta = arr.reverse().join("")
    console.log(seedha, ulta)
    return seedha == ulta;
    
};