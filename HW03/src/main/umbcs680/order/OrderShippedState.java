package umbcs680.order;

public class OrderShippedState implements OrderState {
    public void shipOrder(OrderContext context) { System.out.println("Already shipped."); }
    public void deliverOrder(OrderContext context) {
        System.out.println("Order delivered.");
        context.setState(new OrderDeliveredState());
    }
    public void returnOrder(OrderContext context) { System.out.println("Can't return. Order not delivered yet."); }
    public void refundOrder(OrderContext context) { System.out.println("Can't refund. Return not initiated."); }
}
