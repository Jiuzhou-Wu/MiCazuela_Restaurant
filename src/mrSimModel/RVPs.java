package mrSimModel;
import cern.jet.random.*;
import cern.jet.random.engine.MersenneTwister;

public class RVPs {
	MiCazuela_Restaurant model;
	
	//constants of model behaviors
	private final int MIN_NumberOfParty_PerDay = 30;
	private final int MAX_NumberOfParty_PerDay = 50;
	
	private final int MIN_partySize = 1;
	private final int MAX_partySize = 4;
	
	private static double MEAN1;
	private static double MEAN2;
	private static double MEAN3;
	private static double MEAN4;
	private static double MEAN5;
	
	//distributions
	private Uniform numberOfPartiesDistribution;
	
	private Uniform sizeOfParyDistribution;
	
	private Exponential intervalOfArrival;
	
	public RVPs(MiCazuela_Restaurant model, Seeds sd){
		this.model = model;
		numberOfPartiesDistribution = new Uniform(
				MIN_NumberOfParty_PerDay,
				MAX_NumberOfParty_PerDay,
				sd.numberOfParties_seed);
		sizeOfParyDistribution = new Uniform(
				MIN_partySize, 
				MAX_partySize, 
				sd.sizeOfParties_seed);
		
		int numberOfParties = numberOfPartiesDistribution.nextInt();
		
		MEAN1 = 60/(0.1*numberOfParties);
		MEAN2 = 60/(0.2*numberOfParties);
		MEAN3 = 120/(0.55*numberOfParties);
		MEAN4 = 60/(0.1*numberOfParties);
		MEAN5 = 60/(0.1*numberOfParties);
		model.output.numOfParty = numberOfParties;
		intervalOfArrival = new Exponential(1.0/MEAN1, new MersenneTwister(sd.intervalOfArrivals_seed));
	}
	
	protected double nextPartyArrivalAt(){
		double nxtTime;
		double mean;
			
		if (model.getClock() <= 60) mean = MEAN1;
		else if(model.getClock()<= 120) mean = MEAN2;
		else if(model.getClock()<= 240) mean = MEAN3;
		else if(model.getClock()<= 300) mean = MEAN4;
		else mean = MEAN5;
			
		nxtTime = model.getClock() + intervalOfArrival.nextDouble(1.0/mean);
			
		if (nxtTime > model.closingTime)
			nxtTime = -1.0; // Ends Time sequence
		
		return (nxtTime);
			
	}
	
	protected int nextPartySize(){
		return sizeOfParyDistribution.nextInt();
	}
}
