package mrSimModel;

import java.util.ArrayList;

/**
 * The Class represent the 
 * @author Zhijie Cui
 *
 */
public class PartyPayList {

	private ArrayList<Party> partyPayList = new ArrayList<Party>();
	
	private int n; // what does the n means or we can use a getter to get the size of the ArrayList
	
	/**
	 * Constructor
	 */
	public PartyPayList()
	{
		//???
	}
	
	/**
	 * Return and remove the Party Object with index 0 in the ArrayList partyPayList.
	 * @return the Party Object with index 0 in the ArrayList partyPayList.
	 */
	public Party nextParty()
	{
		Party nextParty = partyPayList.get(0);
		partyPayList.remove(0);
		return nextParty;
	}
	
	
	/**
	 * Add a new Party Object to the end of the ArrayList.
	 * @param newParty the new Party Object to be added to the end of the ArrayList.
	 */
	public void newParty(Party newParty)
	{
		partyPayList.add(newParty);
	}
	
	/**
	 * Get the ArrayList Size.
	 * @return The size of the ArrayList.
	 */
	public int sizeOf()
	{
		return partyPayList.size(); 
	}
}
