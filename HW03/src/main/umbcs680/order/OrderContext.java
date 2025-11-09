package umbcs680.order;

public class OrderContext {
    private OrderState state;

    public OrderContext() {
        this.state = new OrderPlacedState();
        System.out.println("Order placed successfully.");
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public OrderState getState() {
        return state;
    }

    public void shipOrder() { state.shipOrder(this); }
    public void deliverOrder() { state.deliverOrder(this); }
    public void returnOrder() { state.returnOrder(this); }
    public void refundOrder() { state.refundOrder(this); }
}
