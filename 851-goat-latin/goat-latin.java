class Solution {
    public String toGoatLatin(String sentence) {
        String[] arr = sentence.split(" ");
        int count = 1;
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            String word = arr[i];
            String lw = word.toLowerCase();
            if (lw.startsWith("a") || lw.startsWith("e") || lw.startsWith("i") || lw.startsWith("o") || lw.startsWith("u")) {
                word += "ma";
            } else {
                word = word.substring(1) + word.charAt(0) + "ma";
            }
            word += "a".repeat(count);
            count++;
            ans.append(word);
            if (i != arr.length - 1) {
                ans.append(" ");
            }
        }
        return ans.toString();
    }
}