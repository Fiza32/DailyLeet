// Approach 1

public class Leet_1662 {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        // Create a StringBuilder object to store concatenated words from word1
        StringBuilder sb1 = new StringBuilder();

        for (String st : word1) {
            // Append the current word to the StringBuilder object
            sb1.append(st);
        }

        String str1 = sb1.toString();

        StringBuilder sb2 = new StringBuilder();

        for (String st : word2) {
            sb2.append(st);
        }

        String str2 = sb2.toString();

        // Check if the concatenated words from both arrays are equal
        return str1.equals(str2);
    }
}


/*
 *  Time Complexity:
    Concatenation: O(n) due to iterating through each word in both arrays.
    Comparison: O(n) due to comparing the length of the final strings.
    Overall: O(n)

    Space Complexity:
    Concatenation: O(n) due to storing the concatenated strings in StringBuilder objects.
    Comparison: O(1) as temporary variables have constant memory usage.
    Overall: O(n)
 */


//  Approach 2

class SolutionTwo {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        // It will Join all String of word1 with an empty string
        String str1 = String.join("", word1);
        String str2 = String.join("", word2);

        return str1.equals(str2);
    }
}


// Approach 3
class SolutionThird {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i = 0, j = 0;
        int x = 0, y = 0;

        while(i < word1.length && j < word2.length){
            // At any point, If character of String of both
            // array word1 & word2 doesn't match return false
            if(word1[i].charAt(x++) != word2[j].charAt(y++)){
                return false;
            }

            // Have you done with String at index i of word1?
            // Go ahead, look for other String
            if(x == word1[i].length()){
                x = 0;
                i++;
            }

            if(y == word2[j].length()){
                y = 0;
                j++;
            }
        }

        // Have you gone through each word of array 
        // word1 & word2? then return true, otherwise false
        return word1.length == i && word2.length == j;
    }
}