package umbcs680.order;

public class OrderReturnedState implements OrderState {
    public void shipOrder(OrderContext context) { System.out.println("Can't ship. Order returned."); }
    public void deliverOrder(OrderContext context) { System.out.println("Can't deliver. Order returned."); }
    public void returnOrder(OrderContext context) { System.out.println("Already returned."); }
    public void refundOrder(OrderContext context) {
        System.out.println("Refund processed.");
        context.setState(new OrderRefundedState());
    }
}
