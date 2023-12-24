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

/*
 *  **Here's the intuition behind the code:**

**1. Purpose:**

- The code is designed to determine whether two arrays of strings, `word1` and `word2`, contain the same sequence of characters when combined.
- It essentially checks if they represent the same string, even though they might be broken into different words within the arrays.

**2. Approach:**

- It uses two sets of indices to track progress:
    - `i` and `j` for iterating through the individual words within the arrays
    - `x` and `y` for iterating through the characters within each word
- It compares corresponding characters one by one, using `charAt()` to access them.
- It handles word boundaries by resetting `x` and `y` to 0 and advancing `i` or `j` when the end of a word is reached.

**3. Key Steps:**

1. **Initialization:**
   - Sets `i`, `j`, `x`, and `y` to 0 to start at the beginning of both arrays and their first words.

2. **Character Comparison Loop:**
   - Continues as long as there are more words and characters to compare:
     - Compares characters at `word1[i].charAt(x)` and `word2[j].charAt(y)`.
     - If they don't match, returns `false` immediately, indicating the arrays are not equal.
     - Increments `x` and `y` to move to the next characters.
     - If either `x` or `y` reaches the end of a word:
       - Resets it to 0 to start the next word.
       - Increments `i` or `j` to move to the next word in the corresponding array.

3. **Final Check:**
   - After the loop, checks if both arrays have been fully traversed:
     - If `i` and `j` have reached the lengths of `word1` and `word2` respectively, it means all characters have matched, so returns `true`.
     - Otherwise, returns `false` as there are still characters left to compare.

**In simpler terms:**

- The code imagines the two arrays as long strings, then carefully walks through them character by character, making sure each pair of characters matches.
- It pays attention to word boundaries, ensuring it doesn't try to compare characters across different words.
- If it finds any mismatch, it immediately stops and says the arrays are not equal.
- If it manages to compare all characters without any mismatches, it confidently declares that the arrays are indeed equal.

 */