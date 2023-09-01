// Jaye Ryden 48819841 Exam 3 CS 1341
import javax.swing.JFrame;
public class OrderGUILauncher {

	public static void main(String[] args) {
		
		OrderGUI orderGUILauncher = new OrderGUI();
		orderGUILauncher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		orderGUILauncher.setSize(500, 450);
		
		orderGUILauncher.setVisible(true);
	}

}
