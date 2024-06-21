class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String s1 = "";
        String s2 = "";

        // Concatenate all strings in word1 into s1
        for (int i = 0; i < word1.length; i++) {
            s1 += word1[i];
        }

        // Concatenate all strings in word2 into s2
        for (int i = 0; i < word2.length; i++) {
            s2 += word2[i];
        }

        // Check if the lengths are different
        if (s1.length() != s2.length()) {
            return false;
        }

        // Compare the characters of both strings
        int i = 0;
        int j = 0;

        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                return false;
            }
        }

        // Both strings should be fully traversed
        return i == s1.length() && j == s2.length();

    }
}