package mrSimModel;


import simulationModelling.ScheduledAction;

public class Initialise extends ScheduledAction{

	MiCazuela_Restaurant model;
		
		// Constructor
	public Initialise(MiCazuela_Restaurant model) { this.model = model; }

	double [] ts = { 0.0, -1.0 }; // -1.0 ends scheduling
	int tsix = 0;  // set index to first entry.
	public double timeSequence() 
	{
		return ts[tsix++];  // only invoked at t=0
	}

	@Override
	protected void actionEvent() {
		model.output = new Output();
		
		model.partyPayList = new PartyPayList();
		
		model.qCustLine = new PartyWaitingList();
		
		model.rg_cooks = new Cooks(model.numCooks);
		
		model.orders = new PartyOrderList(model.numOfTables-model.rgTablesNum4T);
		
		model.foodDy = new PartyDelFoodList(model.numOfTables-model.rgTablesNum4T);
	}
	
}
