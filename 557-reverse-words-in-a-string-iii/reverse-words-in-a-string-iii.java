class Solution {
    public String reverseWords(String s) {
         String[] words = s.split(" ");
        // Reverse each word
        for (int i = 0; i < words.length; i++) {
            words[i] = reverse(words[i]);
        }
        // Join the reversed words with a space
        return String.join(" ", words);
    }

    private String reverse(String word) {
        char[] chars = word.toCharArray();
        int i = 0, j = chars.length - 1;
        // Swap the characters while i < j
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return new String(chars);
    }
}