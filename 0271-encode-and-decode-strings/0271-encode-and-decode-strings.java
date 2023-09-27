public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {

        StringBuilder builder = new StringBuilder();

        for(int index = 0; index < strs.size(); index++){
            String word = strs.get(index);
            int length = word.length();
            builder.append(length);
            builder.append("#");
            builder.append(word);
        }

        return builder.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int index = 0;

        List<String> result = new ArrayList<>();

        while(index < s.length()){

            int firstIndex = index;

            while(s.charAt(firstIndex) != '#'){
                firstIndex++;
            }

            String digits = s.substring(index, firstIndex);

            Integer digitsNum = Integer.parseInt(digits);

            String currStr = s.substring(firstIndex + 1, firstIndex + digitsNum + 1);

            result.add(currStr);
            index = firstIndex + digitsNum + 1;
        }

        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));