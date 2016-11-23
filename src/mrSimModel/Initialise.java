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
		
		model.q_partyPayList = new PartyPayList();
		
		model.q_CustLine = new PartyWaitingList[2];
		
		model.q_CustLine[0] = new PartyWaitingList(); //large 
		
		model.q_CustLine[1] = new PartyWaitingList(); //small
		
		model.rg_tables = new Tables[2];
		
		model.rg_tables[0] = new Tables(model.numOfTables, model.rgTablesNum4T);
		
		model.rg_tables[0] = new Tables(model.numOfTables, model.rgTablesNum4T);
		
		model.rg_waiters = new Waiters(model.numOfWaiters);
		
		model.rg_cooks = new Cooks(model.numCooks);
		
		model.q_orders = new PartyOrderList(model.numOfTables-model.rgTablesNum4T);
		
		model.q_foodDy = new PartyDelFoodList(model.numOfTables-model.rgTablesNum4T);
	}
	
}
