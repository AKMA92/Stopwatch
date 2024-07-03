import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Stopwatch {

	private JFrame frame;
	private JTextField secondMinCounterText;
	private JTextField firstMinCounterText;
	private JTextField pointText;
	private JTextField secondSekCounterText;
	private JTextField firstSekCounterText;
	private int secondMinCounterInt;
	private int firstMinCounterInt ;
	private int secondSekCounterInt;
	private int firstSekCounterInt;
	private boolean isOn;
	private JButton resetButton;
	private JButton startButton;
	private JButton stopButton;
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
		firstSekCounterInt = 0;
		secondSekCounterInt = 0;
		firstMinCounterInt = 0;
		secondMinCounterInt = 0;
		isOn = false;
		setTextNull();
	}
	
	
	
	private void setTextNull() {
		firstSekCounterText.setText(String.valueOf(firstSekCounterInt));
		secondSekCounterText.setText(String.valueOf(secondSekCounterInt));
		firstMinCounterText.setText(String.valueOf(firstMinCounterInt));
		secondMinCounterText.setText(String.valueOf(secondMinCounterInt));



	}
	
	private void start() {
	    isOn = true;
	    Thread thread = new Thread(new Runnable() {
	        public void run() {
	            while (isOn) {
	            	if (firstSekCounterInt < 9) {
		               firstSekCounterInt++;
		               firstSekCounterText.setText(String.valueOf(firstSekCounterInt)); // Diese Zeile simuliert das Aktualisieren der GUI.

	                } else if( secondSekCounterInt == 5 && firstSekCounterInt == 9){
	                	firstSekCounterInt = 0;
	                	firstSekCounterText.setText(String.valueOf(firstSekCounterInt));
	                	secondSekCounterInt = 0;
	                	secondSekCounterText.setText(String.valueOf(secondSekCounterInt));
	                	firstMinCounterInt++;
	                	firstMinCounterText.setText(String.valueOf(firstMinCounterInt));
	                	
	                }
	            	
	                else if (firstSekCounterInt >= 9) {
	                	firstSekCounterInt = 0;
	                	firstSekCounterText.setText(String.valueOf(firstSekCounterInt));
	                	secondSekCounterInt++;
	                	secondSekCounterText.setText(String.valueOf(secondSekCounterInt));

	                }
	                try {
	                	Thread.sleep(100);
	                } catch (InterruptedException e) {
	                    Thread.currentThread().interrupt(); 
	                }
	            }
	        }
	    });
	    thread.start(); // Startet den Thread.
	}

	
	private void stop() {
		isOn = false;
	}
	private void reset() {
		stop();
		firstSekCounterInt = 0;
        firstSekCounterText.setText(String.valueOf(firstSekCounterInt)); // Diese Zeile simuliert das Aktualisieren der GUI.

		secondSekCounterInt = 0;
    	secondSekCounterText.setText(String.valueOf(secondSekCounterInt));

		firstMinCounterInt = 0;
		secondMinCounterInt = 0;
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		secondMinCounterText = new JTextField();
		secondMinCounterText.setFont(new Font("Tahoma", Font.PLAIN, 50));
		secondMinCounterText.setEditable(false);
		secondMinCounterText.setBounds(81, 60, 36, 80);
		frame.getContentPane().add(secondMinCounterText);
		secondMinCounterText.setColumns(10);
		
		firstMinCounterText = new JTextField();
		firstMinCounterText.setFont(new Font("Tahoma", Font.PLAIN, 50));
		firstMinCounterText.setEditable(false);
		firstMinCounterText.setColumns(10);
		firstMinCounterText.setBounds(127, 60, 36, 80);
		frame.getContentPane().add(firstMinCounterText);
		
		pointText = new JTextField();
		pointText.setEditable(false);
		pointText.setFont(new Font("Tahoma", Font.PLAIN, 80));
		pointText.setText(":");
		pointText.setColumns(10);
		pointText.setBounds(192, 60, 36, 80);
		frame.getContentPane().add(pointText);
		
		secondSekCounterText = new JTextField();
		secondSekCounterText.setFont(new Font("Tahoma", Font.PLAIN, 50));
		secondSekCounterText.setEditable(false);
		secondSekCounterText.setColumns(10);
		secondSekCounterText.setBounds(253, 60, 36, 80);
		frame.getContentPane().add(secondSekCounterText);
		
		firstSekCounterText = new JTextField();
		firstSekCounterText.setFont(new Font("Tahoma", Font.PLAIN, 50));
		firstSekCounterText.setEditable(false);
		firstSekCounterText.setColumns(10);
		firstSekCounterText.setBounds(304, 60, 36, 80);
		frame.getContentPane().add(firstSekCounterText);
		
		startButton = new JButton("Start");
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				start();
			}
		});
		startButton.setBounds(74, 182, 89, 23);
		frame.getContentPane().add(startButton);
		
		stopButton = new JButton("Stop");
		stopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isOn = false;
			}
		});
		stopButton.setBounds(251, 182, 89, 23);
		frame.getContentPane().add(stopButton);
		
		resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		resetButton.setBounds(165, 216, 89, 23);
		frame.getContentPane().add(resetButton);
	}
}
