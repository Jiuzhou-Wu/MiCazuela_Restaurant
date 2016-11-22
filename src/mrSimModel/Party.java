package mrSimModel;

/*
 *  This consumer entity structure represents the party 
 *  arrive at the restaurant, being served, paying and then 
 *  leaving the restaurant
 */
public class Party {
	
	enum PartyScale{
		LARGE, SMALL
	}
	
	//attributes
	int uSize;
	PartyScale thisPartyScale;
	double startWait;
	double waitTime;
	
}
