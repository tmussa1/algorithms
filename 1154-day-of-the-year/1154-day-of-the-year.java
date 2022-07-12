import java.time.LocalDate;

class Solution {
    
    public int dayOfYear(String date) {
        
        String [] split = date.split("-");
        
        String year = split[0];
        String month = split[1];
        String day = split[2];
        
        if(day.charAt(0) == '0'){
            day = day.substring(1);
        }
        
        if(month.charAt(0) == '0'){
            month = month.substring(1);
        }
        
        Integer dayNum = Integer.parseInt(day);
        
        Integer monthNum = Integer.parseInt(month);
        
        Integer yearNum = Integer.parseInt(year);
        
        int sum = dayNum;
        
        for(int i = 1; i < monthNum; i++){
            sum += numDaysInAMonth(yearNum, i);
        }
        
        return sum;
    }
    
    int numDaysInAMonth(int year, int month){
        
        LocalDate date = LocalDate.of(year, month, 1);
        
        return date.lengthOfMonth();
    }
}