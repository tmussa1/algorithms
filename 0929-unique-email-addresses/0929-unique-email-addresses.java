class Solution {

    public int numUniqueEmails(String[] emails) {
        
        Set<String> uniqueEmails = new HashSet<>();

        for(String email: emails){
            String [] emailSplit = email.split("@");
            String localEmail = emailSplit[0];
            StringBuilder builder = new StringBuilder();

            inner:
            for(int i = 0; i < localEmail.length(); i++){
                char c = localEmail.charAt(i);
                if(c == '+'){
                    break inner;
                } else if(c == '.'){
                    continue;
                } else {
                    builder.append(c);
                }
            }
            builder.append("@");
            builder.append(emailSplit[1]);
            uniqueEmails.add(builder.toString());
        }

        return uniqueEmails.size();
    }
}