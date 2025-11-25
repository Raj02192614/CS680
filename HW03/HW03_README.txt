Order Processing System 

Description:
For this assignment, I have designed an order processing system that simulates how an online order transitions through different stages — from being placed to shipped, delivered, returned, and refunded. Each stage reflects a real-world state of an order, and the system enforces what actions are allowed at each point (for example, an order can’t be refunded before it’s returned).

State Design Pattern Implementation:

OrderContext (Context Class):
This class keeps track of the current state of the order and delegates user actions like:
shipOrder(), 
deliverOrder(), 
returnOrder(),
refundOrder() 
to the current state object. 
It also handles state transitions internally.

OrderState (State Interface):
This interface defines the common set of actions an order can take.

Concrete State Classes:

OrderPlacedState: Order is placed and can move to shipped.
OrderShippedState: Order is shipped and can be delivered.
OrderDeliveredState: Order is delivered and eligible for return.
OrderReturnedState: Order is returned and eligible for refund.
OrderRefundedState: Final state; no further actions allowed.

State-dependent Behavior & Transitions:
Each state class implements behavior that makes sense for that stage. Invalid actions (like trying to refund an order that hasn’t been returned) are handled gracefully with appropriate messages. State transitions are dynamic — for example, once an order is shipped, its state changes to OrderShippedState.

Testing and Build:
I have included unit tests (OrderContextTest.java) to validate the behavior in each state and the transitions between them. An Ant build script (build.xml) is provided to compile the code and run tests, and Ivy (ivy.xml) is used to manage dependencies like JUnit.


This project demonstrates how the State design pattern can model real-world scenarios with dynamic behavior changes and encapsulated logic for each state.