public class Leet_2264 {

    public static String findMaxThreeDigit(String str){
        for(int i = 9; i >= 0; i++){
            // Create a String of maximum 3 digits number
            String s = String.valueOf(i).repeat(3);

            // If s is a substring of str
            if(str.contains(s)){
                return s;
            }
        }

        return "";
    }
}