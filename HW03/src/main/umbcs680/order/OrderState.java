package umbcs680.order;

public interface OrderState {
    void shipOrder(OrderContext context);
    void deliverOrder(OrderContext context);
    void returnOrder(OrderContext context);
    void refundOrder(OrderContext context);
}
