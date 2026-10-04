class Solution {
    public int maxPalindromesAfterOperations(String[] words) {
       int[] freq = new int[26];
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                freq[ch - 'a']++;
            }
        }
        int totalPairs = 0;
        for (int f : freq) {
            totalPairs += f / 2;
        }
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int ans = 0;
        for (String word : words) {
            int neededPairs = word.length() / 2;
            if (totalPairs >= neededPairs) {
                totalPairs -= neededPairs;
                ans++;
            } else {
                break;
            }
        }
        return ans;
    }
}