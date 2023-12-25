# 91. Decode Ways

A message containing letters from A-Z can be encoded into numbers using the following mapping:

'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:

"AAJF" with the grouping (1 1 10 6)
"KJF" with the grouping (11 10 6)
Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".

Given a string s containing only digits, return the number of ways to decode it.

The test cases are generated so that the answer fits in a 32-bit integer.
 

## Example 1:

    Input: s = "12"
    Output: 2
    Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).


## Example 2:

    Input: s = "226"
    Output: 3
    Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).


## Example 3:

    Input: s = "06"
    Output: 0
    Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").
 

## Constraints:

    1 <= s.length <= 100
    s contains only digits and may contain leading zero(s).


## Intuition
<!-- Describe your first thoughts on how to solve this problem. -->

## Approach
<!-- Describe your approach to solving the problem. -->
1. Base Cases: Handle empty string and strings starting with 0 (no valid decodings).
2. Initialization: Set count1 and count2 to 1 for initial single-digit decodings.
3. Iterative Decoding:
    - Iterate through the string from the second character onwards:
        - Extract current digit and two-digit combination.
        - Calculate potential decodings:
            - If current digit is valid (1-9), add count2 (decodings ending with the previous digit).
            - If two-digit combination is valid (10-26), add count1 (decodings ending with the two-digit combination).
        - Update count1 and count2 for the next iteration.
4. Return Final Count: Return count2 (decodings for the entire string)


## Complexity
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
- Time complexity: O(n), where n is the length of the string. Each character is processed once.

<!-- Add your space complexity here, e.g. $$O(n)$$ -->
- Space complexity: O(1), using constant extra space for variables.


## Code

```java
class Solution {
    public int numDecodings(String s) {
        // Handle base cases: 
        // empty string or string starting with 0 (no valid decodings)
        if(s.length() == 0 || s.charAt(0) == '0') return 0;
        // Single-digit string has one decoding
        if(s.length() == 1) return 1;

        // Initialize counts for decodings ending with the first and second digits
        int countEndingWithOneDigit = 1; 
        int countEndingWithTwoDigits = 1;

        // Iterate through the string from the second character onwards
        for(int i = 1; i < s.length(); i++){
            // Extract current digit and two-digit combination
            int currentDigit = s.charAt(i) - '0';
            int twoDigitCombination = (s.charAt(i-1) - '0') * 10 + currentDigit;

            // Count potential decodings
            int cnt = 0;

            // If current digit is valid (1-9), add decodings ending with it
            if(currentDigit > 0) cnt += countEndingWithTwoDigits;

            // If two-digit combination is valid (10-26), add decodings ending with it
            if(twoDigitCombination >= 10 && twoDigitCombination <= 26) cnt += countEndingWithOneDigit;

            // Update counts for the next iteration
            countEndingWithOneDigit = countEndingWithTwoDigits;
            countEndingWithTwoDigits = cnt;
        }

        // Return the final count of decodings
        return countEndingWithTwoDigits;
    }
}
```