package mrSimModel;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 
 * @author Jiuzhou Wu
 *
 */
public class PartyOrderList {
	LinkedBlockingQueue<Party> partyOrderList;
	int n;
	
	public PartyOrderList(int n){
		// n means the number of tables
		this.partyOrderList = new LinkedBlockingQueue<Party>(n);
		n = 0;
	}
	
	public Party pickOrder(){
		n--;
		return partyOrderList.remove();
	}
	
	public boolean addOrder(Party order){
		boolean flag = false;
		if(partyOrderList.remainingCapacity() != 0){
			partyOrderList.add(order);
			n++;
			flag = true;
		}
		return flag;
	}
	
	public int getNumOfOrders(){
		return n;
	}
	
}
