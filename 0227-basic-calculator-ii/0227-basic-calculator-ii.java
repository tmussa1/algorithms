class Solution {
    public int calculate(String s) {

        Stack<Integer> stack = new Stack<>();

        int index = 0, sum = 0;
        char operator = '+';

        while(index < s.length()){

            char c = s.charAt(index);

            if(Character.isDigit(c)){

                int firstIndex = index;

                while(index < s.length() && Character.isDigit(s.charAt(index))) {
                    index++;
                }

                int num = Integer.parseInt(s.substring(firstIndex, index));

                if(operator == '+'){
                    stack.push(num);
                } else if(operator == '-'){
                    stack.push(-1 * num);
                } else if(operator == '*'){
                    stack.push(stack.pop() * num);
                } else if(operator == '/'){
                    stack.push(stack.pop() / num);
                }
                index--;
            } else if(c == '-' || c == '+' || c == '/' || c == '*'){
                operator = c;
            }

            index++;
        }

        while(!stack.isEmpty()){
            sum += stack.pop();
        }

        return sum;
    }
}