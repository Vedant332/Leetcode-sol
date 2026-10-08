public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        String temp="";
        for(int i=0;i<strs.size();i++){
            String word=strs.get(i);
            int num=word.length();
            temp+=num+"#"+word;
        }
        return temp;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
         List<String> ans = new ArrayList<>();
         int i=0;
         while (i < s.length()) {
        int j = i;
        while (s.charAt(j) != '#') {
            j++;
        }
        int len = Integer.parseInt(s.substring(i, j));
        int start = j + 1;
        String word = s.substring(start, start + len);
        ans.add(word);
        i = start + len;
    }

    return ans;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));