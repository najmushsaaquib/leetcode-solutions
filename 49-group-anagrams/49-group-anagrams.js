/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
    
    let arr = strs;
    
    let n = arr.length;
        let obj = {}
        for(let i=0; i<n; i++){
            let temp = arr[i].split("")
            temp.sort();
            
            let str = temp.join("")
            
            if(obj[str] == undefined){
                let similar = []
                similar.push(arr[i])
                obj[str] = similar
                
            } else {
                obj[str].push(arr[i])
            }
            
        }
        
        let values = Object.values(obj)
        return values;
        
};

