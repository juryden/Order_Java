// Jaye Ryden 48819841 Exam 3 CS 1341
import java.io.PrintWriter;
import java.util.ArrayList;

public class Order {
	ArrayList<OrderItem> totalOrder = new ArrayList<OrderItem>();

	public Order() {

	}
	
	public void addItemToOrder(OrderItem OrderItem) {
		this.totalOrder.add(OrderItem);
	}
	
	public void clearOrder() {
		this.totalOrder.clear();
	}
	
	public double orderTotalCost() {
		
		double totalCost = 0;
		for(int i = 0; i < totalOrder.size(); i++) {
			totalCost += totalOrder.get(i).getFoodCost();
		}
		return totalCost;
	}
	
	public void printReceipt(String name) {
		try { 
			String receiptName = name;
			PrintWriter pw = new PrintWriter(receiptName);
			pw.printf("%s\n", toString());
			pw.printf("Tax: $%.2f\n", orderTotalCost()*.08);
			pw.printf("Final Cost: $%.2f", (orderTotalCost() + (orderTotalCost()*.08)));
			pw.close();
		}
		
		catch (Exception ex) {
			System.out.println("File failed to create");
		}
	}
	
	public String toString() {
		
		String toString = "Order:\n";
		for(int i = 0; i < totalOrder.size(); i++) {
			toString += String.format("%s", totalOrder.get(i).toString());
		}
		toString += String.format("Total: $%.2f\n", orderTotalCost());
		return toString;
		
	}

}
