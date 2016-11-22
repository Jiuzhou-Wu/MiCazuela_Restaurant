package mrSimModel;

import mrSimModel.Party.PartyScale;
import simulationModelling.ScheduledAction;

public class ScheduledAction_PartyArrivals extends ScheduledAction {

	MiCazuela_Restaurant model; 
	
	public ScheduledAction_PartyArrivals(MiCazuela_Restaurant model){
		
		this.model = model;
	}
	
	@Override
	protected double timeSequence() {
		// TODO Auto-generated method stub
		return model.rvp.nextPartyArrivalAt();
	}

	@Override
	protected void actionEvent() {
		// TODO Auto-generated method stub
		Party newParty = new Party();
		newParty.partySize = model.rvp.nextPartySize();
		if (newParty.partySize < 3)
			newParty.thisPartyScale = PartyScale.SMALL;
		else
			newParty.thisPartyScale = PartyScale.LARGE;
		newParty.startWait = model.getClock();
		newParty.waitTime = 0;
		model.qCustLine.add(newParty);
		model.output.numberOfArrivels++;
	}

}
