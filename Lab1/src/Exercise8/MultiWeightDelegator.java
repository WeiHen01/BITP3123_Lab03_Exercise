package Exercise8;

import java.util.ArrayList;
import java.util.StringTokenizer;

import Exercise7.Weight;
import Exercise7.WeightCalc;

public class MultiWeightDelegator {
public String calculateWeights (String earthWeights) {
		
		ArrayList<Weight> weights = new ArrayList<Weight>();
		
		// Tokenize data
		StringTokenizer tokens = new StringTokenizer(earthWeights, ";");
		while (tokens.hasMoreTokens()) {
			
			String data = tokens.nextToken();
			
			// Wrap data in object
			Weight weight = new Weight();
			weight.setWeightEarth(Double.parseDouble(data));
			
			// Add to list
			weights.add(weight);
			
		} 
		
		// Wrap in record
		WeightList record = new WeightList();
		record.setWeights(weights);
		
		// Calculate weight on Mars
		WeightCalc weightCalculator = new WeightCalc();
		record = weightCalculator.calcMars(record);
		
		// Format output
		String result = "";
		for (Weight weight:record.getWeights()) {
			
			result += "  Earth Weight: " + weight.getWeightEarth() + "kg \tMars Weight: " 
					+ String.format("%.2f", weight.getWeightMars()) + "kg\n";
			
		}
		
		return result;
	}
}
