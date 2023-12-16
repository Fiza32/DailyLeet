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

class Solution2 {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        int[] occurence = new int[26];

        for(int i = 0; i < s.length(); i++){
            occurence[s.charAt(i) - 'a']++;
            occurence[t.charAt(i) - 'a']--;
        }

        for(int n : occurence){
            if(n != 0){
                return false;
            }
        }

        return true;
    }
}


/*
*  
Certainly! The given Java code defines a method called `isAnagram` that takes two strings `s` and `t` as input and 
returns a boolean value. The purpose of this method is to determine whether the two input strings are anagrams of each other.

An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, using all the original 
letters exactly once. For example, "listen" and "silent" are anagrams of each other.

Here's a step-by-step explanation of the code:
1. The method first checks if the lengths of the two input strings `s` and `t` are not equal, 
in which case it immediately returns `false`, indicating that the strings cannot be anagrams due to different lengths.

2. Next, an integer array named `occurrence` of size 26 (corresponding to the 26 letters of the English alphabet) 
is created to keep track of the occurrences of each letter in the input strings.

3. Then, for each character in the strings `s` and `t`, the code increments the count of the corresponding letter in `s` 
and decrements the count of the corresponding letter in `t` within the occurrence array.

4. After processing all the characters in both strings, the code iterates through the `occurrence` array. If any element 
in the array is not equal to 0, it immediately returns `false`, indicating that the strings are not anagrams.

5. If all the elements in the `occurrence` array are 0, the method returns `true`, indicating that the input strings `s` 
and `t` are indeed anagrams of each other.

In summary, this method efficiently checks for anagrams by comparing character occurrences using an array, and returns `true` 
if the input strings are anagrams, and `false` otherwise.  
*/