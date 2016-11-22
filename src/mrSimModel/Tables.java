package mrSimModel;

import java.util.*;

import mrSimModel.Party.PartyScale;

/**
 * 
 * @author Haolong Zhang
 *
 */
public class Tables{
	
	int numTables;
	int num4T;
	LinkedList<Party> list;
	int n;
	
	public Tables(int numTables, int num4T){
		this.numTables = numTables;
		this.num4T = num4T;
		list = new LinkedList<Party>();
		n = 0;
	}
}
