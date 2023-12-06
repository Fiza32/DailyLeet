class Solution {
    public int totalMoney(int n) {
        int weekValue;
        int dayValue;
        int totalValue = 0;

        int i = 1;
        
        while(i <= n){
            weekValue = i / 7;
            dayValue = i % 7;

            if(dayValue == 0){
                dayValue = 6;
            }

            totalValue += (weekValue + dayValue);
            i++;
        }

        return totalValue;
    }
}