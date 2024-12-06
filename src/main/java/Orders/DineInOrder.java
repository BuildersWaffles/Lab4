package Orders;
import java.util.ArrayList;

public class DineInOrder implements Orders {
    @Override
    public void OrderObject(ArrayList<String> OrdersList) {
        System.out.println("DineInOrder" + " consists of " + OrdersList);
    }
}