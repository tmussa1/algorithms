class Logger {

    private Map<String, Integer> timeMap;
        
    public Logger() {
        this.timeMap = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        
        if(this.timeMap.containsKey(message)){
            
            if(timestamp >= this.timeMap.get(message)){
                this.timeMap.replace(message, timestamp + 10);
                return true;
            } else {
                return false;
            }
        } 
        
        this.timeMap.put(message, timestamp + 10);
        return true;  
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */