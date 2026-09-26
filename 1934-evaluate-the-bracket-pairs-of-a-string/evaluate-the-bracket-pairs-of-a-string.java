class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        StringBuilder sb = new StringBuilder();
        Map<String, String> map = new HashMap<>();
        int n = s.length();

        for(List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c == '(') {
                int start = i + 1, end = i + 1;
                while(s.charAt(end) != ')') {
                    end++;    
                }
                String key = s.substring(start, end);
                i = end;
                String value = map.get(key);
                if(value == null) {
                    sb.append("?");
                }
                else {
                    sb.append(value);
                }
            }
            else
                sb.append(c);
        }
        return sb.toString();
    }
}