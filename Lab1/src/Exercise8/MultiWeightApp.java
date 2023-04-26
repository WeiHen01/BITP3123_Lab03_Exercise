package Exercise8;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MultiWeightApp extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Declaration of GUI components to receive input from user
	JTextField txtEarthWeight = new JTextField(20);
	JTextField txtMarsWeight = new JTextField(20);
	JButton btnCalculate = new JButton("Calculate");
	
	// Declaration of GUI component to display result to the user
	JTextArea txtResult = new JTextArea(10,30);
	
	/**
	 * Constructor
	 * 
	 * Load components upon visible
	 */
	public MultiWeightApp () {
		
		this.setTitle("How much do you weight on Mars?");
		this.setSize(300, 500);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		loadComponents();
		
		// Register button to listener
		btnCalculate.addActionListener(this);
		
		
	}
	
	/**
	 * Oragnize the components into region in frame
	 */
	private void loadComponents() {
		
		JPanel dataPanel = this.loadDataComponents();
		this.add(dataPanel, BorderLayout.NORTH);
		
		JPanel resultPanel = this.loadResultComponents();
		this.add(resultPanel, BorderLayout.CENTER);
		
	}
	
	/**
	 * Arrange input GUI components 
	 * @return
	 */
	private JPanel loadDataComponents() {
		
		// Create components, override panel layout
		JPanel dataPanel = new JPanel();
		dataPanel.setLayout(new GridLayout(3, 1));
		
		JLabel lblWeight = new JLabel("  Enter weights. "
				+ "Separate the data using semi-colon (eg:- 78.5;60.2;) ");
		
		// Add to panel
		dataPanel.add(lblWeight);
		dataPanel.add(txtEarthWeight);
		dataPanel.add(btnCalculate);
		
		return dataPanel;
	}
	
	/**
	 * Arrange result GUI componenents
	 * @return
	 */
	private JPanel loadResultComponents() {
		
		// Create components
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(2, 1));
		
		JLabel label = new JLabel("  Your weight on Mars (kg): ");
		
		// Add to panel
		panel1.add(new JPanel());
		panel1.add(label);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(2, 1));
		panel2.add(panel1);
		panel2.add(txtResult);
		
		return panel2;
		
	}

	@Override
	/**
	 * Process user request.
	 */
	public void actionPerformed(ActionEvent e) {
		
		// Get weight in earth and removed entailing spaces
		String earthWeights = txtEarthWeight.getText().strip();
		
		// Calculate weight on Mars
		MultiWeightDelegator multiDelegator = new MultiWeightDelegator();
		String result = multiDelegator.calculateWeights(earthWeights);
		
		// Display weight on Mars
		txtResult.setText(result);
		txtResult.setEditable(false);
		
	}
	

}