class UndergroundSystem {
    
    private Map<Integer, List<Time>> checkInMap;
    private Map<String, List<Time>> stationMap;

    public UndergroundSystem() {
        this.checkInMap = new HashMap<>();
        this.stationMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        List<Time> checkins = checkInMap.getOrDefault(id, new ArrayList<>());
        List<Time> stations = stationMap.getOrDefault(stationName, new ArrayList<>());
        Time time = new Time();
        time.id = id;
        time.startTime = t;
        time.startStation = stationName;
        checkins.add(time);
        stations.add(time);
        checkInMap.put(id, checkins);
        stationMap.put(stationName, stations);
    }
    
    public void checkOut(int id, String stationName, int t) {
        
        List<Time> checkins = checkInMap.get(id);
        
        for(Time time: checkins){
            
            if(time.endTime == -1){
                
                time.endTime = t;
                time.endStation = stationName;
                List<Time> stations = stationMap.get(time.startStation);
                
                for(Time station: stations){
                    if(station.id == id && station.endTime == -1){
                         station.endTime = t;
                         station.endStation = stationName;
                    }
                }
                stationMap.put(time.startStation, stations);
            }
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        
        List<Time> stations = stationMap.get(startStation);
        
        double result = 0.0;
        
        int count = 0;
        
        for(Time station: stations){
            if(station.endTime != -1 && station.endStation.equals(endStation)){
                result += (station.endTime - station.startTime);
                count++;
            }
        }
        
        return (result * 1.0 / count);
    }
    
    class Time {
        int id;
        int startTime;
        int endTime = -1;
        String startStation = null;
        String endStation = "N/A";
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */