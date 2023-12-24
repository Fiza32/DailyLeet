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


class SolutionII {
    public int countCharacters(String[] words, String chars) {
        int[] charFreqInChars = new int[26];
        for(char ch : chars.toCharArray()){
            charFreqInChars[ch - 'a']++;
        }

        int sum = 0;

        for(String word : words){
            int[] charFreqInWord = new int[26];

            for(char ch : word.toCharArray()){
                charFreqInWord[ch - 'a']++;
            }

            boolean flag = true;
            for(int i = 0; i < 26; i++){
                if(charFreqInWord[i] > charFreqInChars[i]){
                    flag = false;
                    break;
                }
            }

            if(flag) sum += word.length();
        }

        return sum;
    }
}