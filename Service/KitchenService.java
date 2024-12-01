package Service;
import Orders.*;

public class KitchenService {
	public void processOrder(Orders order) {
		System.out.println("processing " + order.getClass().getSimpleName()); 
	}
}
