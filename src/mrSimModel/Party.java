package mrSimModel;

import mrSimModel.Party.PartyScale;

/*
 *  This consumer entity structure represents the party 
 *  arrive at the restaurant, being served, paying and then 
 *  leaving the restaurant
 */
public class Party {
	//attributes
		int uSize;
		PartyScale thisPartyScale;
		double startWait;
		double waitTime;
	enum PartyScale{
		LARGE, SMALL
	}
	public Party(int uSize, double startWait){
		waitTime = 0;
		this.uSize = uSize;
		if (uSize < 3)
			thisPartyScale = PartyScale.SMALL;
		else
			thisPartyScale = PartyScale.LARGE;
	}
	
	
}
