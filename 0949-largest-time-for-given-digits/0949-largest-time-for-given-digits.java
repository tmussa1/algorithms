class Solution {
    
    public String largestTimeFromDigits(int[] arr) {
        
        LinkedList<String> hours = new LinkedList<>();
        LinkedList<String> minutes = new LinkedList<>();
        
        Map<Integer, Integer> countMap = new HashMap<>();
        
        for(int num: arr){
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        permute(arr, hours, minutes, 0, new StringBuilder(), countMap);
        
        Collections.sort(hours, Collections.reverseOrder());
        Collections.sort(minutes, Collections.reverseOrder());
        
        if(hours.size() == 0 || minutes.size() == 0) return "";
        
        String minute = null, hour = null;
        
        int index = 0;
        
        while(minute == null && index < hours.size()){
            
            hour = hours.get(index);
        
            int h1 = hour.charAt(0) - '0', h2 = hour.charAt(1) - '0';

            countMap.put(h1, countMap.getOrDefault(h1, 0) - 1);
            countMap.put(h2, countMap.getOrDefault(h2, 0) - 1);

            for(int i = 0; i < minutes.size(); i++){
                String min = minutes.get(i);
                if((min.charAt(0) != min.charAt(1) || countMap.get(min.charAt(0) - '0') > 1) && countMap.get(min.charAt(0) - '0') > 0 && countMap.get(min.charAt(1) - '0') > 0){
                    minute = min;
                    break;
                }
            }
            
            countMap.put(h1, countMap.getOrDefault(h1, 0) + 1);
            countMap.put(h2, countMap.getOrDefault(h2, 0) + 1);
            index++;
        }
        
        if(minute == null) return "";
        
        return hour + ":" + minute;
    }
    
    private void permute(int[] arr, LinkedList<String> hours, 
                         LinkedList<String> minutes, int index,
                         StringBuilder builder,
                         Map<Integer, Integer> countMap){
        
        if(index == arr.length){
            return;
        }
        
        for(int i = 0; i < arr.length; i++){
            
            if(countMap.get(arr[i]) > 0){
            
                builder.append(arr[i]);
                countMap.put(arr[i], countMap.getOrDefault(arr[i], 0) - 1);

                if(isValidHour(builder.toString())){
                    hours.add(new String(builder.toString()));
                }

                if(isValidMinute(builder.toString())){
                    minutes.add(new String(builder.toString()));
                }

                permute(arr, hours, minutes, index + 1, builder, countMap);

                builder.deleteCharAt(builder.length() - 1);
                countMap.put(arr[i], countMap.getOrDefault(arr[i], 0) + 1);
            }
        }
    }
    
    private boolean isValidHour(String hour){
        return hour.length() == 2 && (hour.charAt(0) == '0' || Integer.parseInt(hour) < 24);
    }
    
    private boolean isValidMinute(String minute){
        return minute.length() == 2 && (minute.charAt(0) == '0' || Integer.parseInt(minute) < 60);
    }
}