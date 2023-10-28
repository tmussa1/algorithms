class Solution {
    
    public String minimizeError(String[] pricesStr, int target) {
        
        double [] prices = new double[pricesStr.length];
        
        int floorSum = 0, ceilSum = 0;
        
        for(int i = 0; i < pricesStr.length; i++){
            prices[i] = Double.parseDouble(pricesStr[i]);
            floorSum += Math.floor(prices[i]);
            ceilSum += Math.ceil(prices[i]);
        }
        
        if(ceilSum < target || target < floorSum) return "-1";
        
        int diff = 0;
        
        PriorityQueue<Double> queue = new PriorityQueue<Double>((a, b) -> {
            
            double aDiff = a - Math.floor(a);
            double bDiff = b - Math.floor(b);
            
            if(Double.compare(aDiff, bDiff) == 0){
                return Double.compare(b, a);
            }
            
            return Double.compare(bDiff, aDiff);
        });
        
        for(double price: prices){
            queue.offer(price);
        }
        
        double result = 0.0;
        int sum = 0;
        
        while(!queue.isEmpty()){
            
            double curr = queue.poll();
            
            if(diff < target - floorSum){
                sum += Math.ceil(curr);
                diff += 1;
                result += (Math.ceil(curr) - curr);
            } else {
                sum += Math.floor(curr);
                result += (curr - Math.floor(curr));
            }
        }
        
        double res = Math.round(result * 1000.0) / 1000.0;
        
        String value = String.valueOf(res);
        
        int index = value.lastIndexOf(".");
        int firstIndex = index;
        int length = value.length();
        int dif = 0;
        
        while(index < value.length() && value.charAt(index) != '0'){
            index++;
        }
        
        diff += (index - firstIndex);
        
        while(dif < 2){
            value += "0";
            dif++;
        }
        
        int index1 = value.lastIndexOf(".");
        
        return value.substring(0, index1 + 4);
    }
}