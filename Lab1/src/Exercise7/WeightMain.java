package Exercise7;

public class WeightMain {
	public static void main(String[] args) {
			
			System.out.println("Running Weight Application");
			
			WeightApp weightApplication = new WeightApp(); 
			
			// Put frame in the center
			weightApplication.pack();
			weightApplication.setLocationRelativeTo(null);
			weightApplication.setVisible(true);
			
			System.out.println("End of application");
	
	}
}
