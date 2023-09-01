// Jaye Ryden 48819841 Exam 3 CS 1341
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class OrderGUI extends JFrame{
	private JButton addFoodButton;
	private JButton addDrinkButton;
	private JButton printReceiptButton;
	private JButton clearOrderButton;
	private JScrollPane scrollPane;
	private JTextArea receiptPrintOut;
	
	private boolean addFoodState = false;
	private boolean addDrinkState = false;
	private boolean printReceiptState = false;
	private boolean clearState = false;
	
	Order order = new Order();
	
	public OrderGUI() {
		
		super("Order");
		
		addFoodButton = new JButton("Add Food");
		addDrinkButton = new JButton("Add Drink");
		printReceiptButton = new JButton("Print Receipt");
		clearOrderButton = new JButton("Clear Order");
		receiptPrintOut = new JTextArea(20,30);
		scrollPane = new JScrollPane(receiptPrintOut);
		
		MyInner myInner = new MyInner();
		
		addFoodButton.addActionListener(myInner);
		addDrinkButton.addActionListener(myInner);
		printReceiptButton.addActionListener(myInner);
		clearOrderButton.addActionListener(myInner);
		
		setLayout(new FlowLayout());
		
		add(addFoodButton);
		add(addDrinkButton);
		add(printReceiptButton);
		add(clearOrderButton);
		add(scrollPane);
		
		receiptPrintOut.setText(order.toString());
		
		setAddState();
	}
	
	public void setButtonDisplay() {
		addFoodButton.setEnabled(addFoodState);
		addDrinkButton.setEnabled(addDrinkState);
		printReceiptButton.setEnabled(printReceiptState);
		clearOrderButton.setEnabled(clearState);
		
	}
	// when only add foods
	public void setAddState() {
		receiptPrintOut.setEditable(false);
		addFoodState = true;
		addDrinkState = true;
		printReceiptState = false;
		clearState = false;
		setButtonDisplay();
	}
	
	public void setPrintState() {
		receiptPrintOut.setEditable(false);
		addFoodState = true;
		addDrinkState = true;
		printReceiptState = true;
		clearState = true;
		setButtonDisplay();
	}
	
	private void addFood() {
		String foodName = JOptionPane.showInputDialog("What is the name of the food?");
		String foodCostString = JOptionPane.showInputDialog("What is the cost of the food?");
		double foodCost = Double.parseDouble(foodCostString);
		String mainIngredient = JOptionPane.showInputDialog("What is the main ingredient for this food?");
		FoodItem food = new FoodItem(foodName, foodCost, mainIngredient);
		order.addItemToOrder(food);
	}
	
	private void addDrink() {
		String drinkName = JOptionPane.showInputDialog("What is the name of the drink?");
		String drinkCostString = JOptionPane.showInputDialog("What is the cost of the drink?");
		double drinkCost = Double.parseDouble(drinkCostString);
		String sizeString = JOptionPane.showInputDialog("What is the size of the drink? (oz)");
		int size = Integer.parseInt(sizeString);
		DrinkItem drink = new DrinkItem(drinkName, drinkCost, size);
		order.addItemToOrder(drink);
	}
	
	private String receiptName() {
		String name = JOptionPane.showInputDialog("Please provide a name for this receipt? (.txt)");
		return name;
	}
	
	private class MyInner implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == addFoodButton) {
				addFood();
				receiptPrintOut.setText(order.toString());
				setPrintState();
			} else if (e.getSource() == addDrinkButton) {
				addDrink();
				receiptPrintOut.setText(order.toString());
				setPrintState();
			} else if (e.getSource() == printReceiptButton) {
				order.printReceipt(receiptName());
			} else if (e.getSource() == clearOrderButton) {
				order.clearOrder();
				receiptPrintOut.setText(order.toString());
			}
		}
	}
}
