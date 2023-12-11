import java.util.HashMap;
import java.util.Map;

public class Leet_1287 {
    // Using HashMap
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int x = n / 4;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int ans = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();

            if (value > x) {
                Integer key = entry.getKey();
                ans = key;
            }
        }

        return ans;
    }

    // Without HashMap
    public int findSpecialIntegerII(int[] arr) {
        int n = arr.length;
        int qtr = n / 4;

        int ans = arr[0];
        int cnt = 1;

        for(int i = 1; i < n; i++){
            if(arr[i] == ans){
                cnt++;
            } else {
                cnt = 1;
            }

            if(cnt > qtr){
                return arr[i];
            }

            ans = arr[i];
        }

        return ans;
    }
}
