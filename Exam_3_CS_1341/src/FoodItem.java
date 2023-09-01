// Jaye Ryden 48819841 Exam 3 CS 1341
public class FoodItem extends OrderItem {
	private String mainIngredient;
	
	public FoodItem(String foodName,
			double foodCost, 
			String mainIngredient) {
		
		super(foodName, foodCost);
		this.mainIngredient = mainIngredient;
	}
	
	public String toString() {
		
		String toString = String.format("%s - %s - $%.2f\n", getFoodName(), mainIngredient, getFoodCost());
		return toString;
		
	}

	public String getMainIngredient() {
		return mainIngredient;
	}

	public void setMainIngredient(String mainIngredient) {
		this.mainIngredient = mainIngredient;
	}
	
}
