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
