package umbcs680.order;

public class OrderDeliveredState implements OrderState {
    public void shipOrder(OrderContext context) { System.out.println("Already delivered. Can't ship again."); }
    public void deliverOrder(OrderContext context) { System.out.println("Already delivered."); }
    public void returnOrder(OrderContext context) {
        System.out.println("Order returned.");
        context.setState(new OrderReturnedState());
    }
    public void refundOrder(OrderContext context) { System.out.println("Return required for refund."); }
}
