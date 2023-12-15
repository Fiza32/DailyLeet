public class Leet_1436 {
    public String destCity(List<List<String>> paths) {
        HashSet<String> set = new HashSet<>();

        for(List<String> list: paths){

            for(String str : list){
                set.add(str);
                break;
            }
        }

        for(List<String> list: paths){

            for(String str : list){
                if(!set.contains(str)){
                    return str;
                }
            }
        }

        return "";
    }
}


