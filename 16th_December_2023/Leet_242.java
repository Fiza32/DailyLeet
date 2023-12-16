import java.util.*;

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        HashMap<Character, Integer> charMap = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            charMap.put(sChar, charMap.getOrDefault(sChar, 0) + 1);
            charMap.put(tChar, charMap.getOrDefault(tChar, 0) - 1);
        }
        
        for(char ch : charMap.keySet()){
            if(charMap.get(ch) != 0){
                return false;
            }
        }

        return true;
    }
}