package Exercise7;

import Exercise8.WeightList;

public class WeightCalc {

	public double calculateMars (Weight weight) {
			
			double weightMars = (weight.getWeightEarth() / 9.81) * 3.11;
			return weightMars;
	}
	
	public void MarsDisplay(Weight weight)
	{
		System.out.println("Weight on Earth (kg): " + weight.getWeightEarth());
		System.out.println("Weight on Mars (kg): " + calculateMars(weight));
			
	}
	
	//For Exercise 8 to call this method
	public WeightList calcMars (WeightList weight2) {
		
		double weightMars = 0;
		
		// Calculate weights for all records
		for (Weight weight:weight2.getWeights()) {
			
			weightMars = this.calculateMars(weight);
			weight.setWeightMars(weightMars);
		}
		
		return weight2;
		
	}
	
}
