package mrSimModel;

import java.util.ArrayList;

/**
 * The Class represents the Entity of PartyWaitingList,  is a Queue Set[2]
 * @author Zhijie Cui
 *
 */
public class PartyWaitingList {

	private ArrayList<Party> partyWaitingList = new ArrayList<Party>();
	
	private int n; //Num of entries in the list? Is is the length of the list, or the total number of party that enter the list.
	
	//private int maxCapacity; should there be a integer indicate the maximum capacity of the ArrayList.
	
	/**
	 * Constructor
	 */
	public PartyWaitingList()
	{
		//What should I do here??????
	}
	
	/**
	 * return the party with index 0 and remove it from the ArrayList. 
	 * @return Party Object with index 0.
	 */
	public Party nextParty()
	{
		Party nextParty = partyWaitingList.get(0);
		partyWaitingList.remove(0);
		return nextParty;
	}
	
	/**
	 * Add a new Party Object to the end of the ArrayList partyWaitingList.
	 * @param newParty The new arrival Party Object to be added to the end of the ArrayList partyWaitingList.
	 */
	public void newArrival(Party newParty)
	{
		// should check the capacity of the ArrayList?
		partyWaitingList.add(newParty);
	}
	
	/**
	 * Return the size of the ArrayList partyWaitingList.
	 * @return the size of the ArrayList partyWaitingList.
	 */
	public int sizeOf()
	{
		return this.partyWaitingList.size();
	}
}
