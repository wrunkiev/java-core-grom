package lesson7;

import java.util.Date;

public class DemoHomeWork {

    Order createOrder(){
        Order order = new Order(100, new Date(), false, null, "Dnepr", "Ukraine", "Buy");
        return order;
    }

    Order createOrderAndCallMethods(){
        Order order = new Order(100, new Date(), true, new Date(), "Kiev", "Ukraine", "SomeValue");
        order.checkPrice();
        order.confirmOrder();
        order.isValidType();
        return order;
    }
}
