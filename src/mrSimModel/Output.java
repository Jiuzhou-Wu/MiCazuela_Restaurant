package mrSimModel;

public class Output {
	
	int waitersEventOccurTimes;
	int cooksEventOccurTimes;
	
	int totalBusyWaiters;
	int totalBusyCooks;
	//DSOV
	double waiterUtilization;
	double cookUtilization;
	//SSOV
	int numOfParty;
	int numBalkParty;
	
	double numLongWait;
	double perPartyWait;
	double perBalkParty;
	
	public int getBalkNumber(){
		return this.numBalkParty;
	}
}

