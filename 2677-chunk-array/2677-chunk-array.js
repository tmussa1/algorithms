/**
 * @param {Array} arr
 * @param {number} size
 * @return {Array}
 */
var chunk = function(arr, size) {
    
    count = 0, index = 0;
    
    result = [];
    curr = [];
    
    while(index < arr.length){
        
        curr= [...curr, arr[index]];
        count++;
        index++;
        
        if(count == size || index == arr.length){
            result = [...result, curr];
            curr = [];
            count = 0;
        }
    }
    
    return result;
};
