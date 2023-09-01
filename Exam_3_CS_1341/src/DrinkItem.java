// Jaye Ryden 48819841 Exam 3 CS 1341
public class DrinkItem extends OrderItem {
	private int size;
	
	public DrinkItem(String foodName, 
			double foodCost, 
			int size) {
		
		super(foodName, foodCost);
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public String toString() {
		
		String toString = String.format("%s - %doz - $%.2f\n", getFoodName(), size, getFoodCost());
		return toString;
		
	}
}
