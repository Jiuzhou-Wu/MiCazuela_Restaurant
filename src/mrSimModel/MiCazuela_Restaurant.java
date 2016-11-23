package mrSimModel;



import java.util.ArrayList;


import simulationModelling.AOSimulationModel;
import simulationModelling.Behaviour;


public class MiCazuela_Restaurant extends AOSimulationModel{

	// References to RVP and DVP objects
	protected RVPs rvp; // Reference to rvp object
	protected Seeds sd;
	
	// Output object
	protected Output output;
	//system end time
	protected double closingTime;
	//model parameter 
	protected PartyWaitingList qCustLine; // Line
	protected Cooks rg_cooks;
	
	//model constants 
	protected static final int numCooks = 2;
	
	protected PartyOrderList orders;
	
	protected int numOfTables = 11;
	
	protected int rgTablesNum4T = 4;

	protected PartyPayList partyPayList;
	//system parameter
	protected boolean traceFlag;
	
	
	
	public MiCazuela_Restaurant(double t0time, double tftime, Seeds sd, boolean traceFlag){
		
		
		
		this.traceFlag = traceFlag;
		this.sd = sd;
		initAOSimulModel(t0time, tftime+60);
		this.closingTime = tftime;
		this.rvp = new RVPs(this, this.sd);
		Initialise init = new Initialise(this);
		scheduleAction(init);
		ScheduledAction_PartyArrivals arrival = new ScheduledAction_PartyArrivals(this);
		scheduleAction(arrival);
	}
	
	@Override
	protected void testPreconditions(Behaviour behObj) {
		this.reschedule(behObj);
		
		//TODO test all of the pre-conditionals
	}
	
	public Output getOutput(){
		return this.output;
	}
	
	public void eventOccured() {
		// PriorityQueue<SBNotice> sbl = this.getCopySBL();
		// kkShowSBL(sbl);
		if(traceFlag)
		{
			 		
		}
		 //
	}
}
