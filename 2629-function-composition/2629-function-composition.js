/**
 * @param {Function[]} functions
 * @return {Function}
 */
var compose = function(functions) {
    
	return function(x) {
        
        result = x;
        
        for(index = functions.length - 1; index >= 0; index--){
            result = functions[index](result)
        }
        
        return result;
    }
};

/**
 * const fn = compose([x => x + 1, x => 2 * x])
 * fn(4) // 9
 */