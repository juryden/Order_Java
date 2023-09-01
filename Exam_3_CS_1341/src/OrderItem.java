// Jaye Ryden 48819841 Exam 3 CS 1341
public class OrderItem {
		private String foodName;
		private double foodCost;
		
		public OrderItem(String foodName, double foodCost) {
			this.foodName = foodName;
			this.foodCost = foodCost;
		}

		public String getFoodName() {
			return foodName;
		}

		public void setFoodName(String foodName) {
			this.foodName = foodName;
		}

		public double getFoodCost() {
			return foodCost;
		}

		public void setFoodCost(double foodCost) {
			this.foodCost = foodCost;
		}
		
		public String toString() {
			
			String toString = String.format("%s - $%.2f\n", getFoodName(), getFoodCost());
			return toString;
			
		}
}
