class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
         List<Integer> ans = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
        if (uniqueWords.size() == 1) {
            words = new String[]{String.join("", words)};
        }

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int wordLen = words[0].length();
        int numOfWords = words.length;
        int substringLen = wordLen * numOfWords;

        for (int i = 0; i <= s.length() - substringLen; i++) { // Fix: Adjusted loop condition to prevent TLE
            HashMap<String, Integer> mapCopy = new HashMap<>(map);

            int start = i;
            int end = i + substringLen;

            if (end > s.length()) break;

            if (isValid(s.substring(start, end), mapCopy, wordLen, numOfWords)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean isValid(String s, HashMap<String, Integer> map, int wordLen, int numOfWords) {
        int i = 0;

        while (i < numOfWords * wordLen) {
            String word = s.substring(i, i + wordLen);

            if (!map.containsKey(word) || map.get(word) <= 0) {
                return false;
            }
            map.put(word, map.get(word) - 1);
            i += wordLen;
        }
        return true;
    }
}