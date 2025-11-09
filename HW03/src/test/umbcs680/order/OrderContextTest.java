package umbcs680.order;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class OrderContextTest {

    @Test
    public void testOrderPlacedStateBehavior() {
        OrderContext order = new OrderContext();
        assertTrue(order.getState() instanceof OrderPlacedState);

        order.deliverOrder();
        order.returnOrder();
        order.refundOrder();
        order.shipOrder();
        assertTrue(order.getState() instanceof OrderShippedState);
    }

    @Test
    public void testOrderShippedStateBehavior() {
        OrderContext order = new OrderContext();
        order.shipOrder(); // Transition to Shipped
        assertTrue(order.getState() instanceof OrderShippedState);

        order.returnOrder();
        order.refundOrder();
        order.deliverOrder();
        assertTrue(order.getState() instanceof OrderDeliveredState);
    }

    @Test
    public void testOrderDeliveredStateBehavior() {
        OrderContext order = new OrderContext();
        order.shipOrder();
        order.deliverOrder();
        assertTrue(order.getState() instanceof OrderDeliveredState);

        order.shipOrder();
        order.refundOrder();
        order.returnOrder();
        assertTrue(order.getState() instanceof OrderReturnedState);
    }

    @Test
    public void testOrderReturnedStateBehavior() {
        OrderContext order = new OrderContext();
        order.shipOrder();
        order.deliverOrder();
        order.returnOrder();
        assertTrue(order.getState() instanceof OrderReturnedState);

        order.shipOrder();
        order.deliverOrder();
        order.refundOrder();
        assertTrue(order.getState() instanceof OrderRefundedState);
    }

    @Test
    public void testOrderRefundedStateBehavior() {
        OrderContext order = new OrderContext();
        order.shipOrder();
        order.deliverOrder();
        order.returnOrder();
        order.refundOrder();
        assertTrue(order.getState() instanceof OrderRefundedState);


        order.shipOrder();
        order.deliverOrder();
        order.returnOrder();
        order.refundOrder();

        assertTrue(order.getState() instanceof OrderRefundedState);
    }
}
