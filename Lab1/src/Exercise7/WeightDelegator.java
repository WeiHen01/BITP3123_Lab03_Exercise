package Exercise7;

public class WeightDelegator {

public String calculateOnMars (String weightEarth) {
		
		// Parse input to float
		double kgEarth = Double.parseDouble(weightEarth);
		
		// Wrap in object
		Weight weight = new Weight();
		weight.setWeightEarth(kgEarth);
		
		// Calculate weight on Mars
		WeightCalc WeightCalculator = new WeightCalc();
		double kgMars = WeightCalculator.calculateMars(weight);
		
		// Format to two decimal places
		String weightMars = String.format("%.2f", kgMars); 
		return weightMars;
	}
}
