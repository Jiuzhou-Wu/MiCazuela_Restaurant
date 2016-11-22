package mrSimModel;

import cern.jet.random.engine.*;


public class Seeds 
{
	int intervalOfArrivals_seed;   // customer arrivals
	int numberOfParties_seed;
	int sizeOfParties_seed;
	
	public Seeds(RandomSeedGenerator rsg){    
		numberOfParties_seed = rsg.nextSeed();
		intervalOfArrivals_seed = rsg.nextSeed();
		sizeOfParties_seed = rsg.nextSeed();
	}
	
	
}