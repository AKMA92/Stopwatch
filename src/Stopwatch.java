import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;

public class Stopwatch {

	private JFrame frame;
	private JTextField secondMinCounter;
	private JTextField firstMinCounter;
	private JTextField pointText;
	private JTextField secondSekCounter;
	private JTextField firstSekCounter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stopwatch window = new Stopwatch();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Stopwatch() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		secondMinCounter = new JTextField();
		secondMinCounter.setEditable(false);
		secondMinCounter.setBounds(81, 60, 36, 80);
		frame.getContentPane().add(secondMinCounter);
		secondMinCounter.setColumns(10);
		
		firstMinCounter = new JTextField();
		firstMinCounter.setEditable(false);
		firstMinCounter.setColumns(10);
		firstMinCounter.setBounds(127, 60, 36, 80);
		frame.getContentPane().add(firstMinCounter);
		
		pointText = new JTextField();
		pointText.setEditable(false);
		pointText.setFont(new Font("Tahoma", Font.PLAIN, 80));
		pointText.setText(":");
		pointText.setColumns(10);
		pointText.setBounds(192, 60, 36, 80);
		frame.getContentPane().add(pointText);
		
		secondSekCounter = new JTextField();
		secondSekCounter.setEditable(false);
		secondSekCounter.setColumns(10);
		secondSekCounter.setBounds(253, 60, 36, 80);
		frame.getContentPane().add(secondSekCounter);
		
		firstSekCounter = new JTextField();
		firstSekCounter.setEditable(false);
		firstSekCounter.setColumns(10);
		firstSekCounter.setBounds(304, 60, 36, 80);
		frame.getContentPane().add(firstSekCounter);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.setBounds(74, 182, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Stop");
		btnNewButton_1.setBounds(251, 182, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}
