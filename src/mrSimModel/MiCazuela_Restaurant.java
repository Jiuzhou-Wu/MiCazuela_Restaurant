package mrSimModel;



import java.util.ArrayList;


import simulationModelling.AOSimulationModel;
import simulationModelling.Behaviour;


public class MiCazuela_Restaurant extends AOSimulationModel{
	protected ArrayList<Party> qCustLine; // Line

	// References to RVP and DVP objects
	protected RVPs rvp; // Reference to rvp object
	
	// Output object
	protected Output output = new Output();
	
	protected double closingTime;
	
	protected boolean traceFlag;
	
	public MiCazuela_Restaurant(double t0time, double tftime, Seeds sd, boolean traceFlag){
		
		this.rvp = new RVPs(this, sd);
		
		this.output = new Output();
		
		this.qCustLine = new ArrayList<Party>();
		
		this.traceFlag = traceFlag;
		
		initAOSimulModel(t0time, tftime+60);
		this.closingTime = tftime;
		
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
			 System.out.println("Clock at: "+getClock()+
	                    ", Q.CustLine.n: "+qCustLine.size());
			 showSBL();			
		}
		 //
	}
}
