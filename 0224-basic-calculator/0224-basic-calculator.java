class Solution {

    int index = 0;

    public int calculate(String s) {

        int sum = 0, operator = 1;

        while(index < s.length()){
            char c = s.charAt(index);
            if(c == ')'){
                break;
            } else if(c == '('){
                index++;
                sum += operator * calculate(s);
            } else if(c == '-'){
                operator = -1;
            } else if(c == '+'){
                operator = 1;
            } else if(Character.isDigit(c)){

               int firstIndex = index;

               while(index < s.length() && Character.isDigit(s.charAt(index))){
                   index++;
               }

               sum += operator * Integer.parseInt(s.substring(firstIndex, index));
               index--;
            }
            index++;
        }

        return sum;
    }
}