package mrSimModel;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 
 * @author Jiuzhou Wu
 *
 */
public class PartyDelFoodList {
	LinkedBlockingQueue<Party> FoodDyList;
	int n;
	
	public PartyDelFoodList(int n){
		// n means the number of tables
		this.FoodDyList = new LinkedBlockingQueue<Party>(n);
		n = 0;
	}
	
	public Party FoodReadyDy(){
		n--;
		return FoodDyList.remove();
	}
	
	public boolean foodNeedCook(Party order){
		boolean flag = false;
		if(FoodDyList.remainingCapacity() != 0){
			FoodDyList.add(order);
			n++;
			flag = true;
		}
		return flag;
	}
	
	public int getNumOfOrders(){
		return n;
	}
}
