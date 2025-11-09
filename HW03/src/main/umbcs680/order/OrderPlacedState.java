package umbcs680.order;

public class OrderPlacedState implements OrderState {
    public void shipOrder(OrderContext context) {
        System.out.println("Order shipped.");
        context.setState(new OrderShippedState());
    }
    public void deliverOrder(OrderContext context) { System.out.println("Can't deliver. Order not shipped yet."); }
    public void returnOrder(OrderContext context) { System.out.println("Can't return. Order not delivered yet."); }
    public void refundOrder(OrderContext context) { System.out.println("Can't refund. Return not initiated."); }
}
