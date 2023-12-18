import java.util.HashMap;
import java.util.PriorityQueue;

class Food implements Comparable<Food>{
    public String foodName;
    public int foodRating;

    public Food(String foodName, int foodRating){
        this.foodName = foodName;
        this.foodRating = foodRating;
    }

    @Override
    public int compareTo(Food other){
        if(this.foodRating == other.foodRating){
            return this.foodName.compareTo(other.foodName);
        }

        return Integer.compare(other.foodRating, this.foodRating);
    }

}

class FoodRatings {
    HashMap<String, Integer> foodRatingMap;
    HashMap<String, String> foodCuisineMap;
    HashMap<String, PriorityQueue<Food>> cuisineFoodMap;

    
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodRatingMap = new HashMap<>();
        foodCuisineMap = new HashMap<>();
        cuisineFoodMap = new HashMap<>();

        for(int i = 0; i < foods.length; i++){
            foodRatingMap.put(foods[i], ratings[i]);
            foodCuisineMap.put(foods[i], cuisines[i]);

            cuisineFoodMap.computeIfAbsent(cuisines[i], t -> new PriorityQueue<>()).add(new Food(foods[i], ratings[i]));
        }
    }
    
    public void changeRating(String food, int newRating) {
        foodRatingMap.put(food, newRating);

        String cuisineName = foodCuisineMap.get(food);

        cuisineFoodMap.get(cuisineName).add(new Food(food, newRating));
    }
    
    public String highestRated(String cuisine) {
        Food food = cuisineFoodMap.get(cuisine).peek();

        while(foodRatingMap.get(food.foodName) != food.foodRating){
            cuisineFoodMap.get(cuisine).poll();

            food = cuisineFoodMap.get(cuisine).peek();
        }
        
        return food.foodName;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */