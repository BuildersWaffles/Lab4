package Orders;
import java.util.ArrayList;

public class DeliveryOrder implements Orders {
    @Override
    public void OrderObject(ArrayList<String> OrdersList) {
        System.out.println("DeliveryOrder" + " consists of " + OrdersList );
    }
}