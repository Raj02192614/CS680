package umbcs680.order;

public class OrderRefundedState implements OrderState {
    public void shipOrder(OrderContext context) { System.out.println("Order refunded. Can't ship."); }
    public void deliverOrder(OrderContext context) { System.out.println("Order refunded. Can't deliver."); }
    public void returnOrder(OrderContext context) { System.out.println("Order refunded. Can't return."); }
    public void refundOrder(OrderContext context) { System.out.println("Already refunded."); }
}
