package Orders;
import java.util.ArrayList;

public class TakeAwayOrder implements Orders {
    @Override
    public void OrderObject(ArrayList<String> OrdersList) {
        System.out.println("TakeAwayOrder" + " consists of " + OrdersList);
    }
}