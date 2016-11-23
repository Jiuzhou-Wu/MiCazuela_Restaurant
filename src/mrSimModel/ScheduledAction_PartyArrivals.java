package mrSimModel;


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
		
		int uSize = model.rvp.nextPartySize();
		Party newParty = new Party(uSize, model.getClock());
		
		newParty.startWait = model.getClock();
		System.out.println(newParty.uSize);
		System.out.println(newParty.uSize < 3);
		if (newParty.uSize < 3){
			if (model.q_CustLine[1].sizeOf() == model.partyWaitingList_cap){
				model.output.numBalkParty++;
				return;
			} 
			model.q_CustLine[1].newParty(newParty);
		}
		else{
			
			if (model.q_CustLine[0].sizeOf() == model.partyWaitingList_cap){
				model.output.numBalkParty++;
				return;
			} 
			model.q_CustLine[0].newParty(newParty);
		}
			
		
	}

}
