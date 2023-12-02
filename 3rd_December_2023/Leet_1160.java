import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> charFreqMap = new HashMap<>();
        int result = 0;

        for (char ch : chars.toCharArray()) {
            charFreqMap.put(ch, charFreqMap.getOrDefault(ch, 0) + 1);
        }

        for (String word : words) {
            if (canFormWord(word, new HashMap<>(charFreqMap))) {
                result += word.length();
            }
        }

        return result;
    }

    private boolean canFormWord(String word, Map<Character, Integer> charFreqMap) {
        for (char ch : word.toCharArray()) {
            if (!charFreqMap.containsKey(ch) || charFreqMap.get(ch) == 0) {
                return false;
            }
            charFreqMap.put(ch, charFreqMap.get(ch) - 1);
        }
        return true;
    }
}

